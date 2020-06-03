package com.practise.school.application.teacher;


import com.practise.school.application.teacher.command.CreateNewTeacherCommand;
import com.practise.school.domain.model.teacher_information.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateNewTeachersApplicationService {
    private final TeacherInformationRepository teacherInformationRepository;

    @Transactional
    public void execute(CreateNewTeacherCommand command){
        teacherInformationRepository.save(new Teacher(new TeacherId(command.getTeacherId()),
                                                      new TeacherName(command.getTeacherName()),
                                                      new TeacherAge(command.getTeacherAge()),
                                                      new TeacherSalary(command.getTeacherSalary()),
                                                      new TeacherOperationalStatus(command.getTeacherOperationalStatus())));
    }


}
