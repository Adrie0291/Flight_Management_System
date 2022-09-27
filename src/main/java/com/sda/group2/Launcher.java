package com.sda.group2;

import com.sda.group2.controllers.AirportController;
import com.sda.group2.controllers.Controller;
import com.sda.group2.controllers.FlightController;
import com.sda.group2.controllers.PlaneController;
import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Plane;

public class Launcher {
    public static void main(String[] args) {
        /* tutaj wrzucamy do bazy dane z pliku flights.txt, airports.txt, planes.txt
         * todo: ładowanie dowolnego pliku csv po podaniu nazwy pliku z menu
         */
        FlightController flightController = new FlightController("flights.txt");
        flightController.loadFlightsIntoDb(Flight.loadFlightsFromFileIntoArray(flightController.getFilename()));
        AirportController airportController = new AirportController("airports.txt");
        airportController.loadAirportsIntoDb(Airport.loadAirportsFromFileIntoArray(airportController.getFilename()));
        PlaneController planeController = new PlaneController("planes.txt");
        planeController.loadPlanesIntoDb(Plane.loadPlanesFromFileIntoArray(planeController.getFilename()));

        Controller controller = new Controller();

        controller.start();
        HibernateUtil.shutdown();
    }
}
