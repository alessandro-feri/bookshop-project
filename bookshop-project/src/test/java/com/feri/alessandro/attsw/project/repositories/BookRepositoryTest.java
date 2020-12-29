package com.feri.alessandro.attsw.project.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.feri.alessandro.attsw.project.model.Book;

@DataJpaTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	public void test_findBookByTitle() {
		Book bookToSave = new Book(null, "testTitle", "testType", 10);
		Book bookSaved = entityManager.persistFlushFind(bookToSave);
		
		Book bookFound = bookRepository.findByTitle("testTitle");
		assertThat(bookFound).isSameAs(bookSaved);
		
	}
	
	@Test
	public void test_findBooksByType() {
		Book testBook1 = new Book(null, "testTitle1", "type1", 10);
		Book testBook2 = new Book(null, "testTitle2", "type2", 10);
		Book testBook3 = new Book(null, "testTitle3", "type1", 10);
		
		entityManager.persistFlushFind(testBook1);
		entityManager.persistFlushFind(testBook2);
		entityManager.persistFlushFind(testBook3);
		
		List<Book> books = bookRepository.findBooksByType("type1");
		
		assertThat(books).containsExactly(testBook1, testBook3);
		assertThat(books).doesNotContain(testBook2);
	}
		
}
