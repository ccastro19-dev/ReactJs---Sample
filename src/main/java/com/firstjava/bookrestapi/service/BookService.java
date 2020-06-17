package com.firstjava.bookrestapi.service;

//import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.firstjava.bookrestapi.domain.Book;

public interface BookService<T> {

	Page<T> findAll(Pageable pageable, String searchText);
	Page<T> findAll(Pageable pageable);
	
	Book findById(Long id);
	Book save (Book book);
	Book update (Book book);
	String deleteById(Long id);
//	T findById(Long id);
	
	T saveOrUpdate(T t);


	
}
