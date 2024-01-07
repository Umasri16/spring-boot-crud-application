package com.jsp.restapi.contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.jsp.restapi.model.Book;
import com.jsp.restapi.service.BookJpaService;

@RestController
public class BookController {
	@Autowired
	public BookJpaService bookService;
	
	@GetMapping("/books")
    public ArrayList<Book> getBooks(){
        return bookService.getBooks();
    }
	@PostMapping("/books")
	 public Book addBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	@PutMapping("/books/{id}")
	public Book updateBook(@PathVariable("id") int id,@RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id")int id) {
		 bookService.deleteBook(id);
	}
}
