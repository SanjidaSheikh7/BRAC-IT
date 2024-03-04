package com.example.student.service;

import com.example.student.model.StudentModel;

import java.util.List;

public interface StudentService {
    List<StudentModel> getStudents();

    void addStudent(StudentModel studentModel) throws IllegalAccessException;

    void deleteStudent(long studentId) throws IllegalAccessException;

    void updateStudent(long studentId, String name, String email) throws IllegalAccessException;
}
