package com.anil.api.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UsersDto {

	private long userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	@JsonInclude(value = Include.NON_NULL)
	private Set<AddressDto> addressDtos;

	public UsersDto() {
		super();
	}

	public UsersDto(long userId, String firstName, String lastName, String email, String phone,
			Set<AddressDto> addressDtos) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.addressDtos = addressDtos;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<AddressDto> getAddressDtos() {
		return addressDtos;
	}

	public void setAddressDtos(Set<AddressDto> addressDtos) {
		this.addressDtos = addressDtos;
	}

	@Override
	public String toString() {
		return "UsersDto [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", addressDtos=" + addressDtos + "]";
	}

}
