package com.practise.school.domain.model.teacher_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.seasar.doma.Domain;

import java.io.Serializable;

@Value
@Domain(valueType = Integer.class, acceptNull = true)
public class TeacherAge implements Serializable {

    private static final long serialVersionUID = -4782769961611678951L;

    @Getter(AccessLevel.PACKAGE)
    private final Integer value;

    public TeacherAge(Integer value){
        this.value = value;
    }

    public String asText(){
        return String.valueOf(this.value);
    }
}
