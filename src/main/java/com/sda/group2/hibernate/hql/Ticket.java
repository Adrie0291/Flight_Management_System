package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int ticket_id;
    @Column
    private double price;
    @Column
    private int seat;
    @Column
    private Luggage luggage;
    @Column
    private int card_id;

}
