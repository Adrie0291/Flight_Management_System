package com.sda.group2;

import com.sda.group2.hibernate.hql.Account;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Jedyna aplikacja, która używa sout i scanner
public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private LoginRegisterController lrc = new LoginRegisterController();
    public void start(){
        do {
            printLoginRegisterMenu();
            int input = scanner.nextInt();
            getOption(input);
        } while (true);
    }

    private void printLoginRegisterMenu() {
        System.out.println("""
                1. Login
                2. Register""");
    }

    private void getOption(int input) {
        switch (input){
            case 1:
                System.out.println("Input email and password:");
                String emailAndPassword = scanner.nextLine();
                lrc.login("", "");
                break;
            case 2:
                lrc.register();
                break;
            default:
                System.out.println("Try again.");
        }
    }
}
