package com.firstjava.bookrestapi.resource.impl;


import java.util.Arrays;

//import java.util.Locale;

//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstjava.bookrestapi.domain.Book;
import com.firstjava.bookrestapi.resource.Resource;
import com.firstjava.bookrestapi.service.BookService;
//import com.firstjava.bookrestapi.service.BookService;
//import com.firstjava.bookrestapi.service.impl.IService;
//import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

@RestController
@RequestMapping("/books" )
@CrossOrigin(origins="http://localhost:3000")

public class BookResourceImp implements Resource<Book> {
//	@GetMapping("/books")
//	public String homeInit(Locale locale, Model model) {
//		return "books";
//	}
	@Autowired
	private BookService<Book> bookservice;
//	@Override
//	public Page<T> findAll(Pageable pageable, searchText){
//		return bookRepository.findAllBooks(pageable, searchText);
//	}
	
	@Override
	public ResponseEntity<Page<Book>> findAll(Pageable pageable, String searchText) {
		// TODO Auto-generated method stub
		return new ResponseEntity<>(bookservice.findAll(pageable,searchText), HttpStatus.OK);
	}
	
//	@Override
//	public ResponseEntity<Page<T>> findAll(Pageable pageable, String searchText){
//		return new ResponseEntity<>(bookservice.findAll(pageable,searchText), HttpStatus.OK);
//	}
//	
	public ResponseEntity<Page<Book>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
	
		return new ResponseEntity<>(bookservice.findAll(
				PageRequest.of(
						pageNumber, pageSize,
						sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy) .ascending() : Sort.by(sortBy).descending()
						
						)
				), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> findById(Long id) {
		return new ResponseEntity<> (bookservice.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Book> save(Book book) {
		return new ResponseEntity<> (bookservice.saveOrUpdate(book), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Book> update(Book book) {
		return new ResponseEntity<> (bookservice.saveOrUpdate(book), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> deleteById(Long id) {
		return new ResponseEntity<>(bookservice.deleteById(id), HttpStatus.OK);
	}
	
	@GetMapping("/lnguage")
	public ResponseEntity<Set <String>> findAllLanguages() {
		return new ResponseEntity<>(new TreeSet<>(Arrays.asList("Bisaya","English","French","None")), HttpStatus.OK);
	}
//
//	@Override
//	public ResponseEntity<Page<Book>> findAll(Pageable pageable, String searchText) {
//		// TODO Auto-generated method stub
//		return null;
//	}




	

}
