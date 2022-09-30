package com.sda.group2.hibernate.hql;


import com.sda.group2.hibernate.hql.users.Account;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String answer;
    @Column
    private String question;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Account account;

    @Column(name = "receiver_id")
    private int receiver_id;

    public Message(String text) {
        this.question = text;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------" + "\n" +
                "ID Message: " + id + ".  Person Details: " + account + "\n" +
                "Question: '" + question + '\'' + "\n" +
                "Answer: '" + answer + '\'' + "\n" +
                "----------------------------------------------------------------------";
    }
}

