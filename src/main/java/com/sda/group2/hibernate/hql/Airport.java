package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "airport_id")
    private String airportId;
    @Column
    private String name;
    @Column
    private String country;



}
