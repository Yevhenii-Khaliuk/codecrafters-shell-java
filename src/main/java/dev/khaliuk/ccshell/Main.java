package dev.khaliuk.ccshell;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();

            System.out.printf("%s: command not found%n", input);
        }
    }
}
