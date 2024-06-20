package dev.khaliuk.ccshell.handler;

public class Exit implements Handler {
    @Override
    public String handle(String[] arguments) {
        System.exit(0);

        return null;
    }
}
