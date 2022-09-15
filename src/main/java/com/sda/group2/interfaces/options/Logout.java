package com.sda.group2.interfaces.options;

import com.sda.group2.Controller;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

public class Logout implements UserOption {
    @Override
    public void invoke(Account account) {
        Controller.loggedIn = false; //todo póki co do testowania, trzeba przemyśleć formę
    }

    @Override
    public String getMethodName() {
        return "Logout"; //tutaj jest nazwa która wyświetla się w menu
    }

    //Ogólnie cała przestrzeń do rozwijania danej opcji
}
