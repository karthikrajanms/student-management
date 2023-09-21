package com.karthik.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Integer id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "department")
    private String department;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "city")
    private String city;
}
