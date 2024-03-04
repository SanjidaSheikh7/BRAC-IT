package com.example.student.model;

import com.example.student.entity.Student;

import java.time.format.DateTimeFormatter;

public class StudentModel {
    private Long id;
    private String name;
    private String email;
    private String dob;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentModel SetStudentModel(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.age = student.getAge();
        this.dob = student.getDob().format(DateTimeFormatter.ISO_DATE);
        return this;
    }
}
