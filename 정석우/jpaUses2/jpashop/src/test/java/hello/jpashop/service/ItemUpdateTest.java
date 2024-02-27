package hello.jpashop.service;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hello.jpashop.domain.item.Book;

@SpringBootTest
@Transactional
public class ItemUpdateTest {

	
	@Autowired
	EntityManager em;
	
	@Test
	public void updateTest() {
		Book book = em.find(Book.class, 1L);
		
		
		book.setName("dd");
		
		//변경감지 == dirty checking
		
	}
}
