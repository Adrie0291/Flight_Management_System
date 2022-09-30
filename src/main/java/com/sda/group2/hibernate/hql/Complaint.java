package com.sda.group2.hibernate.hql;

import javax.persistence.*;

@Entity
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "message", nullable = false)
    private String text;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "ticket_number")
    private String ticketNumber;

    @Column(name = "answer")
    private String answer;
    @Column(name = "sender", nullable = false)
    private String sender;
    @Column(name = "type", nullable = false)
    private ComplaintType type;

    public Complaint() {
    }

    public Complaint(String flightNumber, String ticketNumber, String text, String sender, ComplaintType type) {
        this.flightNumber = flightNumber;
        this.ticketNumber = ticketNumber;
        this.text = text;
        this.sender = sender;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getSender() {
        return sender;
    }

    public ComplaintType getType() {
        return type;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setType(ComplaintType type) {
        this.type = type;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", flightNumber= " + flightNumber + '\'' +
                        " ticketNumber= " + ticketNumber + '\n' +
                        " text: " + text + '\n' +
                        " answer: " + answer + '\n' +
                        " sender= " + sender + '\'' +
                        " type= " + type;
    }
}
