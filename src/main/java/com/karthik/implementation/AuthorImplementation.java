package com.karthik.implementation;

import com.karthik.bean.AuthorBean;
import com.karthik.entity.AuthorEntity;
import com.karthik.entity.BookEntity;
import com.karthik.repository.BookRepository;
import com.karthik.repository.AuthorRepository;
import com.karthik.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorImplementation implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Override
    public String saveAuthor(AuthorEntity authorEntity) {
        AuthorEntity author = new AuthorEntity();
        author.setAuthorName(authorEntity.getAuthorName());
        author.setEmail(authorEntity.getEmail());
        List<BookEntity> bookEntities = new ArrayList<>();
        for (BookEntity bookEntity : authorEntity.getBooks()) {
            BookEntity book = new BookEntity();
            book.setTitle(bookEntity.getTitle());
            book.setDescription(bookEntity.getDescription());
            book.setAuthor(author);
            bookEntities.add(book);
        }
        author.setBooks(bookEntities);
        authorRepository.save(author);
        return "Successfully saved author !!!";
    }

    @Override
    public List<AuthorBean> getAllAuthors() {
        List<AuthorEntity> authorEntityList = authorRepository.findAll();
        return new ModelMapper().map(authorEntityList, new TypeToken<List<AuthorBean>>() {
        }.getType());
    }

    @Override
    public AuthorBean getAuthorById(Integer authorId) {
        AuthorEntity entity = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("No author founded! "));
        AuthorBean authorBean = new AuthorBean();
        new ModelMapper().map(entity,authorBean);
        return authorBean;
    }
}
