package com.sda.group2.frontend;

import com.sda.group2.hibernate.hql.Account;

public class OptionHandler {
    public void optionHandler(String userOption, Account account){
        for (UserOption option:CreateUserOptions.optionList(account)) {
            if(option.getName().equals(userOption)){
                option.execute(account);
            }
        }
        System.out.println("Option not found!");
        //return do menu
    }
}
