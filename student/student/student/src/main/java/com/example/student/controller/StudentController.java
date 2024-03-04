package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.model.StudentModel;
import com.example.student.service.StudentService;
import com.example.student.service.StudentServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/student")
@Component
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping
    public void addStudent(@RequestBody StudentModel studentModel) throws IllegalAccessException {
        studentService.addStudent(studentModel);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentId) throws IllegalAccessException {
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ) throws IllegalAccessException {
        studentService.updateStudent(studentId,name,email);
    }
}
