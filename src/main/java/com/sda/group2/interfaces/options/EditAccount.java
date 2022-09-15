package com.sda.group2.interfaces.options;

import com.sda.group2.Controller;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditAccount implements UserOption {

    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new ChangeEmail());
            list.add(new ChangePassword());
            list.add(new Back());

            Controller.mainMenuCreate(account, list);
        }
        while (!back);
    }

    @Override
    public String getMethodName() {
        return "Change account details";
    }

    private static class ChangeEmail implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner sc = new Scanner(System.in);
            System.out.println("##################");
            System.out.println("Please input your new email: ");
            do{
                if(sc.hasNextLine()) {
                    String newEmail = sc.nextLine();
                    if (newEmail.matches("\\b.+[@]\\w+[.]\\w+\\b")) {
                        //TODO update z SQL
                        break;
                    } else {
                        System.out.println("Incorrect email structure!");
                    }
                }
            }while(true);
        }

        @Override
        public String getMethodName() {
            return "Change email";
        }
    }

    private static class ChangePassword implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner sc = new Scanner(System.in);
            System.out.println("##################");
            System.out.println("Please input your new password: ");
            do{
                if(sc.hasNextLine()) {
                    String newPassword = sc.nextLine();
                    if (!newPassword.isEmpty()) {
                        //TODO update z SQL
                        break;
                    } else {
                        System.out.println("Password cannot be empty!\nPlease try again!\n");
                    }
                }
            }while(true);
        }

        @Override
        public String getMethodName() {
            return "Change password";
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
