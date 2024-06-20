package dev.khaliuk.ccshell.handler;

public class Type implements Handler {
    @Override
    public String handle(String[] arguments) {
        HandlerFactory.Command command;

        try {
            command = HandlerFactory.Command.valueOf(arguments[1].toUpperCase());
        } catch (IllegalArgumentException e) {
            return "%s: not found%n".formatted(arguments[1]);
        }

        return "%s is a shell builtin%n".formatted(arguments[1]);
    }
}
