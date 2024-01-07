package com.jsp.restapi.repository;

import java.util.ArrayList;

import com.jsp.restapi.model.Book;

public interface BookRepository {
	ArrayList<Book> getBooks();
	Book addBook(Book book);
	Book getBookById(int id);
	Book updateBook(int id,Book book);
	void deleteBook(int id);
}
