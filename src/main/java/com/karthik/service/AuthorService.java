package com.karthik.service;

import com.karthik.bean.AuthorBean;
import com.karthik.entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    String saveAuthor(AuthorEntity authorEntity);

    List<AuthorBean> getAllAuthors();

    AuthorBean getAuthorById(Integer authorId);
}
