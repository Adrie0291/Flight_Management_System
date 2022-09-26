package com.sda.group2.hibernate.hql;

import com.sda.group2.FileInput;
import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name="airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id")
    private int airportId;
    @Column
    private String country;
    @Column
    private String name;

    public Airport(int airportId, String country, String name) {
        this.airportId = airportId;
        this.country = country;
        this.name = name;
    }

    public Airport(String country, String name) {
        this.country = country;
        this.name = name;
    }

    public Airport() {
    }

    public static List<Airport> loadAirportsFromFileIntoArray(String filename) {
        List<Airport> airportsList = new ArrayList<>();
        FileInput input = new FileInput();
        try {
            airportsList = input.readAirports(filename);

        } catch (FileDBNotConnectionException e) {
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());

        }catch (FlightMappingException e){
            System.out.println("Wystąpił wyjątek:");
            System.out.println(e.getMessage());
            System.out.println(e.getLine());
        }
        return airportsList;
    }

}
