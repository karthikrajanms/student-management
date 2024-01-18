package com.karthik.controller;

import com.karthik.entity.AuthorEntity;
import com.karthik.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/")
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    @PostMapping("save")
    ResponseEntity<String> saveStudent(@RequestBody AuthorEntity authorEntity){
        return new ResponseEntity<>(authorService.saveAuthor(authorEntity), HttpStatus.CREATED);
    }

}
