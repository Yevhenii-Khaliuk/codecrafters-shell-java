package dev.khaliuk.ccshell.handler;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Echo implements Handler {
    @Override
    public String handle(String[] arguments) {
        return Arrays.stream(arguments, 1, arguments.length)
            .collect(Collectors.joining(" "))
            + "%n";
    }
}
