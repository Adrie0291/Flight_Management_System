package com.sda.group2;

import com.sda.group2.exceptions.BuildMenuClassInstanceNotFoundException;
import com.sda.group2.hibernate.hql.users.*;
import com.sda.group2.interfaces.UserOption;

import java.util.List;

public class MenuController {

    public void buildMenu(Account account) {
        //----------------------- v pobieranie listy
        List<UserOption> optionList;
        if (account instanceof Assistant) {
            optionList = account.getOptions();
        } else if (account instanceof Admin) {
            optionList = account.getOptions();
        } else if (account instanceof User) {
            optionList = account.getOptions();
        } else if (account instanceof StartMenuUser) {
            optionList = account.getOptions();
        } else {
            throw new BuildMenuClassInstanceNotFoundException("Account class not recognized!");
        }
        buildInteractiveMenu(account, optionList);
    }

    public void buildInteractiveMenu(Account account, List<UserOption> optionList) {
        //------------------------ v printowanie listy
        printMenu(optionList);
        //------------------------ v użycie wybranej opcji
        optionChoice(account, optionList);
    }

    public void printMenu(List<UserOption> list) {
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
