package com.sda.group2.interfaces;

import com.sda.group2.hibernate.hql.users.Account;

public interface UserOption {
    void invoke(Account account);
    String getMethodName();
}
