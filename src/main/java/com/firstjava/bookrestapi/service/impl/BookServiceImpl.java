package com.firstjava.bookrestapi.service.impl;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;



import com.firstjava.bookrestapi.domain.Book;
import com.firstjava.bookrestapi.repository.BookRepository;
import com.firstjava.bookrestapi.service.BookService;


@Service
public class BookServiceImpl implements BookService<Book> {
	
	@Autowired
	
	private BookRepository bookRepository;
	
	@Override
	public Page<Book> findAll(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		return bookRepository.findAllBooks(pageable, searchText);

	}

	
//	private Long bookid = 100L;
//	
//	private Map<Long, Book> bookMap = new HashMap<Long, Book>();
//	
//	{
//		
//			Book book = new Book();
//			book.setId(bookid);
//			book.setTitle("Hi");
//			book.setAuthor("Crizel");
//			book.setLanguage("Englis");
//			book.setCoverPhotoUrl("https://images.pexels.com/photos/20787/pexels-photo.jpg?auto=compress&cs=tinysrgb&h=350");
//			bookMap.put(book.getId(), book);
//		
//		
//	} 

	public Page<Book> findAll(Pageable pageable) {
		return bookRepository.findAll(pageable);
	}

	@Override
	public Book findById(Long id) {
	
		return bookRepository.findById(id).get();
	}

//	@Override
//	public Book save(Book book) {
//
//		Long newBookId = ++bookid;
//		book.setId(newBookId);
//		bookMap.put(book.getId(), book);
//		return bookMap.get(newBookId);
//	}
//
//	@Override
//	public Book update(Book book) {
//	
//		bookid = book.getId();
//		
//		if(bookMap.get(bookid) != null)
//		{
//			bookMap.put(bookid, book);
//			return bookMap.get(bookid);
//		}
//		return null;
//	}

	@Override
	public String deleteById(Long id) {

		JSONObject jsonObject = new JSONObject();
		try {
			bookRepository.deleteById(id);
			jsonObject.put("message", "Book deleted successfully");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	@Override
	public Book saveOrUpdate(Book book) {
		// TODO Auto-generated method stub
		return bookRepository.save(book);
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book book) {
		// TODO Auto-generated method stub
		return null;
	}





}
