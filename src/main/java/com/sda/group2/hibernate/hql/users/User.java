package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;
import com.sda.group2.interfaces.options.AddMoney;
import com.sda.group2.interfaces.options.EditAccount;
import com.sda.group2.interfaces.options.Logout;
import com.sda.group2.interfaces.options.ShowWallet;

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

    public List<UserOption> getOptions() {
        List<UserOption> list = new ArrayList();
        list.add(new EditAccount());
        list.add(new ShowWallet());
        list.add(new AddMoney());
        list.add(new Logout());

        //TODO
        return list;
    }
}