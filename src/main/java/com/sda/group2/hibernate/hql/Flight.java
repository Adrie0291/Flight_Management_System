package com.sda.group2.hibernate.hql;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id")
    private int flightId;
    @Column(name = "arrival_airport_id")
    private String arrivalAirportId;
    @Column(name = "departure_airport_id")
    private String departureAirportId;
    @Column(name = "arrival_datetime")
    private LocalDateTime arrivalDateTime;
    @Column(name = "departure_datetime")
    private LocalDateTime departureDateTime;

}
