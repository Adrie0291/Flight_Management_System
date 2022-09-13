package com.sda.group2.frontend;

import com.sda.group2.hibernate.hql.Account;

public interface UserOption {
    void execute(Account account);
    String getName();
}
