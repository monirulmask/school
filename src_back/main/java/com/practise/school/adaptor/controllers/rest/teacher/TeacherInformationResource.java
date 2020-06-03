package com.practise.school.adaptor.controllers.rest.teacher;

import com.practise.school.adaptor.controllers.rest.teacher.dto.*;
import com.practise.school.application.teacher.*;
import com.practise.school.application.teacher.command.CreateNewTeacherCommand;
import com.practise.school.application.teacher.command.DeleteTeacherCommand;
import com.practise.school.application.teacher.command.FetchTeacherCommand;
import com.practise.school.application.teacher.command.UpdateTeacherCommand;
import com.practise.school.domain.model.teacher_information.TeacherDescriptor;
import com.practise.school.domain.model.teacher_information.TeacherSummaries;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("/api/teacher")
@RestController
public class TeacherInformationResource {
    private final CreateNewTeachersApplicationService createNewTeachersApplicationService;
    private final FetchTeachersApplicationService fetchTeachersApplicationService;
    private final FetchAnTeacherApplicationService fetchAnTeacherApplicationService;
    private final UpdateTeacherApplicationService updateTeacherApplicationService;
    private final DeleteTeacherApplicationService deleteTeacherApplicationService;

    @GetMapping(value = "{teacherId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TeacherReadDto fetchTeacher(@PathVariable(value = "teacherId") Integer teacherId){
        TeacherDescriptor teacher = fetchAnTeacherApplicationService.execute(new FetchTeacherCommand(teacherId));
        return new TeacherReadDto(teacher.getTeacherId().asText(),
                teacher.getTeacherName().asText(),
                teacher.getTeacherAge().asText(),
                teacher.getTeacherSalary().asText(),
                teacher.getTeacherOperationalStatus().asText());
    }

    @GetMapping
    public TeacherSummariesDto teachers(){
        TeacherSummaries teacherSummaries = fetchTeachersApplicationService.execute();
        return new TeacherSummariesDto(teacherSummaries.stream()
                                                       .map(teacher-> new TeacherSummaryDto(teacher.getTeacherId().asText(),
                                                                                              teacher.getTeacherName().asText(),
                                                                                              teacher.getTeacherAge().asText(),
                                                                                              teacher.getTeacherSalary().asText(),
                                                                                              teacher.getTeacherOperationalStatus().asText()))
                                                       .collect(Collectors.toList()));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping
    public void newTeacher(@RequestBody CreateTeacherDto payload){
        createNewTeachersApplicationService.execute(new CreateNewTeacherCommand(payload.getTeacherId(),
                                                                                payload.getTeacherName(),
                                                                                payload.getTeacherAge(),
                                                                                payload.getTeacherSalary(),
                                                                                payload.getTeacherOperationalStatus()));
    }

    @PutMapping(value = "{teacherId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void updateTeacher(@PathVariable(value = "teacherId") Integer teacherId,
                              @Validated @RequestBody UpdateTeacherDto body){
        UpdateTeacherCommand command = new UpdateTeacherCommand(teacherId,
                                                                body.getTeacherName(),
                                                                body.getTeacherAge(),
                                                                body.getTeacherSalary(),
                                                                body.getTeacherOperationalStatus());
        updateTeacherApplicationService.execute(command);

    }

    @DeleteMapping(value = "{teacherId}")
    public void deleteTeacher(@PathVariable(value = "teacherId") Integer teacherId){
        deleteTeacherApplicationService.execute(new DeleteTeacherCommand(teacherId));
    }

}
