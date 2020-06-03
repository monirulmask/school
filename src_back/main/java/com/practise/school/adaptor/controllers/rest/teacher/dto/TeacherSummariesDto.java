package com.practise.school.adaptor.controllers.rest.teacher.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class TeacherSummariesDto {
    private List<TeacherSummaryDto> teachers;
}
