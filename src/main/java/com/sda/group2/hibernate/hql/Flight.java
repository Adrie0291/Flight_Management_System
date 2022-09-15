package com.sda.group2.hibernate.hql;

import com.sda.group2.FileInput;
import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;

import javax.persistence.*;
import java.time.LocalTime;

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

    public Flight(String flightNumber, String arrivalAirportId, String departureAirportId, LocalTime arrivalDateTime, LocalTime departureDateTime) {
        this.flightNumber = flightNumber;
        this.arrivalAirportId = arrivalAirportId;
        this.departureAirportId = departureAirportId;
        this.arrivalTime = arrivalDateTime;
        this.departureTime = departureDateTime;
    }

    public void loadFlightsFromFileIntoDb() {

        FileInput input = new FileInput();
        try {
            // TODO tutaj input do bazy
            System.out.println(input.readFlights());


        } catch (FileDBNotConnectionException e) {
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());

        }catch (FlightMappingException e){
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());
            System.out.println(e.getLine());
        }

    }


}
