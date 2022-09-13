package com.sda.group2.frontend;

import com.sda.group2.hibernate.hql.Account;
import com.sda.group2.hibernate.hql.Administrator;
import com.sda.group2.hibernate.hql.Assistant;

import java.util.LinkedList;
import java.util.List;

public class CreateUserOptions {
    public static List<UserOption> optionList(Account account) {
        List<UserOption> optionList = new LinkedList<UserOption>();

        if (account instanceof Administrator) {
            optionList.add(null);
        } else if (account instanceof Assistant) {
            optionList.add(null);
        } else {
            optionList.add(null);
        }

        return optionList;
    }
}
