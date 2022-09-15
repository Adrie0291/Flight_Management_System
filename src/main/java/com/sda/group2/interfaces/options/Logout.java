package com.sda.group2.interfaces.options;

import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

public class Logout implements UserOption {
    @Override
    public void invoke(Account account) {
        System.out.println("Tymczasowy placeholder wzorcowy, w tym miejscu jest działanie po wybraniu opcji");
    }

    @Override
    public String getMethodName() {
        return "Logout"; //tutaj jest nazwa która wyświetla się w menu
    }

    //Ogólnie cała przestrzeń do rozwijania danej opcji
}
