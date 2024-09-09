package com.example.hellojpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	// Declaring the relationship between User and Post (1 user has many posts)
	// User is parent, Post Child (Parent -> Child) OneToMany
	// Child -> Parent (ManyToOne)
	// FetchType.LAZY vs EAGER (Eager loading, we will call all the time during the request, 
	// Lazy Loading when it is needed
	// JoinColumn , how the table is related/joint
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id", nullable = false)
	@JsonIgnore //This will not be returned in the JSON, but we use DTO / userName and userId instead
	private User user;

	public Post() {
		
	}
	
	public Post(String title, String content, User user) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
