package com.karthik.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import static jakarta.persistence.GenerationType.*;

@Data
@Entity
@Table(name="BOOKS")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "BOOK_ID")
    private Integer bookId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity authorEntity;
}
