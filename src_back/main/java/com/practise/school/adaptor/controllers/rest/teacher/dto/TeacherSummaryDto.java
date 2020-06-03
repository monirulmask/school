package com.practise.school.adaptor.controllers.rest.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherSummaryDto {
    private String teacherId;
    private String teacherName;
    private String teacherAge;
    private String teacherSalary;
    private String teacherOperationalStatus;
}
