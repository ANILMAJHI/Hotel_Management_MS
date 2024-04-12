package com.anil.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {

	private int addressId;
	private String fullAddress;
	private String postalCode;
	private String city;

	//@JsonProperty("users")
	@JsonInclude(value = Include.NON_NULL)
	private UsersDto usersDto;

	public AddressDto() {
		super();
	}

	public AddressDto(int addressId, String fullAddress, String postalCode, String city, UsersDto usersDto) {
		super();
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.usersDto = usersDto;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public UsersDto getUsersDto() {
		return usersDto;
	}

	public void setUsersDto(UsersDto usersDto) {
		this.usersDto = usersDto;
	}

	@Override
	public String toString() {
		return "AddressDto [addressId=" + addressId + ", fullAddress=" + fullAddress + ", postalCode=" + postalCode
				+ ", city=" + city + ", usersDto=" + usersDto + "]";
	}

}
