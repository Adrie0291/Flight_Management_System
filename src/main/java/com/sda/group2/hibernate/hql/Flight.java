package com.sda.group2.hibernate.hql;

import com.sda.group2.FileInput;
import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id")
    private int flightId;
    @Column(name = "flight_number")
    private String flightNumber;
    @Column(name = "arrival_airport_id")
    private String arrivalAirportId;
    @Column(name = "departure_airport_id")
    private String departureAirportId;
    @Column(name = "arrival_datetime")
    private LocalTime arrivalTime;
    @Column(name = "departure_datetime")
    private LocalTime departureTime;

    public Flight() {
    }

    public Flight(String flightNumber, String arrivalAirportId, String departureAirportId, LocalTime arrivalDateTime, LocalTime departureDateTime) {
        this.flightNumber = flightNumber;
        this.arrivalAirportId = arrivalAirportId;
        this.departureAirportId = departureAirportId;
        this.arrivalTime = arrivalDateTime;
        this.departureTime = departureDateTime;
    }

    public static List<Flight> loadFlightsFromFileIntoArray(String filename) {
        List<Flight> flightsList = new ArrayList<>();
        FileInput input = new FileInput();
        try {
            flightsList = input.readFlights(filename);

        } catch (FileDBNotConnectionException e) {
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());

        } catch (FlightMappingException e) {
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());
            System.out.println(e.getLine());
        }
        return flightsList;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrivalAirportId() {
        return arrivalAirportId;
    }

    public void setArrivalAirportId(String arrivalAirportId) {
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getDepartureAirportId() {
        return departureAirportId;
    }

    public void setDepartureAirportId(String departureAirportId) {
        this.departureAirportId = departureAirportId;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
}
