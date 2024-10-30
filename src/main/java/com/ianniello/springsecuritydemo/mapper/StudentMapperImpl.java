package com.ianniello.springsecuritydemo.mapper;

import com.ianniello.springsecuritydemo.dto.GeneralResponseDto;
import com.ianniello.springsecuritydemo.model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public GeneralResponseDto fromModeltoGeneralResponseDto(Student student) {
        return new GeneralResponseDto(student);

    }

    @Override
    public GeneralResponseDto fromStudentToDtos(List<Student> students) {
        return new GeneralResponseDto(students);
    }
}
