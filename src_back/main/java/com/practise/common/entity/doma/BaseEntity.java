package com.practise.common.entity.doma;

import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import java.util.Date;

@Setter
@Getter
@Entity(naming = NamingType.SNAKE_LOWER_CASE, listener = BaseEntityListener.class)
public abstract class BaseEntity {
    protected Date createdDate;
    protected Date updatedDate;
}
