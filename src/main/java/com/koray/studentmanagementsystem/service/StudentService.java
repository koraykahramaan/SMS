package com.koray.studentmanagementsystem.service;
import com.koray.studentmanagementsystem.entity.Student;

import java.util.List;
public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudentById(Long id);
    Student updateStudent(Long id,Student student);

    void deleteStudent(Long id);
}
