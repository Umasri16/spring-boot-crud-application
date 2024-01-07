package com.jsp.restapi.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jsp.restapi.model.Book;
import com.jsp.restapi.repository.BookJpaRepository;
import com.jsp.restapi.repository.BookRepository;

@Service
public class BookJpaService implements BookRepository{
	
	@Autowired
	private BookJpaRepository jparepo;

	@Override
	public ArrayList<Book> getBooks() {
		List<Book> bookList=jparepo.findAll();
		ArrayList<Book> books=new ArrayList<>(bookList);
		return books;
	}

	@Override
	public Book addBook(Book book) {
		jparepo.save(book);
		return book;
	}

	@Override
	public Book getBookById(int id) {
		try {
		Book book=jparepo.findById(id).get();
		return book;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Book updateBook(int id, Book book) {
		try {
		Book newBook=jparepo.findById(id).get();
		if(book.getName()!=null) {
			newBook.setName(book.getName());
		}
		if(book.getImageUrl()!=null) {
			newBook.setImageUrl(book.getImageUrl());
		}
		return jparepo.save(newBook);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteBook(int id) {
		try {
		jparepo.deleteById(id);
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	

}

