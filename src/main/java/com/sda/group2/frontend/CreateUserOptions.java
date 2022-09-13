package com.sda.group2.frontend;

import com.sda.group2.Account;
import com.sda.group2.Admin;
import com.sda.group2.Assistant;

import java.util.LinkedList;
import java.util.List;

public class CreateUserOptions {
    public static List<UserOption> optionList(Account account) {
        List<UserOption> optionList = new LinkedList<>();

        if (account instanceof Admin) {
            optionList.add(null);
        } else if (account instanceof Assistant) {
            optionList.add(null);
        } else {
            optionList.add(null);
        }

        return optionList;
    }
}
