package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Flight;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class FlightController {
    private String path = "src\\main\\resources\\";
    private String filename = "flights.txt";
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public FlightController(String filename) {
        this.filename = filename;
    }

    public void loadFlightsIntoDb(List<Flight> flights) {
        entityManager.getTransaction().begin();
        for (Flight flight : flights) {
            entityManager.persist(flight);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Flight database is up-to-date.");
    }

    public String getFilename() {
        return path+filename;
    }
}
