package com.sda.group2.optioninterfaces.options.user;

import com.sda.group2.DataBaseService;
import com.sda.group2.controllers.MenuController;
import com.sda.group2.hibernate.hql.Message;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageMethodUser implements UserOption {
    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new SendMessage());
            list.add(new PanelMessage());
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

    private static class SendMessage implements UserOption {
        @Override
        public void invoke(Account account) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Write your message to Assistant: ");
            String text = scn.nextLine();
            DataBaseService dtb = new DataBaseService();
            Message message1 = new Message(text);
            dtb.SendMessage(account, message1);
        }

        @Override
        public String getMethodName() {
            return "Send Message to Assistant";
        }
    }


    private static class PanelMessage implements UserOption {
        @Override
        public void invoke(Account account) {
            DataBaseService dtb = new DataBaseService();
            int number = account.getAccountId();
            dtb.receiveMessage(number);
        }

        @Override
        public String getMethodName() {
            return "Message Panel";
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