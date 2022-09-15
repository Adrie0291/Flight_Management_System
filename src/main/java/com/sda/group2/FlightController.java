package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Flight;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FlightController {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public FlightController() {
        //Flight flight = new Flight();
        //entityManager.getTransaction().begin();
        //entityManager.persist(flight);
        //entityManager.getTransaction().commit();
        //entityManager.close();
    }

    public void loadFlightsIntoDb(List<Flight> flights) {
        entityManager.getTransaction().begin();
        for(Flight flight:flights) {
            entityManager.persist(flight);
        }
/*
            Query q = entityManager.createQuery("insert into Flight f (f.flight_number, f.arrival_airport_id, f.departure_airport_id, f.arrival_time, f.departure_time) values (:flightNumber, :arrivalAirportId, :departureAirportId, :arrivalTime, :departureTime)")
                    .setParameter("flightNumber", flight.getFlightNumber())
                    .setParameter("arrivalAirportId", flight.getArrivalAirportId())
                    .setParameter("departureAirportId", flight.getDepartureAirportId())
                    .setParameter("arrivalTime", flight.getArrivalTime())
                    .setParameter("departureTime", flight.getDepartureTime())
                    ;
            q.executeUpdate();
        }
*/
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
