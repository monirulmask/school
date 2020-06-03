package com.practise.school.application.teacher;

import com.practise.school.domain.model.teacher_information.TeacherInformationRepository;
import com.practise.school.domain.model.teacher_information.TeacherSummaries;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FetchTeachersApplicationService {
    private final TeacherInformationRepository teacherInformationRepository;

    @Transactional(readOnly = true)
    public TeacherSummaries execute(){
        return teacherInformationRepository.resolveTeachers();
    }
}
