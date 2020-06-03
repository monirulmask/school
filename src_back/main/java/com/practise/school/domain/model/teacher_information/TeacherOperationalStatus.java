package com.practise.school.domain.model.teacher_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.seasar.doma.Domain;

import java.io.Serializable;

@Value
@Domain(valueType = Boolean.class, acceptNull = true)
public class TeacherOperationalStatus implements Serializable {
    private static final long serialVersionUID = 861922357553920581L;

    @Getter(AccessLevel.PACKAGE)
    private final Boolean value;

    public TeacherOperationalStatus(Boolean value){
        this.value = value;
    }

    public String asText(){
        return String.valueOf(this.value);
    }
}
