package com.anil.api.service;

import java.util.List;

import com.anil.api.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> findAllUser();

	User getUserId(String userId);
}
