package com.sda.group2;

import java.util.Scanner;

// Jedyna aplikacja, która używa sout i scanner
public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private LoginRegisterController lrc = new LoginRegisterController();
    public void start(){
        do {
            printLoginRegisterMenu();
            int input = scanner.nextInt();
            scanner.nextLine();
            getOption(input);
        } while (true);
    }

    private void printLoginRegisterMenu() {
        System.out.println("""
                1. Login
                2. Register""");
    }

    private void getOption(int input) {
        switch (input) {
            case 1 -> {
                System.out.println("Email:");
                String email = scanner.nextLine();

                System.out.println("Password:");
                String password = scanner.nextLine();

                lrc.login(email, password);
            }
            case 2 -> {
                System.out.println("Name:");
                String firstName = scanner.nextLine();

                System.out.println("Last name:");
                String lastname = scanner.nextLine();

                System.out.println("Email:");
                String email = scanner.nextLine();

                System.out.println("Password:");
                String password = scanner.nextLine();

                lrc.registerNewUser(firstName, lastname, email, password);
            }
            default -> System.out.println("Try again.");
        }
    }
}
