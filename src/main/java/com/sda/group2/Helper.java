package com.sda.group2;

import com.sda.group2.controllers.LoginRegisterService;
import com.sda.group2.controllers.MenuController;

import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);
    private static final LoginRegisterService lrs = new LoginRegisterService();
    private static final DataBaseService dataBaseService = new DataBaseService();
    private static final MenuController menuController = new MenuController();

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

    public static DataBaseService getDataBaseService() {
        return dataBaseService;
    }

    public static MenuController getMenuController() {
        return menuController;
    }
}
