package com.anil.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.api.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{

}
