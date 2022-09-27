package com.sda.group2.optioninterfaces.options.admin;

import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.optioninterfaces.UserOption;

public class AssistantCreation implements UserOption {
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

        Helper.getLrs().createNewAccount(new Assistant(email, password, firstName, lastName));
    }

    @Override
    public String getMethodName() {
        return "Create assistant account";
    }
}
