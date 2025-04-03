package com.abhi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abhi.dao.BookRepository;
import com.abhi.entities.Book;

@Component
public class BookService {
	
	
	@Autowired
	private BookRepository bookRepository;
	/*
	 * private static List<Book> book = new ArrayList<>();
	 * 
	 * static { book.add( new Book(1, "Java", "Chunky")); book.add( new Book(2,
	 * "Python", "Monkey")); book.add( new Book(3, "C#", "Donkey")); book.add( new
	 * Book(4, "Cobol", "Bunty")); }
	 */
	
	public List<Book> getAllBooks() {
		
		List<Book> books =  (List<Book>) bookRepository.findAll();
		return books;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
			
			book = this.bookRepository.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
	}

	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	
	public void updateBook(Book b, int id) {
		b.setId(id);
		bookRepository.save(b);
		
	}

}
