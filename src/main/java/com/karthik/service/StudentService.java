package com.karthik.service;

import com.karthik.bean.StudentBean;
import com.karthik.entity.Student;

import java.util.List;

public interface StudentService {


    StudentBean saveStudent(StudentBean student);

    List<Student> getAllStudents();

    Student getStudentById(Integer studentId);

    Student updateStudent(StudentBean studentBean,Integer studentId);

    String deleteByStudentId(Integer studentId);
}
