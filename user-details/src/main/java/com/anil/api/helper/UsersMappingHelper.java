package com.anil.api.helper;

import java.util.HashSet;
import java.util.Set;

import com.anil.api.dto.AddressDto;
import com.anil.api.dto.UsersDto;
import com.anil.api.model.Address;
import com.anil.api.model.Users;

public class UsersMappingHelper {

	public static UsersDto map(final Users users) {
		UsersDto dto = new UsersDto();
		dto.setUserId(users.getUserId());
		dto.setFirstName(users.getFirstName());
		dto.setLastName(users.getLastName());
		dto.setEmail(users.getEmail());
		dto.setPhone(users.getPhone());
		// dto.setAddressDtos(users.getAddresses());
		if (users.getAddresses() != null) {
			Set<AddressDto> addressesDtos = new HashSet<>();
			for (Address address : users.getAddresses()) {
				AddressDto addDto = new AddressDto();
				addDto.setAddressId(address.getAddressId());
				addDto.setFullAddress(address.getFullAddress());
				addDto.setPostalCode(address.getPostalCode());
				addDto.setCity(address.getCity());
				addressesDtos.add(addDto);
			}
			dto.setAddressDtos(addressesDtos);
		}

		return dto;
	}

	public static Users map(UsersDto dto) {
		Users users = new Users();
		users.setUserId(dto.getUserId());
		users.setFirstName(dto.getFirstName());
		users.setLastName(dto.getLastName());
		users.setEmail(dto.getEmail());
		users.setPhone(dto.getPhone());
		
		if (dto.getAddressDtos() != null) {
			Set<Address> addresses = new HashSet<>();
			for (AddressDto dtos : dto.getAddressDtos()) {
				
				Address add = new Address();
				add.setAddressId(dtos.getAddressId());
				add.setFullAddress(dtos.getFullAddress());
				add.setPostalCode(dtos.getPostalCode());
				add.setCity(dtos.getCity());
				addresses.add(add);
			}
			users.setAddresses(addresses);
		}

		return users;
	}
}
