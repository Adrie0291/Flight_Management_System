package com.sda.group2.optioninterfaces.options.assistant;

import com.sda.group2.DataBaseService;
import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.Complaint;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerService implements UserOption {
    private boolean back = false;

    @Override
    public void invoke(Account account) {
        do {
            List<UserOption> list = new ArrayList<>();

            list.add(new GetListOfComplaints());
            list.add(new RespondToComplaint());
            list.add(new Back());

            Helper.getMenuController().buildInteractiveMenu(account, list);
        }
        while (!back);
    }

    private class GetListOfComplaints implements UserOption{

        @Override
        public void invoke(Account account) {
            List<Complaint> complaints = Helper.getDataBaseService().getListOfComplaint();
            for (Complaint c: complaints) {
                System.out.println(c);
            }
        }

        @Override
        public String getMethodName() {
            return "Get list of complaints";
        }
    }

    private class RespondToComplaint implements UserOption{

        @Override
        public void invoke(Account account) {
            try {
                List<Complaint> complaints = Helper.getDataBaseService().getListOfComplaint();
                long id = 0;
                System.out.println("Please provide flight number:");
                String flightNumber = Helper.getNextLine();
                for (Complaint c : complaints) {
                    if (c.getFlightNumber().equals(flightNumber)) {
                        id = c.getId();
                    }
                }
                System.out.println("Answer: ");
                String answer = Helper.getNextLine();
                Helper.getDataBaseService().respondToComplaint(id, answer);
            } catch (NullPointerException e){
                System.out.println("Wrong flight number!");
            }
        }

        @Override
        public String getMethodName() {
            return "Respond to complaint";
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
        return "User services";
    }
}
