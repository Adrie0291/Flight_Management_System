package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity

@Table(name="airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "airport_id")
    private String airportId;
    @Column
    private String country;
    @Column
    private String name;

    public Airport(String airportId, String country, String name) {
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


}
