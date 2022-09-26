package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Admin;
import com.sda.group2.hibernate.hql.users.User;

import java.util.Scanner;

public class Controller {
    private static final Scanner scanner = new Scanner(System.in);
    private final LoginRegisterService lrs = new LoginRegisterService();
    // TODO it has no function. We can add it to the do-while in startMenu() function.
    public static boolean loggedIn = false;

    public void start() {
        createAdmin();
        // TODO For now we are exiting program in one point - startMenuOptions() method which allows to close the program.
        do {
            // First menu on the beginning of the program.
            Account account = startMenu();
            do {
                MenuController menuController = new MenuController();
                // Next menu for specific user
                menuController.mainMenu(account);
            } while (loggedIn);
        } while (true);
    }

    private void createAdmin() {
        Admin admin = new Admin("admin@gmail.com", "silnehaslo", "Jan", "Kowal");
        lrs.createNewAccount(admin);
    }

    private Account startMenu() {
        Account account;
        do {
            printStartMenu();
            int input = optionChoice();
            account = startMenuOptions(input);
        } while (account == null);
        return account;
    }

    private void printStartMenu() {
        System.out.println("""
                1. Login
                2. Register
                3. Exit program""");
    }

    private Account startMenuOptions(int input) {
        switch (input) {
            case 1 -> {
                return loginOption();
            }
            case 2 -> {
                registerOption();
                return null;
            }
            case 3 -> {
                HibernateUtil.shutdown();
                System.exit(0);
                return null;
            }
            default -> {
                System.out.println("Try again.");
                return null;
            }
        }
    }

    private void registerOption() {
        System.out.println("Name:");
        String firstName = scanner.nextLine();

        System.out.println("Last name:");
        String lastname = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Password:");
        String password = scanner.nextLine();

        lrs.createNewAccount(new User(firstName, lastname, email, password));
    }

    private Account loginOption() {
        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Password:");
        String password = scanner.nextLine();

        Account account = lrs.login(email, password);
        printLoginSuccess(account != null);
        loggedIn = true;
        return account;
    }

    private void printLoginSuccess(boolean x) {
        if (x)
            System.out.println("You manage to successfully log in.");
        else
            System.out.println("Account with given email and password do not exist.");
    }

    private int optionChoice() {
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
