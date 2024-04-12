package com.anil.api.helper;

import com.anil.api.dto.AddressDto;
import com.anil.api.dto.UsersDto;
import com.anil.api.model.Address;

public class AddressMappingHelper {

	public static AddressDto map(Address address) {
		AddressDto dto = new AddressDto();
		dto.setAddressId(address.getAddressId());
		dto.setFullAddress(address.getFullAddress());
		dto.setPostalCode(address.getPostalCode());
		dto.setCity(address.getCity());

		/*
		 * UsersDto usersDto = new UsersDto();
		 * //usersDto.setUserId(address.getUsers().getUserId());
		 * usersDto.setFirstName(address.getUsers().getFirstName());
		 * usersDto.setLastName(address.getUsers().getLastName());
		 * usersDto.setEmail(address.getUsers().getEmail());
		 * usersDto.setPhone(address.getUsers().getPhone());
		 * 
		 * dto.setUsersDto(usersDto);
		 */
		return dto;
	}

	public static Address map(AddressDto addressDto) {
		Address address = new Address();
		address.setAddressId(addressDto.getAddressId());
		address.setFullAddress(addressDto.getFullAddress());
		address.setPostalCode(addressDto.getPostalCode());
		address.setCity(addressDto.getCity());

		return address;
	}
}
