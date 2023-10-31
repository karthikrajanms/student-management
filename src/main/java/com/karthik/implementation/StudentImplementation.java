package com.karthik.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.karthik.bean.CourseBean;
import com.karthik.bean.StudentBean;
import com.karthik.entity.Course;
import com.karthik.entity.Student;
import com.karthik.repository.CourseRepository;
import com.karthik.repository.StudentRepository;
import com.karthik.service.StudentService;
import com.karthik.utils.DateUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public StudentBean saveStudent(StudentBean studentRequest) {
        saveFunction(studentRequest);
        return studentRequest;

    }

    private void saveFunction(StudentBean studentRequest) {
        try {
            Student student = new Student();
            student.setEmail(studentRequest.getEmail());
            student.setStudentName(studentRequest.getStudentName());
            student.setBirthDate(DateUtils.convertStringToLocalDate(studentRequest.getBirthDate()));
            student.setCity(studentRequest.getCity());
            student.setDepartment(studentRequest.getDepartment());
            List<Course> courses = new ModelMapper().map(studentRequest.getCourses(), new TypeToken<List<Course>>() {}.getType());
            student.setCourses(courses);
            studentRepository.save(student);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer studentId) {
       return studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student Id < " +studentId+" > is not found "));
    }

    @Override
    public Student updateStudent(StudentBean studentBean,Integer studentId) {
        Student updatedStudent = studentRepository.findById(studentId).
                orElseThrow(() -> new RuntimeException("Student Id < " + studentId + " > is not found "));
        updatedStudent.setStudentName(studentBean.getStudentName());
        updatedStudent.setCity(studentBean.getCity());
        updatedStudent.setDepartment(studentBean.getDepartment());
        updatedStudent.setBirthDate( DateUtils.convertStringToLocalDate(studentBean.getBirthDate()));
        return studentRepository.save(updatedStudent);

    }

    @Override
    public String deleteByStudentId(Integer studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new RuntimeException("Student Id < " + studentId + " > is not found "));
        studentRepository.deleteById(student.getStudentId());
        return "Successfully deleted Student id " + studentId + " from Database.";
    }
}
