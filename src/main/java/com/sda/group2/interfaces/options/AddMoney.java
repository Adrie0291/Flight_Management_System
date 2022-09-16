package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

import java.util.Scanner;

public class AddMoney implements UserOption {
    @Override
    public void invoke(Account account) {
        System.out.println("How much do you want to deposit? ");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt() + account.getWallet();
        if (money <= 0 || money >= 50000) {
            System.out.println("You can add only 1-50000 zl");
        } else {
            DataBaseService dtb = new DataBaseService();

            dtb.addMoney(account, money);
            System.out.println("Transaction was successful");
        }
    }

    @Override
    public String getMethodName() {
        return "Add money";
    }
}

