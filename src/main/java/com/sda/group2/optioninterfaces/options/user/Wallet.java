package com.sda.group2.optioninterfaces.options.user;

import com.sda.group2.DataBaseService;
import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wallet implements UserOption {

    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new Wallet.Balance());
            list.add(new Wallet.Deposit());
            list.add(new Wallet.Withdraw());
            list.add(new Wallet.Back());

            Helper.getMenuController().buildInteractiveMenu(account, list);
        }
        while (!back);
    }

    @Override
    public String getMethodName() {
        return "Wallet";
    }

    private class Balance implements UserOption {
        @Override
        public void invoke(Account account) {
            Helper.getDataBaseService().showWallet(account);
        }

        @Override
        public String getMethodName() {
            return "Balance";
        }
    }

    public class Deposit implements UserOption {
        @Override
        public void invoke(Account account) {
            System.out.println("Amount to deposit: ");
            Scanner scanner = new Scanner(System.in);
            do {
                if (scanner.hasNextDouble()) {
                    double money = scanner.nextDouble() + account.getWallet();
                    if (money > 100000) {
                        System.out.println("Maximum balance is 100000 PLN!\nOperation cancelled!");
                    } else if (money < 0) {
                        System.out.println("You cannot deposit negative value!\nOperation cancelled!");
                    } else {
                        Helper.getDataBaseService().setBalance(account, money);
                        System.out.println("Success!");
                    }
                    break;
                } else {
                    scanner.nextLine();
                }
            } while (true);
        }

        @Override
        public String getMethodName() {
            return "Deposit";
        }
    }

    private class Withdraw implements UserOption {
        @Override
        public void invoke(Account account) {
            System.out.println("Amount to withdraw: ");
            Scanner scanner = new Scanner(System.in);
            do {
                if (scanner.hasNextDouble()) {
                    double money = account.getWallet() - scanner.nextDouble();
                    if (money < 0) {
                        System.out.println("Not enough funds!\nOperation cancelled!");
                    } else {
                        Helper.getDataBaseService().setBalance(account, money);
                        System.out.println("Success!");
                    }
                    break;
                } else {
                    scanner.nextLine();
                }
            } while (true);
        }

        @Override
        public String getMethodName() {
            return "Withdraw";
        }
    }

    private class Back implements UserOption {

        @Override
        public void invoke(Account account) {
            back = !back;
        }

        @Override
        public String getMethodName() {
            return "Back";
        }
    }
}
