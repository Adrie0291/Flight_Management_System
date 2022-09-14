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
    private Luggage luggage;
    @Column(name = "card_id")
    private String cardId;

}
