package com.sda.group2.interfaces.options;

import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.User;
import com.sda.group2.interfaces.UserOption;

public class Register implements UserOption {
    @Override
    public void invoke(Account account) {
        System.out.println("Name:");
        String firstName = Helper.getNextLine();

        System.out.println("Last name:");
        String lastname = Helper.getNextLine();

        System.out.println("Email:");
        String email = Helper.getNextLine();

        System.out.println("Password:");
        String password = Helper.getNextLine();

        Helper.getLrs().createNewAccount(new User(firstName, lastname, email, password));
    }

    @Override
    public String getMethodName() {
        return "Register";
    }
}
