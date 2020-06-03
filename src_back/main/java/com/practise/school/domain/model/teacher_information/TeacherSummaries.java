package com.practise.school.domain.model.teacher_information;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeacherSummaries {
    private List<TeacherDescriptor> value;

    public Stream<TeacherDescriptor> stream() {
        return this.value.stream();
    }

    public List<TeacherDescriptor> getValue() {
        return Collections.unmodifiableList(this.value);
    }

    public boolean exists() {
        return this.value.isEmpty() == false;
    }

}
