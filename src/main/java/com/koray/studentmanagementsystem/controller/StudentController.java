package com.koray.studentmanagementsystem.controller;

import com.koray.studentmanagementsystem.entity.Student;
import com.koray.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/api/v1/students")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model) {
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping
    public String addStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "create_student";
        }
        studentService.addStudent(student);
        model.addAttribute("student",null);
        return "redirect:/api/v1/students/new";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") @Valid Student student,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "edit_student";
        }
        studentService.updateStudent(id,student);
        return "redirect:/api/v1/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/api/v1/students";
    }
}
