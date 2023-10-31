package com.karthik.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "department")
    private String department;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "city")
    private String city;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = ALL)
    @JoinColumn(name = "student_id",referencedColumnName = "studentId")
    private List<Course> courses;
}
