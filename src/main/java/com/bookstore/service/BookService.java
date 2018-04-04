package com.bookstore.service;

import java.util.List;

import com.bookstore.domain.Book;

public interface BookService {
	List<Book> findAll ();

	List<Book> findAllByAdmin ();

	Book findOne(Long id);
	
	List<Book >findByCategory(String category);
	
	List<Book> bllurrySearch(String title);

	Book save (Book book);

	void removeOne(Long id);
}
