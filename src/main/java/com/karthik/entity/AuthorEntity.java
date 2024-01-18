package com.karthik.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name="AUTHOR")
@ToString
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = AUTO,generator = "native")
    @GenericGenerator(name = "native")
    private Integer authorId;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "author",cascade = ALL)
    @JsonIgnore
    private List<BookEntity> books;

}
