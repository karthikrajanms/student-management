package com.karthik.service;

import com.karthik.bean.CourseBean;
import com.karthik.entity.Course;

public interface CourseService {
    Course addCourse(CourseBean course, Integer studentId);
}
