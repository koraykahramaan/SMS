package com.koray.studentmanagementsystem.service;

import com.koray.studentmanagementsystem.entity.Student;
import com.koray.studentmanagementsystem.exception.UsernameNotFoundException;
import com.koray.studentmanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return  studentRepository.findAll();

    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Could not find student with id : " + id));
    }
    @Override
    public Student updateStudent(Long id,Student student) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Could not found student."));
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setId(id);
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Could not found student."));
        studentRepository.deleteById(id);
    }
}
