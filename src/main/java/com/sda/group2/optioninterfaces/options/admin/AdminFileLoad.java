package com.sda.group2.optioninterfaces.options.admin;

import com.sda.group2.*;
import com.sda.group2.controllers.AirportController;
import com.sda.group2.controllers.FlightController;
import com.sda.group2.controllers.PlaneController;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Plane;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.optioninterfaces.UserOption;

public class AdminFileLoad implements UserOption {

    public void invoke(Account account) {
        try {
            // title
            System.out.println("Load file with flights from file into database: ");
            // load flights
            System.out.println("Enter file name for flights (flights.txt): ");
            String filename = Helper.getNextLine();
            FlightController flightController = new FlightController(filename);
            flightController.loadFlightsIntoDb(Flight.loadFlightsFromFileIntoArray(flightController.getFilename()));

            // load airports
            System.out.println("Enter file name for airports (airports.txt): ");
            filename = Helper.getNextLine();
            AirportController airportController = new AirportController(filename);
            airportController.loadAirportsIntoDb(Airport.loadAirportsFromFileIntoArray(airportController.getFilename()));

            // load planes
            System.out.println("Enter file name for planes (planes.txt): ");
            filename = Helper.getNextLine();
            PlaneController planeController = new PlaneController(filename);
            planeController.loadPlanesIntoDb(Plane.loadPlanesFromFileIntoArray(planeController.getFilename()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getMethodName() {
        return "Load files (flights, airports, planes) option.";
    }

}
