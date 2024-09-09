package com.example.hellojpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellojpa.dto.PostDTO;
import com.example.hellojpa.dto.PostResponseDTO;
import com.example.hellojpa.model.Post;
import com.example.hellojpa.model.User;
import com.example.hellojpa.service.PostService;
import com.example.hellojpa.service.UserService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	// /api/posts GET
	@GetMapping
	public List<PostResponseDTO> getAllPosts(){
		return postService.getAllPosts();
	}
	
	
	// /api/posts POST {"title":"", "content":"", "userId":""}
	@PostMapping
	public Post createPost(@RequestBody PostDTO post) {
		Optional<User> currentUser = userService.findById(post.getUserId());
		if (currentUser.isPresent()) {
		Post newPost = new Post(post.getTitle(),post.getContent(), currentUser.get());
		return postService.createPost(newPost);
		}
		return null;
	}
	
	 // /api/posts/user/{userId} GET
	@GetMapping("/user/{userId}")
	public List<PostResponseDTO> getPostByUserId(@PathVariable Long userId){
		return postService.getPostsByUserId(userId);
	}

}
