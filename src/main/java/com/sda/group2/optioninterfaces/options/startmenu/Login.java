package com.sda.group2.optioninterfaces.options.startmenu;

import com.sda.group2.controllers.Controller;
import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

public class Login implements UserOption {

    @Override
    public void invoke(Account account) {
        System.out.println("Email:");
        String email = Helper.getNextLine();

        System.out.println("Password:");
        String password = Helper.getNextLine();

        account = Helper.getLrs().login(email, password);

        checkLoginSuccess(account, account != null);
    }

    private void checkLoginSuccess(Account account, boolean x) {
        if (x) {
            Controller.isLoggedIn = true;
            Controller.account = account;
            System.out.println("You manage to successfully log in.");
        } else {
            System.out.println("Account with given email and password do not exist.");
        }
    }

    @Override
    public String getMethodName() {
        return "Login";
    }
}
