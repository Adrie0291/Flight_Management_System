package com.sda.group2.hibernate.hql.users;

import com.sda.group2.interfaces.UserOption;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends Account {

    public Admin() {
    }

    public Admin(String email, String password, String firstName, String lastName) {
        super(email, password, firstName, lastName);
    }

    public List<UserOption> list() {
        List<UserOption> list = new ArrayList();
        list.add(new FirstMethod());
        list.add(new FirstMad());
        return list;
    }

    private class FirstMethod implements UserOption {
        @Override
        public void invoke() {
            System.out.println("Nice!");
        }

        @Override
        public String getMethodName() {
            return "First method in list";
        }
    }
    private class FirstMad implements UserOption {
        @Override
        public void invoke() {
            System.out.println("XDD");
        }

        @Override
        public String getMethodName() {
            return "Second Method";
        }
    }
}
