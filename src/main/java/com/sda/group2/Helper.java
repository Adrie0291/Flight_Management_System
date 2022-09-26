package com.sda.group2;

import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int choiceValidation() {
        int choice;
        do {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Incorrect input!\nTry again!");
                scanner.nextLine();
            }
        } while (true);
        return choice;
    }
}
