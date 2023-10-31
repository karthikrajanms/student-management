/*
package com.karthik.implementation;

import com.karthik.bean.CourseBean;
import com.karthik.entity.Course;
import com.karthik.repository.CourseRepository;
import com.karthik.repository.StudentRepository;
import com.karthik.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseImplementation implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Override
    public Course addCourse(CourseBean courseRequest, Integer studentId) {
        Course course = new Course();
        return studentRepository.findById(studentId)
                .map(student -> {
                    course.setStudent(student);
                    course.setTitle(courseRequest.getTitle());
                    course.setDescription(courseRequest.getDescription());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new RuntimeException("Not found Tutorial with id = " + studentId));
    }
}
*/
