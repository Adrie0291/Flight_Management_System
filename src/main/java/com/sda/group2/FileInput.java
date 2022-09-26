package com.sda.group2;

import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;
import com.sda.group2.hibernate.hql.Flight;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput {
    public List<Flight> readFlights(String filename) throws FlightMappingException, FileDBNotConnectionException {
        List<Flight> flightsList = new ArrayList<>();
        File file;

        try {
            //"src\\main\\resources\\flights.txt"
            file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Flight flight = mapLineToFlight(line);
                flightsList.add(flight);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return flightsList;
    }

    private Flight mapLineToFlight(String line) throws FlightMappingException {
        try {
            String[] elements = line.split(";");
            String flightNumber = elements[0].trim();
            String arrivalAirportId = elements[1].trim();
            String departureAirportId = elements[2].trim();
            // LocalDateTime
            LocalTime arrivalTime = LocalTime.parse(elements[3].trim());
            LocalTime departureTime = LocalTime.parse(elements[4].trim());

            return new Flight(flightNumber, arrivalAirportId, departureAirportId, arrivalTime, departureTime);
        } catch (Exception exception) {
            //throw new Exception("Niepoprawny format pliku!!!! dla linii: " + line);
            throw new FlightMappingException("Incorrect file format!!! For line: " + line, line);
        }
    }
}