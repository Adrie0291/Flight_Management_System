package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Flight;

public class Launcher {
    public static void main(String[] args) {
        /* tutaj wrzucamy do bazy dane z pliku flights.txt
        * todo: ładowanie dowolnego pliku csv po podaniu nazwy pliku z menu
         */
        FlightController flightController = new FlightController("src\\main\\resources\\flights.txt");
        flightController.loadFlightsIntoDb(Flight.loadFlightsFromFileIntoArray(flightController.getFilename()));

        Controller controller = new Controller();


        controller.start();



        HibernateUtil.shutdown();
    }
}
