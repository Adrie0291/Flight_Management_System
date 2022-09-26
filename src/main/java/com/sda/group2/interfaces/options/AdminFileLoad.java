package com.sda.group2.interfaces.options;

import com.sda.group2.AirportController;
import com.sda.group2.FlightController;
import com.sda.group2.LoginRegisterService;
import com.sda.group2.PlaneController;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Plane;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.Assistant;
import com.sda.group2.interfaces.UserOption;

import java.util.Scanner;

public class AdminFileLoad implements UserOption {

    public void invoke(Account account) {
        try {
            Scanner scanner = new Scanner(System.in);
            // title
            System.out.println("Load file with flights from file into database: ");
            // load flights
            System.out.println("Enter file name for flights (flights.txt): ");
            String filename = scanner.nextLine();
            FlightController flightController = new FlightController(filename);
            flightController.loadFlightsIntoDb(Flight.loadFlightsFromFileIntoArray(flightController.getFilename()));

            // load airports
            System.out.println("Enter file name for airports (airports.txt): ");
            filename = scanner.nextLine();
            AirportController airportController = new AirportController(filename);
            airportController.loadAirportsIntoDb(Airport.loadAirportsFromFileIntoArray(airportController.getFilename()));

            // load planes
            System.out.println("Enter file name for planes (planes.txt): ");
            filename = scanner.nextLine();
            PlaneController planeController = new PlaneController(filename);
            planeController.loadPlanesIntoDb(Plane.loadPlanesFromFileIntoArray(planeController.getFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMethodName() {
        return "Create file load option";
    }

}
