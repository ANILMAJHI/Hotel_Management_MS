package com.anil.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.api.entity.User;
import com.anil.api.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	UserService service;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {

		String userId = UUID.randomUUID().toString();
		user.setUserId(userId);
		User saveUser = service.saveUser(user);
		return new ResponseEntity<User>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<User>> findAllUser() {

		List<User> allUsers = service.findAllUser();
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBracker", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> findById(@PathVariable String userId) {
		User user = service.getUserId(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex)
	{
		
		User user =User.builder().userId("2344sdfsd5454").name("Ram").email("ram@gmail.com").about("user are goog to see movies").phone("8765897000").build();
		log.info("fallback method call...");
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
