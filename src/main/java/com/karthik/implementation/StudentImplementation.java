package com.karthik.implementation;

import com.karthik.bean.StudentBean;
import com.karthik.entity.Student;
import com.karthik.repository.StudentRepository;
import com.karthik.service.StudentService;
import com.karthik.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImplementation implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student saveStudent(StudentBean studentRequest) {
        Student newStudent = new Student();
        newStudent.setStudentName(studentRequest.getStudentName());
        newStudent.setCity(studentRequest.getCity());
        newStudent.setDepartment(studentRequest.getDepartment());
        LocalDate studentBirthDate = new DateUtils().convertStringToLocalDate(studentRequest.getBirthDate());
        newStudent.setBirthDate(studentBirthDate);
        return studentRepository.save(newStudent);
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
        updatedStudent.setBirthDate(new DateUtils().convertStringToLocalDate(studentBean.getBirthDate()));
        return studentRepository.save(updatedStudent);

    }

    @Override
    public String deleteByStudentId(Integer studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new RuntimeException("Student Id < " + studentId + " > is not found "));
        studentRepository.deleteById(student.getId());
        return "Successfully deleted Student id " + studentId + " from Database.";
    }
}
