package com.karthik.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name="AUTHOR")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "AUTHOR_ID")
    private Integer authorId;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "authorEntity",cascade = ALL)
    private List<BookEntity> bookEntities;
}
