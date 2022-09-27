package com.sda.group2.optioninterfaces.options.user;

import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.Complaint;
import com.sda.group2.hibernate.hql.ComplaintType;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileAComplaint implements UserOption {
    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();
            list.add(new FileAComplain());
            list.add(new AskForRefund());
            list.add(new ViewYourIssues());
            list.add(new Back());

            Helper.getMenuController().buildInteractiveMenu(account, list);
        }
        while (!back);
    }


    private class FileAComplain implements UserOption {

        @Override
        public void invoke(Account account) {
            System.out.println("Please enter your flight number:");
            String flightNumber = Helper.getNextLine();
            System.out.println("Please enter your ticket number:");
            String ticketNumber = Helper.getNextLine();
            System.out.println("Please describe your issue:");
            String message = Helper.getNextLine();
            Complaint complaint = new Complaint(flightNumber,ticketNumber,message,account.getEmail(),ComplaintType.COMPLAINT);
            Helper.getDataBaseService().sendAComplaint(complaint);
        }

        @Override
        public String getMethodName() {
            return "File a complaint";
        }
    }

    private class AskForRefund implements UserOption {

        @Override
        public void invoke(Account account) {
            Helper.getNextLine();
            System.out.println("Please enter your flight number:");
            String flightNumber = Helper.getNextLine();
            System.out.println("Please enter your ticket number:");
            String ticketNumber = Helper.getNextLine();
            System.out.println("Please describe your issue:");
            String message = Helper.getNextLine();
            Complaint complaint = new Complaint(flightNumber,ticketNumber,message,account.getEmail(),ComplaintType.REFUND);
            Helper.getDataBaseService().sendAComplaint(complaint);
        }

        @Override
        public String getMethodName() {
            return "Ask for refund";
        }
    }

    private class ViewYourIssues implements UserOption{

        @Override
        public void invoke(Account account) {
            List<Complaint> complaints = Helper.getDataBaseService().getListOfComplaint();
            for (Complaint c: complaints) {
                if (Objects.equals(c.getSender(), account.getEmail())){
                    System.out.println(c);
                }
            }
        }

        @Override
        public String getMethodName() {
            return "View your Complaints";
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
