package com.practise.school.adaptor.controllers.rest.teacher.dto;

import lombok.Data;

@Data
public class UpdateTeacherDto {
    private String teacherName;
    private Integer teacherAge;
    private Integer teacherSalary;
    private Boolean teacherOperationalStatus;
}
