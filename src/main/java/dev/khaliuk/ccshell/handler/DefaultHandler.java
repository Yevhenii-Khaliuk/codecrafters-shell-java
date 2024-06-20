package dev.khaliuk.ccshell.handler;

import java.io.IOException;
import java.util.stream.Collectors;

public class DefaultHandler implements Handler {
    @Override
    public String handle(String[] arguments) {
        try {
            return new ProcessBuilder(arguments)
                .start()
                .inputReader()
                .lines()
                .collect(Collectors.joining("%n"));
        } catch (IOException e) {
            return "%s: command not found".formatted(String.join(" ", arguments));
        }
    }
}
