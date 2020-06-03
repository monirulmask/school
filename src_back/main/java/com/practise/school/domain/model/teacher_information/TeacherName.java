package com.practise.school.domain.model.teacher_information;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import org.seasar.doma.Domain;

import java.io.Serializable;

@Value
@Domain(valueType = String.class, acceptNull = true)
public class TeacherName implements Serializable {
    private static final long serialVersionUID = 8900100566658065705L;

    @Getter(AccessLevel.PACKAGE)
    private final String value;

    public TeacherName(String value) {
        this.value = value;
    }

    public String asText() {
        return this.value;
    }
}
