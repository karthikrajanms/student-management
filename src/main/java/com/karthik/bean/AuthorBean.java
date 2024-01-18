package com.karthik.bean;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;


@Data
public class AuthorBean {

    private Integer authorId;
    @NotNull(message = "Author name must not be null")
    @Size(min = 3,message = "Author name must be 3 letters are more")
    private String authorName;
    @Email(message ="Enter Valid Email Address")
    private String email;
    private List<BookBean> books;
}
