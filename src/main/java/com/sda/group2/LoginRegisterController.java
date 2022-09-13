package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;

import com.sda.group2.hibernate.hql.Account;
import com.sda.group2.hibernate.hql.User;
import org.hibernate.SessionFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class LoginRegisterController {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private final EntityManager entityManager = sessionFactory.createEntityManager();

    public void loginDeprecated() {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("Login: ");
            List<Account> account = entityManager.createQuery("from Account a where a.email = :email", Account.class).setParameter("email", sc.nextLine()).getResultList(); //prawdopodobnie jakaś metoda z HQL później do podmiany?

            if(account.isEmpty()) {
                System.out.println("Incorrect login!\nTry again!\n");
                return;
            }

            System.out.println("Password: ");
            if(account.get(0).getPassword().equals(sc.nextLine())){
                System.out.println("Success!"); //tymczasowe potwierdzenie sukcesu
                //todo przejście dalej po zalogowaniu
                break;
            } else {
                System.out.println("Incorrect password!\n");
            }
        }while(true);

        HibernateUtil.shutdown();
    }

    public <T> login(String email, String password) {
        entityManager.createQuery("FROM Account a WHERE a.email = :email")
                .setParameter("email", email);
        Query query = entityManager.createQuery("from Account a where a.email = :email and a.password = :password", T.class)
                .setParameter("email", email)
                .setParameter("password", password);
        List<T> accounts = query.getResultList();
        if (accounts.isEmpty())
            return new User();

        return accounts.get(0);
    }

    public void registerNewUser(String firstName, String lastName, String email, String password) {
        User user = new User(email, password, firstName, lastName);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
