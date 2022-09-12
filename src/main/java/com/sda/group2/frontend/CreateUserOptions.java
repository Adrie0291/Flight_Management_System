package com.sda.group2.frontend;

import java.util.LinkedList;
import java.util.List;

public class CreateUserOptions {
    protected static List<UserOption> optionList(Account account) {
        List<UserOption> optionList = new LinkedList<>();
        optionList.add(null);

        if (Enum.valueOf(account.getRole()) <= 1) {
            optionList.add(null);
        }

        return optionList;
    }
}
