package com.karthik.implementation;

import com.karthik.entity.AuthorEntity;
import com.karthik.entity.BookEntity;
import com.karthik.repository.BookRepository;
import com.karthik.repository.AuthorRepository;
import com.karthik.service.AuthorService;
import lombok.RequiredArgsConstructor;
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
        for (BookEntity bookEntity : authorEntity.getBookEntities()) {
            BookEntity book = new BookEntity();
            book.setTitle(bookEntity.getTitle());
            book.setDescription(bookEntity.getDescription());
            book.setAuthorEntity(author);
            bookEntities.add(book);
        }
        author.setBookEntities(bookEntities);
        authorRepository.save(author);
        return "Successfully saved author !!!";
    }
}
