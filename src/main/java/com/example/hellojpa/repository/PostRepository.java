package com.example.hellojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellojpa.model.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
	
	List<Post> findByUserId(Long userId);

}
