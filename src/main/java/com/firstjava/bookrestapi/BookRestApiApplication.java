package com.firstjava.bookrestapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.firstjava.bookrestapi.domain.Book;
import com.firstjava.bookrestapi.service.BookService;
//import com.firstjava.bookrestapi.service.impl.IService;

@SpringBootApplication
public class BookRestApiApplication implements CommandLineRunner {
	
	@Autowired
	private BookService<Book> service;

	public static void main(String[] args) {
		SpringApplication.run(BookRestApiApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		for(int i=1; i<=1000; i++) {
			Book book = new Book();
			book.setTitle("Hiss" + i);
			book.setAuthor("Crizel"+ i);
			book.setLanguage("English"+ i);
			book.setCoverPhotoUrl("https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350"+ i);
			service.saveOrUpdate(book);
		}
	}

}
