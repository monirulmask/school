package com.practise.school.application.teacher.command;

import lombok.Value;

@Value
public class UpdateTeacherCommand {
    private Integer teacherId;
    private String teacherName;
    private Integer teacherAge;
    private Integer teacherSalary;
    private Boolean teacherOperationalStatus;
}
