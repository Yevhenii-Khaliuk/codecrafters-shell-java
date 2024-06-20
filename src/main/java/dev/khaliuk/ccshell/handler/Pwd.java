package dev.khaliuk.ccshell.handler;

import static dev.khaliuk.ccshell.Constants.USER_WORKING_DIRECTORY_PROPERTY;

public class Pwd implements Handler {
    @Override
    public String handle(String[] arguments) {
        return System.getProperty(USER_WORKING_DIRECTORY_PROPERTY)
            + "\n";
    }
}
