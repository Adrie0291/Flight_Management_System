package com.sda.group2.optioninterfaces.options.startmenu;

import com.sda.group2.controllers.Controller;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

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
