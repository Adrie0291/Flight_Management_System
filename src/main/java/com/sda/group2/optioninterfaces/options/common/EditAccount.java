package com.sda.group2.optioninterfaces.options.common;

import com.sda.group2.DataBaseService;
import com.sda.group2.Helper;
import com.sda.group2.controllers.MenuController;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

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
                    if (!Helper.getLrs().checkEmail(newEmail)) {
                        Helper.getDataBaseService().changeEmail(newEmail, account.getAccountId());
                        break;
                    }
                    System.out.println("Enter new email again!");
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
                        Helper.getDataBaseService().changePassword(newPassword, account.getAccountId());
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
