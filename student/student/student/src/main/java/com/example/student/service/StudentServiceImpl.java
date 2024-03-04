package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.model.StudentModel;
import com.example.student.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents(){
        List<StudentModel> studentModelList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAll();

//        studentModelList = studentList.stream().map(student -> new StudentModel().SetStudentModel(student)).toList();

        for(Student student:studentList){
            StudentModel studentModel = new StudentModel().SetStudentModel(student);

            studentModelList.add(studentModel);
        }

        return studentModelList;
    }

    public void addStudent(StudentModel studentModel) throws IllegalAccessException {
        Optional<Student> studentByEmail= studentRepository.findStudentByEmail(studentModel.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalAccessException("Email Exists");
        }
        Student student = new Student().SetStudent(studentModel);

        studentRepository.save(student);
//        System.out.println(student);
    }

    public void deleteStudent(long studentId) throws IllegalAccessException {
       Boolean exists= studentRepository.existsById(studentId);
       if(!exists){
           throw new IllegalAccessException("Student with id " +studentId + "does not exists");
       }
       studentRepository.deleteById(studentId);
    }
@Transactional  //we dont need a query if we use this
    public void updateStudent(long studentId, String name, String email) throws IllegalAccessException {
        Student student=studentRepository.findById(studentId).orElseThrow(()->
        new IllegalAccessException
                ("Student with id " +studentId + "does not exists"));
        if(name!=null && name.length()>0&&
        !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email!=null &&
                email.length()>0 &&
                !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional= studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalAccessException("Email Exists");
            }
            student.setEmail(email);
        }
    }
}
