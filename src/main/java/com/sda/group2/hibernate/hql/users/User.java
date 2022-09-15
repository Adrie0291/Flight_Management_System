package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;
import com.sda.group2.interfaces.options.EditAccount;
import com.sda.group2.interfaces.options.Logout;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("USER")
public class User extends Account {
    public User() {
    }

    public User (String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName);
    }

    public List<UserOption> getOptions() {
        List<UserOption> list = new ArrayList();
        list.add(new Logout());
        list.add(new EditAccount());
        //TODO
        return list;
    }
}