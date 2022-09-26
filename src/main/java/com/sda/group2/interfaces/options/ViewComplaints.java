package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

public class ViewComplaints implements UserOption {
    @Override
    public void invoke(Account account) {
        DataBaseService dataBaseService = new DataBaseService();
        dataBaseService.getListOfComplaint();
    }

    @Override
    public String getMethodName() {
        return "Get list of complaints";
    }
}
