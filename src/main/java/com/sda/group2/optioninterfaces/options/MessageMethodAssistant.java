package com.sda.group2.optioninterfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.controllers.MenuController;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageMethodAssistant implements UserOption {
    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new MessagePanelAssistant());
            list.add(new WriteTheAnswer());
            list.add(new Back());

            MenuController menuController = new MenuController();
            menuController.buildInteractiveMenu(account, list);
        }
        while (!back);
    }

    @Override
    public String getMethodName() {
        return "Message options";
    }

    private static class MessagePanelAssistant implements UserOption {
        @Override
        public void invoke(Account account) {
            DataBaseService dtb = new DataBaseService();
            dtb.receiveMessage();
        }

        @Override
        public String getMethodName() {
            return "Message Panel Assistant";
        }
    }

    private static class WriteTheAnswer implements UserOption {
        @Override
        public void invoke(Account account) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write ID message do you want to answer");
            int number = scanner.nextInt();
            System.out.println("Write answer: ");
            scanner.nextLine();
            String answer = scanner.nextLine();
            DataBaseService dtb = new DataBaseService();
            dtb.answerToMessage(account, number, answer);
        }

        @Override
        public String getMethodName() {
            return "Write the answer";
        }
    }

    private class Back implements UserOption {
        @Override
        public void invoke(Account account) {
            back = !back;
        }

        @Override
        public String getMethodName() {
            return "Back";
        }
    }
}
