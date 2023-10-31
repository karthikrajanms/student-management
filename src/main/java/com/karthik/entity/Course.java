package com.karthik.entity;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.*;

@Data
@Entity
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
}
