package com.feri.alessandro.attsw.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feri.alessandro.attsw.project.model.Book;
import com.feri.alessandro.attsw.project.repositories.BookRepository;

@Service
public class BookService {

	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
}