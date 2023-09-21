package com.karthik.controller;

import com.karthik.bean.StudentBean;
import com.karthik.entity.Student;
import com.karthik.repository.StudentRepository;
import com.karthik.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("save")
    ResponseEntity<Student> saveStudent(@RequestBody StudentBean student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("all")
    ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("{studentId}")
    ResponseEntity<Student> getStudentById(@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

}
