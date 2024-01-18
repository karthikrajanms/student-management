package com.karthik.repository;

import com.karthik.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Integer> {
    AuthorEntity findByEmail(String email);
    AuthorEntity findByAuthorNameContaining(String name);
}
