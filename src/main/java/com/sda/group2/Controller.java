package com.sda.group2;

import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Admin;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.hibernate.hql.users.User;
import com.sda.group2.interfaces.UserOption;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Jedyna klasa, która używa sout i scanner
public class Controller {
    private static final Scanner scanner = new Scanner(System.in);
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
            int input = optionChoice();
            account = loginRegisterOptions(input);
        } while (account == null);
        return account;
    }

    private void mainMenu(Account account) {

        do {
            //----------------------- v pobieranie listy
            List<UserOption> optionList;
            if (account instanceof Assistant) {
                optionList = ((Assistant) account).getOptions();
            } else if (account instanceof Admin) {
                optionList = ((Admin) account).getOptions();
            } else {
                optionList = ((User) account).getOptions();
            }
            mainMenuCreate(account, optionList);
        } while (true); //todo static boolean do wylogowania się
    }

    public static void mainMenuCreate(Account account, List<UserOption> list) {
        //------------------------ v printowanie listy
        System.out.println("###############################");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + " - " + list.get(i).getMethodName());
        }
        //------------------------ v użycie wybranej opcji
        int choice = optionChoice();
        if (choice <= list.size()) {
            list.get(choice - 1).invoke(account);
        }
    }

    private static void printLoginRegisterMenu() {
        System.out.println("""
                1. Login
                2. Register
                3. Exit program""");
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
            case 3 -> {
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

        lrs.registerNewUser(firstName, lastname, email, password);
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

    private static int optionChoice() {
        int choice;
        do {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Incorrect input!\nTry again!");
                scanner.nextLine();
                printLoginRegisterMenu();
            }
        } while (true);
        return choice;
    }
}
