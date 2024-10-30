package com.ianniello.springsecuritydemo.mapper;

import com.ianniello.springsecuritydemo.dto.GeneralResponseDto;
import com.ianniello.springsecuritydemo.model.Student;

import java.util.List;

public interface StudentMapper {

    GeneralResponseDto fromModeltoGeneralResponseDto(Student student);

    GeneralResponseDto fromStudentToDtos(List<Student> students);
}
