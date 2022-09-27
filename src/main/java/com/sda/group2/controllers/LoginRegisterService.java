package com.sda.group2.controllers;

import com.sda.group2.hibernate.HibernateUtil;

import com.sda.group2.hibernate.hql.users.Account;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

public class LoginRegisterService {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public Account login(String email, String password) {
        Query query = entityManager.createQuery("FROM Account a WHERE a.email = :email AND a.password = :password")
                .setParameter("email", email)
                .setParameter("password", password);
        List<Account> accounts = query.getResultList();
        if (accounts.isEmpty())
            // Account with given email and password do not exist.
            return null;
        return accounts.get(0);
    }

    public void createNewAccount(Account account) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Account with given email address already exist.");
        }
    }
}
