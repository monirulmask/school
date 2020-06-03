package com.practise.school.adaptor.infrastructure.rdb.doma.teacher_information;

import com.practise.school.domain.model.teacher_information.Teacher;
import com.practise.school.domain.model.teacher_information.TeacherDescriptor;
import com.practise.school.domain.model.teacher_information.TeacherId;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao
public interface TeacherInformationDao {
    @Insert
    int insert(Teacher teacher);

    @Select
    List<TeacherDescriptor> selectAll();

    @Update
    int update(Teacher teacher);

    @Select
    TeacherDescriptor selectingTeacherByTeacherId(TeacherId teacherId);

    @Select
    Teacher select(TeacherId teacherId);

    @Delete
    int delete(Teacher teacher);
}
