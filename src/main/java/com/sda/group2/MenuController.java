package com.sda.group2;

import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Admin;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.hibernate.hql.users.User;
import com.sda.group2.interfaces.UserOption;

import java.util.List;

public class MenuController {

    public void mainMenu(Account account) {
        //----------------------- v pobieranie listy
        List<UserOption> optionList;
        if (account instanceof Assistant) {
            optionList = ((Assistant) account).getOptions();
        } else if (account instanceof Admin) {
            optionList = ((Admin) account).getOptions();
        } else {
            optionList = ((User) account).getOptions();
        }
        menuInteractionBuilder(account, optionList);
    }

    public void menuInteractionBuilder(Account account, List<UserOption> optionList) {
        //------------------------ v printowanie listy
        printMainMenu(optionList);
        //------------------------ v użycie wybranej opcji
        optionChoice(account, optionList);
    }

    public void printMainMenu(List<UserOption> list) {
        System.out.println("###############################");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + " - " + list.get(i).getMethodName());
        }
    }

    private void optionChoice(Account account, List<UserOption> list) {
        int choice = Helper.choiceValidation();
        if (choice <= list.size()) {
            list.get(choice - 1).invoke(account);
        }
    }
}
