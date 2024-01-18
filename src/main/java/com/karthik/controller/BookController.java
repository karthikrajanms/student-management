package com.karthik.controller;

import com.karthik.bean.AuthorBean;
import com.karthik.entity.AuthorEntity;
import com.karthik.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author/")
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    @PostMapping("save")
    ResponseEntity<String> saveStudent(@Valid @RequestBody AuthorBean authorBean){
        return new ResponseEntity<>(authorService.saveAuthor(authorBean), HttpStatus.CREATED);
    }

    @GetMapping("get-all")
    ResponseEntity<List<AuthorBean>> getAllAuthors(){
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("{authorId}")
    ResponseEntity<AuthorBean> findAuthorById(@PathVariable Integer authorId){
        return new ResponseEntity<>(authorService.getAuthorById(authorId), HttpStatus.OK);
    }

}
