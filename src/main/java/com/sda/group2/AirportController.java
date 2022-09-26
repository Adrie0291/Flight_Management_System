package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Airport;
import com.sda.group2.hibernate.hql.Flight;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class AirportController {

    private String path = "src\\main\\resources\\";
    private String filename = "airports.txt";
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public AirportController(String filename) {
        this.filename = filename;
    }

    public void loadAirportsIntoDb(List<Airport> airports) {
        entityManager.getTransaction().begin();
        for (Airport airport : airports) {
            entityManager.persist(airport);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Airport database is up-to-date.");
    }

    public String getFilename() {
        return path + filename;
    }

}
