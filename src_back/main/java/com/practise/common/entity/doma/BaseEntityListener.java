package com.practise.common.entity.doma;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseEntityListener<T extends BaseEntity> implements EntityListener<T> {
    @Override
    public void preInsert(T baseEntity, PreInsertContext<T> context) {
        Date currentDateTime = new Date();
        baseEntity.setCreatedDate(currentDateTime);
    }

    @Override
    public void preUpdate(T baseEntity, PreUpdateContext<T> context) {
        Date currentDateTime = new Date();
        baseEntity.setUpdatedDate(currentDateTime);
    }

}
