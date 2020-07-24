package com.sakk.mydemo.sboot.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakk.mydemo.sboot.dao.BookDao;
import com.sakk.mydemo.sboot.entity.Book;
import com.sakk.mydemo.sboot.entity.Publisher;
import com.sakk.mydemo.sboot.model.BookDTO;
import com.sakk.mydemo.sboot.model.PublisherDTO;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDao bookDao;

	@Override
	public BookDTO saveBook(BookDTO bookDTO) {
		Book book = new Book();
		book.setId(bookDTO.getId());
		book.setName(bookDTO.getName());
		for(PublisherDTO pDTO: bookDTO.getPublisher()){
			Publisher publisher = new Publisher();
			publisher.setId(pDTO.getId());
			publisher.setName(pDTO.getName());
			publisher.getBooks().add(book);
			book.getPublishers().add(publisher);
		}
		bookDao.save(book);
		return new BookDTO(book);
	}


}
