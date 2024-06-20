package dev.khaliuk.ccshell.handler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Type implements Handler {
    @Override
    public String handle(String[] arguments) {
        if (isBuiltin(arguments[1])) {
            return "%s is a shell builtin".formatted(arguments[1]);
        }

        return executablePath(arguments[1]);
    }

    private boolean isBuiltin(String command) {
        try {
            HandlerFactory.Command.valueOf(command.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private String executablePath(String command) {
        var paths = System.getenv("PATH").split(":");

        for (String path : paths) {
            try (Stream<Path> stream = Files.list(Paths.get(path))) {
                var commandFound = stream.filter(file -> !Files.isDirectory(file))
                    .filter(file -> file.getFileName().toString().equals(command))
                    .findFirst()
                    .map(Path::toString);

                if (commandFound.isPresent()) {
                    return "%s is %s".formatted(command, commandFound.get());
                }
            } catch (IOException e) {
                // do nothing
            }
        }

        return "%s: not found".formatted(command);
    }
}
