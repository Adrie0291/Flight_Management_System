package com.sda.group2;


import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Plane;

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
            throw new FlightMappingException("Bad file format for line: " + line, line);
        }
    }
    // Airports


    public List<Airport> readAirports(String filename) throws FlightMappingException, FileDBNotConnectionException {
        List<Airport> airportsList = new ArrayList<>();
        File file = null;

        try {
            //"src\\main\\resources\\airports.txt"
            file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Airport airport = mapLineToAirport(line);
                airportsList.add(airport);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return airportsList;
    }

    private Airport mapLineToAirport(String line) throws FlightMappingException {
        try {
            String[] elements = line.split(";");
            String airportCountry = elements[0].trim();
            String airportShortcut = elements[1].trim();

            return new Airport(airportCountry, airportShortcut);
        } catch (Exception exception) {
            //throw new Exception("Niepoprawny format pliku!!!! dla linii: " + line);
            throw new FlightMappingException("Bad file format for line: " + line, line);
        }
    }


    // Planes


    public List<Plane> readPlanes(String filename) throws FlightMappingException, FileDBNotConnectionException {
        List<Plane> planesList = new ArrayList<>();
        File file = new File(filename);

        //"src\\main\\resources\\planes.txt"
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Plane plane = mapLineToPlane(line);
                planesList.add(plane);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
        return planesList;
    }

    //Boeing 747;SwissAir;200
    private Plane mapLineToPlane(String line) throws FlightMappingException {
        try {
            String[] elements = line.split(";");
            String planeType = elements[0].trim();
            String planeCompany = elements[1].trim();
            int planeSeats = Integer.parseInt(elements[2].trim());

            return new Plane(planeType, planeCompany, planeSeats);
        } catch (Exception exception) {
            //throw new Exception("Niepoprawny format pliku!!!! dla linii: " + line);
            throw new FlightMappingException("Bad file format for line: " + line, line);
        }
    }
}