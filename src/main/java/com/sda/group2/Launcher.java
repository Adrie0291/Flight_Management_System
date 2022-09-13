package com.sda.group2;

import com.sda.group2.hibernate.hql.Account;
import com.sda.group2.hibernate.hql.Administrator;

public class Launcher {
 public static void main(String[] args) {
        Controller controller = new Controller();

        Account admin = new Administrator(); // admin account created "na sztywno"

        controller.start();
    }
}
