package com.sda.group2.optioninterfaces.options.user;

import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.Complaint;
import com.sda.group2.hibernate.hql.ComplaintType;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileAComplaint implements UserOption {
    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new fileAComplain());
            list.add(new askForRefund());
            list.add(new Back());

            Helper.getMenuController().buildInteractiveMenu(account, list);
        }
        while (!back);
    }


    private class fileAComplain implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please describe your issue, remember to provide your flight number!");
            Complaint complaint = new Complaint(scanner.nextLine(), account.getEmail(), ComplaintType.COMPLAINT);
            Helper.getDataBaseService().sendAComplaint(complaint);
        }

        @Override
        public String getMethodName() {
            return "File a complaint";
        }
    }

    private class askForRefund implements UserOption {

        @Override
        public void invoke(Account account) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Provide flight number, date and reason");
            Complaint complaint = new Complaint(scanner.nextLine(), account.getEmail(), ComplaintType.REFUND);
            Helper.getDataBaseService().sendAComplaint(complaint);
        }

        @Override
        public String getMethodName() {
            return "Ask for refund";
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

    @Override
    public String getMethodName() {
        return "File a complaint or ask for refund";
    }
}
