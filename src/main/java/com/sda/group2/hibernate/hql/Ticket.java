package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private int ticketId;
    @Column
    private double price;
    @Column
    private int seat;
    @Column
    @Enumerated(EnumType.STRING)
    private Luggage luggage;
    @Column(name = "passport_number")
    private String passportNumber;
}
