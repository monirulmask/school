package com.practise.school.domain.model.teacher_information;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Setter(AccessLevel.PACKAGE)
@Data
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class TeacherDescriptor {
    private TeacherId teacherId;
    private TeacherName teacherName;
    private TeacherAge teacherAge;
    private TeacherSalary teacherSalary;
    private TeacherOperationalStatus teacherOperationalStatus;
}
