package com.sda.group2.interfaces.options;

import com.sda.group2.LoginRegisterService;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.interfaces.UserOption;

import java.util.Scanner;


public class AssistantCreation implements UserOption {
    @Override
    public void invoke(Account account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter e-mail: ");
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter lastname: ");
        String lastname = scanner.nextLine();
        new LoginRegisterService().createNewAccount(new Assistant(email,password,name,lastname));
    }

    @Override
    public String getMethodName() {
        return "Create assistant account";
    }
}
