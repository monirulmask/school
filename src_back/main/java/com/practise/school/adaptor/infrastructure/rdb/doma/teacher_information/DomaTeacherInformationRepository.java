package com.practise.school.adaptor.infrastructure.rdb.doma.teacher_information;

import com.practise.school.domain.model.teacher_information.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class DomaTeacherInformationRepository implements TeacherInformationRepository {
    private final TeacherInformationDao teacherInformationDao;

    @Override
    public TeacherDescriptor resolveTeacherDescriptorById(TeacherId teacherId) {
        TeacherDescriptor teacherDescriptor = teacherInformationDao.selectingTeacherByTeacherId(teacherId);
        return teacherDescriptor;
    }

    @Override
    public TeacherSummaries resolveTeachers() {
        TeacherSummaries teacherSummaries = new TeacherSummaries(teacherInformationDao.selectAll());
        return teacherSummaries;
    }

    @Override
    public void save(Teacher teacher) {
        Teacher resolved = teacherInformationDao.select(teacher.getTeacherId());
        if(resolved == null){
            teacherInformationDao.insert(teacher);
        }else {
            teacherInformationDao.update(teacher);
        }
    }

    @Override
    public Teacher resolveTeacher(TeacherId teacherId) {
        Teacher teacher = teacherInformationDao.select(teacherId);
        return teacher;
    }

    @Override
    public void delete(Teacher teacher) {
        teacherInformationDao.delete(teacher);
    }
}
