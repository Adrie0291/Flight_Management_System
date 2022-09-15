package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;
import com.sda.group2.interfaces.options.Logout;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("ASSISTANT")
public class Assistant extends Account {

    public List<UserOption> getOptions() {
        List<UserOption> list = new ArrayList();
        list.add(new Logout());
        //TODO
        return list;
    }
}
