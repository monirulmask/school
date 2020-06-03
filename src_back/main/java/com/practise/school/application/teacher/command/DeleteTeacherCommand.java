package com.practise.school.application.teacher.command;

import lombok.Value;

@Value
public class DeleteTeacherCommand {
    private final Integer teacherId;

    public DeleteTeacherCommand(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
