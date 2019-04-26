package com.skill.exchange.service;

import com.skill.exchange.domain.Student;

import java.util.List;

public interface StudentService {
    Student login(Student student);

    Student register(Student student);

    Student updateStudent(Student student);

    List<Student> getAllStudents();

    int deleteStudentById(Integer id);

    Student getStudentById(Integer id);
}
