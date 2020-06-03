package com.practise.school.application.teacher;

import com.practise.school.application.teacher.command.FetchTeacherCommand;
import com.practise.school.domain.model.teacher_information.TeacherDescriptor;
import com.practise.school.domain.model.teacher_information.TeacherId;
import com.practise.school.domain.model.teacher_information.TeacherInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FetchAnTeacherApplicationService {
    private final TeacherInformationRepository teacherInformationRepository;

    @Transactional(readOnly = true)
    public TeacherDescriptor execute(FetchTeacherCommand command){
        return teacherInformationRepository.resolveTeacherDescriptorById(new TeacherId(command.getTeacherId()));
    }
}
