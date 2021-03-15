package com.gabriel.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.demo.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
