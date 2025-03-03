package com.example.demo.repository;

import com.example.demo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

            List<Student> findAllByFirstName(String firstname);
}
