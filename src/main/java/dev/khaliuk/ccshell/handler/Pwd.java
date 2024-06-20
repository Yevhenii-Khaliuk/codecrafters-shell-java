package dev.khaliuk.ccshell.handler;

public class Pwd implements Handler {
    @Override
    public String handle(String[] arguments) {
        return System.getProperty("user.dir")
            + "\n";
    }
}
