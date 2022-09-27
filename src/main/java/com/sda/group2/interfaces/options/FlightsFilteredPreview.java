package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.Helper;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

import java.util.List;

public class FlightsFilteredPreview implements UserOption {
    @Override
    public void invoke(Account account) {
        //String filename = scanner.nextLine();

        // title
        System.out.println("Filter arrival flights by: ");
        String arrival = Helper.getNextLine();

        System.out.println("Filter departure flights by: ");
        String departure = Helper.getNextLine();
        try {
            DataBaseService dtb = new DataBaseService();
            List<Flight> flights = dtb.showFilteredFlights(arrival, departure);

            for (Flight flight : flights) {
                System.out.println(flight);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMethodName() {
        return "Filter flights option";
    }
}
