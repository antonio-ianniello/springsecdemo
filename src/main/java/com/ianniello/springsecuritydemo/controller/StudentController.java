package com.ianniello.springsecuritydemo.controller;

import com.ianniello.springsecuritydemo.dto.GeneralResponseDto;
import com.ianniello.springsecuritydemo.mapper.StudentMapper;
import com.ianniello.springsecuritydemo.model.Student;
import com.ianniello.springsecuritydemo.service.StudentService;
import com.ianniello.springsecuritydemo.util.JsonUtils;
import com.ianniello.springsecuritydemo.util.MonitoringUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

/**
 * StudentController
 *
 * <p>
 * Rest Controller for Student
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@RestController
public class StudentController {

    private final StudentMapper studentMapper;
    private StudentService studentService;

    @Autowired
    private StudentController(StudentMapper mapper, StudentService service) {
        this.studentMapper = mapper;
        this.studentService = service;
    }

    @GetMapping("/random/student/{id}")
    public ResponseEntity<GeneralResponseDto> getRandomStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        return ok(studentMapper.fromModeltoGeneralResponseDto(student));
    }

    @GetMapping("/random/students")
    public ResponseEntity<GeneralResponseDto> getRandomStudents(HttpServletRequest request) {
        MonitoringUtils.monitoringRequest(request);
        List<Student> randomStudentList = studentService.getStudents();
        return ok(studentMapper.fromStudentToDtos(randomStudentList));
    }

    @GetMapping("/students")
    public ResponseEntity<GeneralResponseDto> getStudents() {
        GeneralResponseDto responseDto = JsonUtils.fromJsonFile("students.json", GeneralResponseDto.class);
        return ok(responseDto);
    }
}
