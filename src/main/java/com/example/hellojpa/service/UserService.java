package com.example.hellojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hellojpa.repository.UserRepository;
import com.example.hellojpa.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// Create
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	// R
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id); // is given to us by JpaRepostory
	}
	
	
	
	
	//D
	
	public void deleteUser(Long id) {
		 userRepository.deleteById(id);
	}
	
	
	public Page<User> getUsersPaged(PageRequest pageRequest){
		
		return userRepository.findAll(pageRequest);
	}

}
