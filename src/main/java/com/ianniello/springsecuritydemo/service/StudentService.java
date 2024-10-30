package com.ianniello.springsecuritydemo.service;

import com.ianniello.springsecuritydemo.model.Student;

import java.util.List;

/**
 * StudentService
 *
 * <p>
 * Student Service Interface
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
public interface StudentService {

    Student getStudent(int id);

    List<Student> getStudents();
}
