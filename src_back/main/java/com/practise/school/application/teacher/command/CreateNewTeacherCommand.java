package com.practise.school.application.teacher.command;

import lombok.Value;

@Value
public class CreateNewTeacherCommand {
    private Integer teacherId;
    private String teacherName;
    private Integer teacherAge;
    private Integer teacherSalary;
    private Boolean teacherOperationalStatus;

    public CreateNewTeacherCommand(Integer teacherId,
                                   String teacherName,
                                   Integer teacherAge,
                                   Integer teacherSalary,
                                   Boolean teacherOperationalStatus
                                  ) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAge = teacherAge;
        this.teacherSalary = teacherSalary;
        this.teacherOperationalStatus = teacherOperationalStatus;
    }
}
