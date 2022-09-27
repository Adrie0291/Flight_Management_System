package com.sda.group2;

import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Admin;
import com.sda.group2.hibernate.hql.users.StartMenuUser;

public class Controller {
    public static boolean isLoggedIn = false;
    public static boolean isProgramLive = true;

    public static Account account;

    public void start() {
        Helper.getLrs().createNewAccount(new Admin("admin@gmail.com", "silnehaslo", "Jan", "Kowal"));
        MenuController menuController = new MenuController();
        do {
            // First menu on the beginning of the program.
            account = new StartMenuUser();
            do {
                // Next menu for specific user
                menuController.buildMenu(account);
            } while (isLoggedIn);
        } while (isProgramLive);
    }
}
