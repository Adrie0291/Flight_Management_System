package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

public class ShowWallet implements UserOption {
    @Override
    public void invoke(Account account) {
        DataBaseService dtb = new DataBaseService();
        dtb.showWallet(account);
    }

    @Override
    public String getMethodName() {
        return "Show wallet";
    }
}

