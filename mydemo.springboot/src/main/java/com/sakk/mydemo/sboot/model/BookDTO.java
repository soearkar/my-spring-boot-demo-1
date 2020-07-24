package com.sakk.mydemo.sboot.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.sakk.mydemo.sboot.entity.Book;
import com.sakk.mydemo.sboot.entity.Publisher;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private Set<PublisherDTO> publisher;

	public BookDTO() {
		super();
		this.id = 0;
		this.name = "";
		this.publisher = new HashSet<>();
	}

	public BookDTO(Book book) {
		if (book!= null) {
			this.id = book.getId();
			this.name = book.getName();
			this.publisher = new HashSet<>();
			for(Publisher publisher: book.getPublishers()){
				PublisherDTO publisherDto = new PublisherDTO();
				publisherDto.setId(publisher.getId());
				publisherDto.setName(publisher.getName());
			    this.publisher.add(publisherDto);
			}
				
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PublisherDTO> getPublisher() {
		return publisher;
	}

	public void setPublisher(Set<PublisherDTO> publisher) {
		this.publisher = publisher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	

}
