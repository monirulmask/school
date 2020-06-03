package com.practise.school.adaptor.controllers.rest.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTeacherDto {
    private Integer teacherId;
    private String teacherName;
    private Integer teacherAge;
    private Integer teacherSalary;
    private Boolean teacherOperationalStatus;
}
