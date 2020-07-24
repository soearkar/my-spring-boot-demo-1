package com.sakk.mydemo.sboot.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4561385674190905685L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher",
        joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
    private Set<Publisher> publishers = new HashSet<>();

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

	public Set<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(Set<Publisher> publishers) {
		this.publishers = publishers;
	}

	

}
