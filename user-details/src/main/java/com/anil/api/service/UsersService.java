package com.anil.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.api.dto.UsersDto;
import com.anil.api.helper.UsersMappingHelper;
import com.anil.api.model.Users;
import com.anil.api.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository repository;

	private static final Logger log = LoggerFactory.getLogger(UsersService.class);

	public UsersDto save(UsersDto usersDto) {

		log.info("*** UserDto, service class; save users *");
		Users users = UsersMappingHelper.map(usersDto);

		Users saveUsers = repository.save(users);

		UsersDto dto = UsersMappingHelper.map(saveUsers);
		return dto;
	}

	public List<UsersDto> findByAll() {

		log.info("*** UserDto List, service class; fetch all users *");
		List<UsersDto> usersDto = new ArrayList<>();
		List<Users> users = new ArrayList<>();

		users = repository.findAll();
		for (Users userAll : users) {
			UsersDto dto = UsersMappingHelper.map(userAll);
			usersDto.add(dto);
		}

		return usersDto;
	}
}
