package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;
import com.sda.group2.interfaces.options.Exit;
import com.sda.group2.interfaces.options.Login;
import com.sda.group2.interfaces.options.Register;

import java.util.ArrayList;
import java.util.List;

public class StartMenuUser extends Account {

    @Override
    public List<UserOption> getOptions() {
        List<UserOption> optionList = new ArrayList<>();
        optionList.add(new Login());
        optionList.add(new Register());
        optionList.add(new Exit());
        return optionList;
    }
}
