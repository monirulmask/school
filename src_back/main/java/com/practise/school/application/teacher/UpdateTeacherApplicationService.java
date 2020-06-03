package com.practise.school.application.teacher;

import com.practise.school.application.teacher.command.UpdateTeacherCommand;
import com.practise.school.domain.model.teacher_information.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateTeacherApplicationService {
    private final TeacherInformationRepository teacherInformationRepository;

    @Transactional
    public void execute(UpdateTeacherCommand command){
        Teacher teacher = teacherInformationRepository.resolveTeacher(new TeacherId(command.getTeacherId()));
        teacher.update(new TeacherName(command.getTeacherName()),
                       new TeacherAge(command.getTeacherAge()),
                       new TeacherSalary(command.getTeacherSalary()),
                       new TeacherOperationalStatus(command.getTeacherOperationalStatus()));
        teacherInformationRepository.save(teacher);
    }
}
