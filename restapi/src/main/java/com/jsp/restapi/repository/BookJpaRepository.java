package com.jsp.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.restapi.model.Book;

public interface BookJpaRepository extends JpaRepository<Book, Integer>{

}
