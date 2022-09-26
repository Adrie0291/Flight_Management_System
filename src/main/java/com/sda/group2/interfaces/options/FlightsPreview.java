package com.sda.group2.interfaces.options;

import com.sda.group2.AirportController;
import com.sda.group2.DataBaseService;
import com.sda.group2.FlightController;
import com.sda.group2.PlaneController;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Plane;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.interfaces.UserOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlightsPreview implements UserOption {


    @Override
    public void invoke(Account account) {
        try {
            //Scanner scanner = new Scanner(System.in);
            //String filename = scanner.nextLine();

            // title
            System.out.println("Show all flights: ");
            DataBaseService dtb = new DataBaseService();
            List<Flight> flights = dtb.showFlights();

            for (Flight flight : flights) {
                System.out.println(flight);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMethodName() {
        return "Flights preview option";
    }


}
