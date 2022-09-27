package com.sda.group2.optioninterfaces.options.common;

import com.sda.group2.controllers.Controller;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

public class Logout implements UserOption {
    @Override
    public void invoke(Account account) {
        Controller.isLoggedIn = false;
    }

    @Override
    public String getMethodName() {
        return "Logout"; //tutaj jest nazwa która wyświetla się w menu
    }

    //Ogólnie cała przestrzeń do rozwijania danej opcji
}
