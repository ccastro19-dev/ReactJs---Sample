package com.firstjava.bookrestapi.service.impl;

import java.util.Collection;

import com.firstjava.bookrestapi.domain.Book;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;



public interface IService<T> {
//	Page<T> findAll(Pageable pageable, String searchText);
//
//	Page<T> findAll(Pageable pageable);
	

	Collection<Book> findAll();
	
	Book deleteById(Long id);

	Book update(Book book);

	Book save(Book book);
	

	
	T findById(Long id);
	
	T saveOrUpdate(T t);
	
}
