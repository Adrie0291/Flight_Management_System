package com.sda.group2.frontend;

import com.sda.group2.Account;
import com.sda.group2.hibernate.HibernateUtil;

import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;

import java.util.List;
import java.util.Scanner;

public class Login {
    public void login() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Login: ");
            List<Account> account = entityManager.createQuery("from Account a where a.email = :email").setParameter("email", sc.nextLine()).getResultList(); //prawdopodobnie jakaś metoda z HQL później do podmiany?

            if(account.isEmpty()) {
                System.out.println("Incorrect login!\nTry again!\n");
                //Launch.start(); //todo wyrzucenie przed wybór login/rejestracja
                break;
            }

            System.out.println("Password: ");
            if(account.get(0).getPassword.equals(sc.nextLine())){
                System.out.println("Success!"); //tymczasowe potwierdzenie sukcesu
                //todo przejście dalej po zalogowaniu
                break;
            } else {
                System.out.println("Incorrect password!\n");
            }
        }while(true);

        HibernateUtil.shutdown();
    }
}
