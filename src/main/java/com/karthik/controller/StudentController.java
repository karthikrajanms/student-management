package com.karthik.controller;

import com.karthik.bean.StudentBean;
import com.karthik.entity.Student;
import com.karthik.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentController {


    @Autowired
    private  StudentService studentService;

    @PostMapping("save")
    ResponseEntity<StudentBean> saveStudent(@RequestBody StudentBean student){
        return new ResponseEntity<>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("all")
    ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("find/{studentId}")
    ResponseEntity<Student> getStudentById(@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping("update/{studentId}")
    ResponseEntity<Student> updateStudentById(@RequestBody StudentBean student,@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.updateStudent(student,studentId), HttpStatus.OK);
    }

    @DeleteMapping("delete/{studentId}")
    ResponseEntity<String> deleteById(@PathVariable Integer studentId){
        return new ResponseEntity<>(studentService.deleteByStudentId(studentId), HttpStatus.OK);
    }
}
