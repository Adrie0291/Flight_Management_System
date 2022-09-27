package com.sda.group2.optioninterfaces.options.startmenu;

import com.sda.group2.Helper;
import com.sda.group2.controllers.LoginRegisterService;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.User;
import com.sda.group2.optioninterfaces.UserOption;

public class Register implements UserOption {
    @Override
    public void invoke(Account account) {
        String firstName, lastName, email, password;
        do {
            System.out.println("First name:");
            firstName = Helper.getNextLine();
        } while (firstName.isEmpty());

        do {
            System.out.println("Last name:");
            lastName = Helper.getNextLine();
        } while (lastName.isEmpty());

        do {
            System.out.println("E-mail:");
            email = Helper.getNextLine();
        } while (Helper.getLrs().checkEmail(email));

        do {
            System.out.println("Password:");
            password = Helper.getNextLine();
        } while (password.isEmpty());

        Helper.getLrs().createNewAccount(new User(firstName, lastName, email, password));
    }

    @Override
    public String getMethodName() {
        return "Register";
    }
}
