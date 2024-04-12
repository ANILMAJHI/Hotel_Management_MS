package com.anil.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	
}
