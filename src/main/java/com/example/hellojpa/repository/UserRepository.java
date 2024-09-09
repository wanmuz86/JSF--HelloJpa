package com.example.hellojpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hellojpa.model.User;

// extends JpaRepository to have access to the database methods (findById, save, findAll)
// <User> here refer to your Entity name 
// Long refer to the data type of your Entity Id

public interface UserRepository extends JpaRepository<User,Long> {
	
	// I want to extend my default methods 
	
	// I'm extending the default method
	// Add another method whichs is called findByName //JPA
	// Where name represents User class name property
	List<User> findByName(String name);
	
	
	//Extending the default method
	// Adding findBy<propery>GreaterThan /// JPA
	List<User> findByAgeGreaterThan(int age);
	
	
	// create pageable and sortable 
	Page<User> findAll(Pageable pageable);

}
