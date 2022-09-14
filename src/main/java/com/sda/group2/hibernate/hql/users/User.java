package com.sda.group2.hibernate.hql.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER")
public class User extends Account {
    public User() {
    }

    public User(String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName);
    }
}