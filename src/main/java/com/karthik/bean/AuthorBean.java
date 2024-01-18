package com.karthik.bean;

import lombok.Data;

import java.util.List;


@Data
public class AuthorBean {

    private Integer authorId;
    private String authorName;
    private String email;
    private List<BookBean> books;
}
