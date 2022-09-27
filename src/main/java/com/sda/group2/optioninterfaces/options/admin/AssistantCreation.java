package com.sda.group2.optioninterfaces.options.admin;

import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.optioninterfaces.UserOption;

public class AssistantCreation implements UserOption {
    @Override
    public void invoke(Account account) {
        System.out.println("Enter e-mail: ");
        String email = Helper.getNextLine();

        System.out.println("Enter password: ");
        String password = Helper.getNextLine();

        System.out.println("Enter name: ");
        String name = Helper.getNextLine();

        System.out.println("Enter lastname: ");
        String lastname = Helper.getNextLine();

        Helper.getLrs().createNewAccount(new Assistant(email, password, name, lastname));
    }

    @Override
    public String getMethodName() {
        return "Create assistant account";
    }
}
