package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;
import com.sda.group2.interfaces.options.EditAccount;
import com.sda.group2.interfaces.options.FlightsFilteredPreview;
import com.sda.group2.interfaces.options.FlightsPreview;
import com.sda.group2.interfaces.options.Logout;
import com.sda.group2.interfaces.options.ViewComplaints;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("ASSISTANT")
public class Assistant extends Account {

    public Assistant() {
    }

    public Assistant(String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName);
    }

    @Override
    public List<UserOption> getOptions() {
        List<UserOption> list = new ArrayList<>();
        list.add(new EditAccount());
        list.add(new ViewComplaints());
        list.add(new FlightsPreview());
        list.add(new FlightsFilteredPreview());
        list.add(new Logout());
        return list;
    }
}
