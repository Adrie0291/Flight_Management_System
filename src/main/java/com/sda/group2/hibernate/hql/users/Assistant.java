package com.sda.group2.hibernate.hql.users;

import com.sda.group2.optioninterfaces.UserOption;
import com.sda.group2.optioninterfaces.options.assistant.CustomerService;
import com.sda.group2.optioninterfaces.options.MessageMethodAssistant;
import com.sda.group2.optioninterfaces.options.common.EditAccount;
import com.sda.group2.optioninterfaces.options.FlightsFilteredPreview;
import com.sda.group2.optioninterfaces.options.FlightsPreview;
import com.sda.group2.optioninterfaces.options.common.Logout;

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
        list.add(new CustomerService());
        list.add(new FlightsPreview());
        list.add(new FlightsFilteredPreview());
        list.add(new MessageMethodAssistant());
        list.add(new Logout());
        return list;
    }
}
