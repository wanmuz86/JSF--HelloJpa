package com.example.hellojpa.dto;

// DTO - Data Transfer Object represent the Data Format that you will receive from user
// when create login, or register function, we need SignInDTO and RegisterDTO
// because for SignIn for example. we are not using all parameters form User class
public class PostDTO {
	
	private String title;
	private String content;
	private Long userId;
	
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}