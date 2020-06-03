package com.practise.school.adaptor.controllers.rest.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherReadDto {
    private String teacherId;
    private String teacherName;
    private String teacherAge;
    private String teacherSalary;
    private String teacherOperationalStatus;
}
