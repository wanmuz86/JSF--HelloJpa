package com.example.hellojpa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hellojpa.dto.PostResponseDTO;
import com.example.hellojpa.model.Post;
import com.example.hellojpa.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	
	public List<PostResponseDTO> getAllPosts(){
		List<Post> posts = postRepository.findAll();
		// for each item retrieved from an entity post, transform it into  DTO
		return posts.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}
	
	public List<PostResponseDTO> getPostsByUserId(Long userId){
		List<Post> posts = postRepository.findByUserId(userId);
		return posts.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	

	// Entity to DTO converter
	private PostResponseDTO mapToDTO(Post post) {
		PostResponseDTO postDTO = new PostResponseDTO();
		postDTO.setName(post.getTitle());
		postDTO.setContent(post.getContent());
		postDTO.setId(post.getId());
		postDTO.setUserId(post.getUser().getId());
		postDTO.setUserName(post.getUser().getName());
		return postDTO;
		
	}
}
