package com.practise.school.application.teacher;

import com.practise.school.application.teacher.command.DeleteTeacherCommand;
import com.practise.school.domain.model.teacher_information.Teacher;
import com.practise.school.domain.model.teacher_information.TeacherId;
import com.practise.school.domain.model.teacher_information.TeacherInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteTeacherApplicationService {
    private final TeacherInformationRepository teacherInformationRepository;

    @Transactional
    public void execute(DeleteTeacherCommand command) {
        Teacher teacher = teacherInformationRepository.resolveTeacher(new TeacherId(command.getTeacherId()));
        teacherInformationRepository.delete(teacher);
    }
}
