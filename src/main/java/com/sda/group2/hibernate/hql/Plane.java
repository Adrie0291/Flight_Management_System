package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity
@Table(name = "plane")
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int plane_id;
    @Column
    private String company;
    @Column
    private String type;
}
