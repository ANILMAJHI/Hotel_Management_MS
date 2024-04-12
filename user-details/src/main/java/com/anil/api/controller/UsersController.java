package com.anil.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.api.dto.UsersDto;
import com.anil.api.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	private static final Logger log = LoggerFactory.getLogger(UsersController.class);

	@Autowired
	UsersService service;

	@PostMapping
	public ResponseEntity<UsersDto> save(@RequestBody UsersDto usersDto) {
		log.info("***UsersController class save the Userdto class***");
		UsersDto dto = service.save(usersDto);

		return new ResponseEntity<UsersDto>(dto, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<UsersDto>> findByAll() {
		log.info("***UsersController class fetch the all the data Userdto class from findByAll() method***");
		List<UsersDto> dto = service.findByAll();

		return new ResponseEntity<List<UsersDto>>(dto, HttpStatus.OK);
	}

}
