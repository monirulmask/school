package com.practise.school.domain.model.teacher_information;

import com.practise.common.entity.doma.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "teacher")
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
public class Teacher extends BaseEntity {
    @Id
    private TeacherId teacherId;
    private TeacherName teacherName;
    private TeacherAge teacherAge;
    private TeacherSalary teacherSalary;
    private TeacherOperationalStatus teacherOperationalStatus;

    Teacher(){

    }

    public Teacher(TeacherId teacherId,
                   TeacherName teacherName,
                   TeacherAge teacherAge,
                   TeacherSalary teacherSalary,
                   TeacherOperationalStatus teacherOperationalStatus) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.teacherSalary = teacherSalary;
        this.teacherOperationalStatus = teacherOperationalStatus;
    }

    public void update(TeacherName teacherName,
                        TeacherAge teacherAge,
                        TeacherSalary teacherSalary,
                        TeacherOperationalStatus teacherOperationalStatus){
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.teacherSalary = teacherSalary;
        this.teacherOperationalStatus = teacherOperationalStatus;
    }
}
