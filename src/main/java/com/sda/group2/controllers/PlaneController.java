package com.sda.group2.controllers;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Plane;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class PlaneController {

    private final String path = "src\\main\\resources\\";
    private String filename = "planes.txt";
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public PlaneController(String filename) {
        this.filename = filename;
    }

    public void loadPlanesIntoDb(List<Plane> planes) {
        entityManager.getTransaction().begin();
        for (Plane plane : planes) {
            entityManager.persist(plane);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Planes database is up-to-date.");
    }

    public String getFilename() {
        return path + filename;
    }
}
