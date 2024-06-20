package dev.khaliuk.ccshell.handler;

import java.io.File;

public class Cd implements Handler {
    @Override
    public String handle(String[] arguments) {
        var directory = new File(arguments[1]).getAbsoluteFile();

        if (directory.exists()) {
            System.setProperty("user.dir", directory.getAbsolutePath());
            return "";
        } else {
            return "cd: %s: No such file or directory%n".formatted(arguments[1]);
        }
    }
}
