package com.ianniello.springsecuritydemo.model;

import lombok.Builder;
import lombok.Data;

/**
 * Student
 *
 * <p>
 * This represents the student's model in application
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Data
@Builder
public class Student {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String gender;
    private String email;

}
