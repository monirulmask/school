package com.practise.school.application.teacher.command;

import lombok.Value;

@Value
public class FetchTeacherCommand {
    private final Integer teacherId;

    public FetchTeacherCommand(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
