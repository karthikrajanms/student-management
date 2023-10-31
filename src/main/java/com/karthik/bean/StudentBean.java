package com.karthik.bean;

import lombok.Data;

import java.util.List;

@Data
public class StudentBean {
    private String studentName;
    private String department;
    private String birthDate;
    private String city;
    private String email;
    private List<CourseBean> courses;
}
