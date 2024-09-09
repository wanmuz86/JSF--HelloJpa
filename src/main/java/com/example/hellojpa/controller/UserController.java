package com.example.hellojpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hellojpa.model.User;
import com.example.hellojpa.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable Long id){
		return userService.findById(id);
	}
	


//	   @GetMapping("/{name}")
//	   public List<User> getUsersByName(@PathVariable String name) {
//	       return userService.findUsersByName(name);
//	   }

	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id ) {
		userService.deleteUser(id);
	}
	
	// @RequestParam means when I test, url will be /api/users/paged?page=0&size=5
	// page = currentPage size, how many items per page pass to PageRequest
	
	@GetMapping("/paged")
	public Page<User> getUsersPaged(@RequestParam int page, @RequestParam int size){
		return userService.getUsersPaged(PageRequest.of(page, size));
	}

}
