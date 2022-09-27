package com.sda.group2.hibernate.hql.users;

import com.sda.group2.optioninterfaces.UserOption;
import com.sda.group2.optioninterfaces.options.MessageMethodUser;
import com.sda.group2.optioninterfaces.options.common.EditAccount;
import com.sda.group2.optioninterfaces.options.common.Logout;
import com.sda.group2.optioninterfaces.options.user.FileAComplaint;
import com.sda.group2.optioninterfaces.options.user.Wallet;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("USER")
public class User extends Account {
    public User() {
    }

    public User(String email, String password, String firstName, String lastName) {
        super(firstName, lastName, email, password);
    }

    @Override
    public List<UserOption> getOptions() {
        List<UserOption> list = new ArrayList<>();
        list.add(new EditAccount());
        list.add(new Wallet());
        list.add(new FileAComplaint());
        list.add(new Logout());
        list.add(new MessageMethodUser());
        return list;
    }
}