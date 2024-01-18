package com.karthik.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import static jakarta.persistence.GenerationType.*;

@Data
@Entity
@Table(name="BOOKS")
@ToString
public class BookEntity {

    @Id
    @GeneratedValue(strategy = AUTO,generator = "native")
    @GenericGenerator(name = "native")
    @Column(name = "BOOK_ID")
    private Integer bookId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity author;

}
