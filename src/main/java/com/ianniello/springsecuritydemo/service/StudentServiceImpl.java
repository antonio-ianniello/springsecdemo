package com.ianniello.springsecuritydemo.service;

import com.ianniello.springsecuritydemo.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * StudentServiceImpl
 *
 * <p>
 * Implementation of Student Service for random student
 * </p>
 *
 * @author Ianniello Antonio
 * @version 1.0
 * @since 2024-10-28
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private static final String[] NAMES = {"Antonio", "Luca", "Maria", "Giulia", "Marco", "Francesca"};
    public static final int MAX_NUMBER_OF_STUDENTS = NAMES.length;
    private static final String[] SURNAMES = {"Rossi", "Bianchi", "Esposito", "Ricci", "Gallo", "Ianniello"};
    private static final String[] GENDERS = {"M", "F"};
    private static final Random RANDOM = new Random();

    @Override
    public Student getStudent(int id) {
        return getRandomStudent(id);
    }

    @Override
    public List<Student> getStudents() {
        return randomStudents(MAX_NUMBER_OF_STUDENTS);
    }

    public Student getRandomStudent(int id) {
        if (id > NAMES.length - 1) {
            log.warn("STUDENT ASKED: {} out of range,get default value of {}", id, 0);
            id = 0;
        }
        return randomStudents(MAX_NUMBER_OF_STUDENTS).get(id);
    }

    private List<Student> randomStudents(int numberOfStudents) {
        List<Student> students = new ArrayList<>();
        if (numberOfStudents > MAX_NUMBER_OF_STUDENTS) {
            log.warn("NUMBER OF STUDENTS ASKED: {} STUDENTS AVAILABLE: {}", numberOfStudents, MAX_NUMBER_OF_STUDENTS);
            numberOfStudents = MAX_NUMBER_OF_STUDENTS;
        }

        for (int i = 1; i <= numberOfStudents; i++) {
            students.add(Student.builder()
                    .id(i)
                    .name(NAMES[RANDOM.nextInt(NAMES.length)])
                    .surname(SURNAMES[RANDOM.nextInt(SURNAMES.length)])
                    .gender(GENDERS[RANDOM.nextInt(GENDERS.length)])
                    .build());
        }
        log.info("Students added: {}", students);
        return students;

    }
}
