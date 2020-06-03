package com.practise.school.domain.model.teacher_information;

public interface TeacherInformationRepository {

    TeacherDescriptor resolveTeacherDescriptorById(TeacherId teacherId);

    TeacherSummaries resolveTeachers();

    void save(Teacher teacher);

    Teacher resolveTeacher(TeacherId teacherId);

    void delete(Teacher teacher);
}
