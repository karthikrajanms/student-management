package com.karthik.repository;

import com.karthik.entity.AuthorEntity;
import com.karthik.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity,Integer> {

    BookEntity findByTitleContaining(String title);


}
