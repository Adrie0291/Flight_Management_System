package com.sda.group2.hibernate.hql;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("USER")
public class User extends Account  {
}