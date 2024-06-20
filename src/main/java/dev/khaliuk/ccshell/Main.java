package dev.khaliuk.ccshell;

import dev.khaliuk.ccshell.handler.Handler;
import dev.khaliuk.ccshell.handler.HandlerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        var handlerFactory = new HandlerFactory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();

            var arguments = input.split(" ");
            var handler = handlerFactory.getHandler(arguments);
            var result = handler.handle(arguments);

            System.out.print(result);
        }
    }
}
