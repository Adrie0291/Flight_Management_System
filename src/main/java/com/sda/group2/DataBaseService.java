package com.sda.group2;

import com.sda.group2.hibernate.HibernateUtil;
import com.sda.group2.hibernate.hql.Flight;
import com.sda.group2.hibernate.hql.Complaint;
import com.sda.group2.hibernate.hql.Message;
import com.sda.group2.hibernate.hql.users.Account;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

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

    public void sendAComplaint(Complaint complaint) {
        entm.getTransaction().begin();
        entm.persist(complaint);
        System.out.println("Thank you!");
        entm.getTransaction().commit();
    }

    public void getListOfComplaint() {
        entm.getTransaction().begin();
        System.out.println(entm.createQuery("FROM Complaint", Complaint.class).getResultList());
        entm.getTransaction().commit();
    }

    public List<Flight> showFlights() {
        Query query = entm.createQuery("FROM Flight f");
        List<Flight> flights = query.getResultList();
        if (flights.isEmpty())
            return null;
        return flights;
    }

    public List<Flight> showFilteredFlights(String arrivalAirport, String departureAirport) {
        Query query = entm.createQuery("FROM Flight f WHERE f.arrivalAirportId = :arrivalAirport OR f.departureAirportId = :departureAirport")
                .setParameter("arrivalAirport", arrivalAirport)
                .setParameter("departureAirport", departureAirport);
        List<Flight> flights = query.getResultList();
        if (flights.isEmpty())
            return null;
        return flights;
    }

    public void SendMessage(Account account, Message message) {
        entm.getTransaction().begin();
        entm.persist(message);
        message.setAccount(account);
        entm.getTransaction().commit();
    }

    public boolean isTakenEmail(String email) {
        Query query = entm.createQuery("from Account a where a.email=:email").setParameter("email", email);
        if (query.getResultList().isEmpty()) {
            return false;
        } else {
            System.out.println("Email is already in use!");
            return true;
        }
    }
}

    public void receiveMessage(int number) {
        List<Message> messages = entm.createQuery("from Message WHERE sender_id = :param", Message.class)
                .setParameter("param", number)
                .getResultList();
        messages.forEach(System.out::println);
    }

    public void receiveMessage() {
        List<Message> messages = entm.createQuery("from Message ", Message.class)
                .getResultList();
        messages.forEach(System.out::println);
    }

    public void answerToMessage(Account account, int messageId, String answer) {
        entm.getTransaction().begin();
        Message messageFromDB = entm.find(Message.class, messageId);
        messageFromDB.setAnswer(answer);
        messageFromDB.setReceiver_id(account.getAccountId());
        entm.getTransaction().commit();

    }
}
