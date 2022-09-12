package com.sda.group2.hibernate;
import javax.persistence.EntityManager;

public class MainDemo {


    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getSessionFactory().createEntityManager();

        // tutaj kod pozostały

        HibernateUtil.shutdown();
    }
}