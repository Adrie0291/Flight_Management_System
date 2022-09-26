package com.sda.group2.hibernate.hql;

import com.sda.group2.FileInput;
import com.sda.group2.exceptions.FileDBNotConnectionException;
import com.sda.group2.exceptions.FlightMappingException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plane_id")
    private int planeId;
    @Column
    private String type;
    @Column
    private String company;
    @Column
    private int seats;

    public Plane(String type, String company, int seats) {
        this.type = type;
        this.company = company;
        this.seats = seats;
    }


    public static List<Plane> loadPlanesFromFileIntoArray(String filename) {
        List<Plane> planesList = new ArrayList<>();
        FileInput input = new FileInput();
        try {
            planesList = input.readPlanes(filename);

        } catch (FileDBNotConnectionException e) {
            System.out.println("You have got exception:");
            System.out.println(e.getMessage());

        }catch (FlightMappingException e){
            System.out.println("You have got exception:");
            System.out.println(e.getMessage());
            System.out.println(e.getLine());
        }
        return planesList;
    }

}
