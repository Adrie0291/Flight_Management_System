package com.sda.group2.interfaces.options;

import com.sda.group2.DataBaseService;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

import java.util.List;
import java.util.Scanner;

public class FlightsFilteredPreview implements UserOption {
    @Override
    public void invoke(Account account) {
        try {
            Scanner scanner = new Scanner(System.in);
            //String filename = scanner.nextLine();

            // title
            System.out.println("Filter arrival flights by: ");
            String arrival = scanner.nextLine();

            System.out.println("Filter departure flights by: ");
            String departure = scanner.nextLine();

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
