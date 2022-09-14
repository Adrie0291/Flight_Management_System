package com.sda.group2;

import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Admin;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.Scanner;

// Jedyna klasa, która używa sout i scanner
public class Controller {
    private final Scanner scanner = new Scanner(System.in);
    private final LoginRegisterService lrs = new LoginRegisterService();

    public void start() {
        Admin admin = new Admin("admin@gmail.com", "silnehaslo", "Jan", "Kowal");
        lrs.createNewAdminAccount(admin);
        // First menu on the beginning of the program.
        Account account = startMenu();
        // Next menu for specific user
        mainMenu(account);
    }

    private Account startMenu() {
        Account account;
        do {
            printLoginRegisterMenu();
            int input = scanner.nextInt();
            scanner.nextLine();
            account = loginRegisterOptions(input);
        } while (account == null);
        return account;
    }

    private void mainMenu(Account account) {
        do {
            // TODO Implement menu based on the Role of the Account.
            throw new NotYetImplementedException("Main Menu is not yet implemented.");
        } while (true);
    }

    private void printLoginRegisterMenu() {
        System.out.println("""
                1. Login
                2. Register""");
    }

    private Account loginRegisterOptions(int input) {
        switch (input) {
            case 1 -> {
                return loginOption();
            }
            case 2 -> {
                registerOption();
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

        lrs.registerNewUser(firstName, lastname, email, password);
        //TODO logging in to the new account just after registration
    }

    private Account loginOption() {
        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Password:");
        String password = scanner.nextLine();

        Account account = lrs.login(email, password);
        printLoginSuccess(account != null);
        return account;
    }

    private void printLoginSuccess(boolean x) {
        if (x)
            System.out.println("You manage to successfully log in.");
        else
            System.out.println("Account with given email and password do not exist.");
    }
}
