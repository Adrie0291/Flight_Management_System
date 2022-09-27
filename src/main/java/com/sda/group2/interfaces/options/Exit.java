package com.sda.group2.interfaces.options;

import com.sda.group2.Controller;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

public class Exit implements UserOption {
    @Override
    public void invoke(Account account) {
        Controller.isProgramLive = false;
    }

    @Override
    public String getMethodName() {
        return "Exit";
    }
}
