package dev.khaliuk.ccshell.handler;

import java.io.File;
import java.nio.file.Paths;

import static dev.khaliuk.ccshell.Constants.USER_WORKING_DIRECTORY_PROPERTY;

public class Cd implements Handler {
    @Override
    public String handle(String[] arguments) {
        if (arguments[1].startsWith("/")) {
            var directory = new File(arguments[1]).getAbsoluteFile();

            if (directory.exists()) {
                return updateWorkingDirectory(directory);
            }
        } else {
            var rawPath = "%s/%s".formatted(System.getProperty(USER_WORKING_DIRECTORY_PROPERTY), arguments[1]);
            var directory = Paths.get(rawPath).normalize().toFile();

            if (directory.exists()) {
                return updateWorkingDirectory(directory);
            }
        }

        return "cd: %s: No such file or directory%n".formatted(arguments[1]);
    }

    private String updateWorkingDirectory(File directory) {
        System.setProperty(USER_WORKING_DIRECTORY_PROPERTY, directory.getAbsolutePath());
        return "";
    }
}
