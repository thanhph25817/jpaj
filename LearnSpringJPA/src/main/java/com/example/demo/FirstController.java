package com.example.demo;

import com.example.demo.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FirstController {

    private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/post-student")
    public Student post(@RequestBody Student student) {
        return studentRepository.save(student);
    }

//    @GetMapping("/order/{userName}")
//    public String pathVar(
//            @PathVariable String userName
//    ) {
//        return userName;
//    }

    @GetMapping("/student")
    public List<Student> paramVar(
            @RequestBody Student student

    ) {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Optional<Student> getId(
            @PathVariable("id") Long id
    ) {
        return studentRepository.findById(id);
    }

    @GetMapping("/student/sea/{student-name}")
    public List<Student> getName(
            @PathVariable("student-name") String name
    ) {
        return studentRepository.findAllByFirstName(name);
    }

    @DeleteMapping("/student/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void Delete(@PathVariable("id") Long id) {
        studentRepository.deleteById(id);
    }
}
