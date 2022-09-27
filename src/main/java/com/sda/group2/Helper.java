package com.sda.group2;

import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LoginRegisterService lrs = new LoginRegisterService();

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

    public static String getNextLine() {
        return scanner.nextLine();
    }

    public static LoginRegisterService getLrs() {
        return lrs;
    }
}
