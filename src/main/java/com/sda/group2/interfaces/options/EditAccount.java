package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.MenuController;
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
            list.add(new ChangeFirstName());
            list.add(new ChangeLastName());
            list.add(new ChangeEmail());
            list.add(new ChangePassword());
            list.add(new Back());

            MenuController menuController = new MenuController();
            menuController.buildInteractiveMenu(account, list);
        }
        while (!back);
    }

    private static class ChangeFirstName implements UserOption {
        @Override
        public void invoke(Account account) {
            Scanner sc = new Scanner(System.in);
            System.out.println("###############################");
            System.out.println("Please input your new first name: ");
            do {
                if (sc.hasNextLine()) {
                    String newFirstName = sc.nextLine();
                    DataBaseService dtb = new DataBaseService();
                    dtb.changeFirstName(newFirstName, account.getAccountId());
                    break;
                }
            } while (true);
        }

        @Override
        public String getMethodName() {
            return "Change first name";
        }
    }

    //tutaj
    private static class ChangeLastName implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner sc = new Scanner(System.in);
            System.out.println("###############################");
            System.out.println("Please input your new last name: ");
            do {
                if (sc.hasNextLine()) {
                    String newLastName = sc.nextLine();
                    DataBaseService dtb = new DataBaseService();
                    dtb.changeLastName(newLastName, account.getAccountId());
                    break;
                }
            } while (true);
        }

        @Override
        public String getMethodName() {
            return "Change last name";
        }
    }

    //tutaj
    @Override
    public String getMethodName() {
        return "Change account details";
    }

    private static class ChangeEmail implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner sc = new Scanner(System.in);
            System.out.println("###############################");
            System.out.println("Please input your new email: ");
            do {
                if (sc.hasNextLine()) {
                    String newEmail = sc.nextLine();
                    if (newEmail.matches("\\b.+[@]\\w+[.]\\w+\\b")) {
                        DataBaseService dtb = new DataBaseService();
                        dtb.changeEmail(newEmail, account.getAccountId());
                        break;
                    } else {
                        System.out.println("Incorrect email structure!");
                    }
                }
            } while (true);
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
            System.out.println("###############################");
            System.out.println("Please input your new password: ");
            do {
                if (sc.hasNextLine()) {
                    String newPassword = sc.nextLine();
                    if (!newPassword.isEmpty()) {
                        DataBaseService dtb = new DataBaseService();
                        dtb.changePassword(newPassword, account.getAccountId());
                        break;
                    } else {
                        System.out.println("Password cannot be empty!\nPlease try again!\n");
                    }
                }
            } while (true);
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
