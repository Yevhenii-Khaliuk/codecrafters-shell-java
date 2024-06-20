package dev.khaliuk.ccshell.handler;

import java.nio.file.Paths;

public class Pwd implements Handler {
    @Override
    public String handle(String[] arguments) {
        return Paths.get("")
            .toAbsolutePath()
            .toString();
    }
}
