package com.anil.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.api.dto.AddressDto;
import com.anil.api.helper.AddressMappingHelper;
import com.anil.api.model.Address;
import com.anil.api.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public AddressDto save(AddressDto addressDto) {

		Address address = AddressMappingHelper.map(addressDto);

		Address address2 = addressRepository.save(address);

		AddressDto dto = AddressMappingHelper.map(address2);
		return dto;
	}
}
