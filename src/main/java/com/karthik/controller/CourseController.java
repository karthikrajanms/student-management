package com.karthik.controller;

import com.karthik.bean.CourseBean;
import com.karthik.bean.StudentBean;
import com.karthik.entity.Course;
import com.karthik.entity.Student;
import com.karthik.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course/")
@RequiredArgsConstructor
public class CourseController {

  /*  private final CourseService courseService;

    @PostMapping("add/{studentId}")
    ResponseEntity<Course> saveStudent(@PathVariable Integer studentId, @RequestBody CourseBean course){
        return new ResponseEntity<>(courseService.addCourse(course,studentId), HttpStatus.CREATED);
    }*/
}
