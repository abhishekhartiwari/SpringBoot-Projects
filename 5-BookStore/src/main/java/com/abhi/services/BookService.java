package com.abhi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.abhi.entities.Book;

@Component
public class BookService {
	
	private static List<Book> book = new ArrayList<>();
	
	static {
		book.add( new Book(1, "Java", "Chunky"));
		book.add( new Book(2, "Python", "Monkey"));
		book.add( new Book(3, "C#", "Donkey"));
		book.add( new Book(4, "Cobol", "Bunty"));
	}
	
	public List<Book> getAllBooks() {
		
		return book;
	}
	
	public Book getOneBook(int id) {
		Book book1 = null;
		try {
		book1 =  book.stream().filter(e->e.getId() == id).findFirst().get();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book1;
	}
	
	public Book addBook(Book b) {
		book.add(b);
		return b;
	}

	public void deleteBook(int id) {

		book = book.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}
	
	public void updateBook(Book b, int id) {
		
		book = book.stream().map(bb->{
			if(bb.getId()==id) {
				bb.setName(b.getName());
				bb.setAuthor(b.getAuthor());
			}
			return bb;
		}).collect(Collectors.toList());
		
	}

}
