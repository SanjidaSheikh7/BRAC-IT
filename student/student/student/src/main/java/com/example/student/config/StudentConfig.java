package com.example.student.config;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
       Student sanjida= new Student(
                "sanjida",
                "sanjida@gmail.com",
                LocalDate.of(2000, APRIL,05)
       );
        Student sabrina= new Student(
                "sabrina",
                "sabrina@gmail.com",
                LocalDate.of(2004, APRIL,04)
        );
        repository.saveAll(List.of(sabrina,sanjida));
    };
    }
}
