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
    @Column(name = "sender")
    private String sender;
    @Column(name = "type", nullable = false)
    private ComplaintType type;

    public Complaint() {
    }

    public Complaint(String text, String sender, ComplaintType type) {
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
}
