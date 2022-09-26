package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Complaint;
import com.sda.group2.hibernate.hql.users.Account;

import javax.persistence.EntityManager;

public class DataBaseService {
    private static EntityManager entm = HibernateUtil.getSessionFactory().createEntityManager();

    public void changeEmail(String newEmail, int id) {
        entm.getTransaction().begin();
        Account accountFromDB = entm.find(Account.class, id);
        accountFromDB.setEmail(newEmail);
        System.out.println("Email update was successful.");
        entm.merge(accountFromDB);
        entm.getTransaction().commit();
    }

    public void changePassword(String newPassword, int accountId) {
        entm.getTransaction().begin();
        Account accountFromDB = entm.find(Account.class, accountId);
        accountFromDB.setPassword(newPassword);
        System.out.println("Password update was successful.");
        entm.merge(accountFromDB);
        entm.getTransaction().commit();
    }

    public void showWallet(Account account) {
        System.out.println("You have " + account.getWallet() + " PLN.");
    }

    public void setBalance(Account account, double money) {
        entm.getTransaction().begin();
        account.setWallet(money);
        entm.merge(account);
        entm.getTransaction().commit();
    }

    public void changeFirstName(String newFirstName, int accountId) {
        entm.getTransaction().begin();
        Account accountFromDB = entm.find(Account.class, accountId);
        accountFromDB.setFirstName(newFirstName);
        System.out.println("Update firstname was successful.");
        entm.merge(accountFromDB);
        entm.getTransaction().commit();
    }

    public void changeLastName(String lastName, int accountId) {
        entm.getTransaction().begin();
        Account accountFromDB = entm.find(Account.class, accountId);
        accountFromDB.setLastName(lastName);
        System.out.println("Update last name was successful.");
        entm.merge(accountFromDB);
        entm.getTransaction().commit();
    }

    public void sendAComplaint(Complaint complaint){
        entm.getTransaction().begin();
        entm.persist(complaint);
        System.out.println("Thank you!");
        entm.getTransaction().commit();
    }

    public void getListOfComplaint(){
        entm.getTransaction().begin();
        System.out.println(entm.createQuery("FROM Complaint", Complaint.class).getResultList());
        entm.getTransaction().commit();
    }

}

