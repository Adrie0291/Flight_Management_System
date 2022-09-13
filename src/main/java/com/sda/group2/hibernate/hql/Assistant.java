package com.sda.group2.hibernate.hql;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ASSISTANT")
public class Assistant extends Account {
}
