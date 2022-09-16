package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.users.Account;
import com.sda.group2.hibernate.hql.users.User;

import javax.persistence.EntityManager;


public class DataBaseService {
    private static EntityManager entm = HibernateUtil.getSessionFactory().createEntityManager();

    public void changeEmail(String newEmail, int id) {
        entm.getTransaction().begin();
        User userFROMdb = entm.find(User.class, id);
        userFROMdb.setEmail(newEmail);
        System.out.println("Update email was sucessful");
        entm.merge(userFROMdb);
        entm.getTransaction().commit();
    }

    public void changePassword(String newPassword, int accountId) {
        entm.getTransaction().begin();
        User userFROMdb = entm.find(User.class, accountId);
        userFROMdb.setPassword(newPassword);
        System.out.println("Update password was sucessful");
        entm.merge(userFROMdb);
        entm.getTransaction().commit();
    }

    public void showWallet(Account account) {
        System.out.println("You have " + account.getWallet() + " zl.");
    }

    public void addMoney(Account account, int money) {
        entm.getTransaction().begin();
        account.setWallet(money);
        entm.merge(account);
        entm.getTransaction().commit();

    }

    public void changeFirstName(String newFirstName, int accountId) {

        entm.getTransaction().begin();
        User userFROMdb = entm.find(User.class, accountId);
        userFROMdb.setFirstName(newFirstName);
        System.out.println("Update firstname was sucessful");
        entm.merge(userFROMdb);
        entm.getTransaction().commit();
    }

    public void changeLastName(String lastName, int accountId) {
        entm.getTransaction().begin();
        User userFROMdb = entm.find(User.class, accountId);
        userFROMdb.setLastName(lastName);
        System.out.println("Update last name was sucessful");
        entm.merge(userFROMdb);
        entm.getTransaction().commit();
    }
}

