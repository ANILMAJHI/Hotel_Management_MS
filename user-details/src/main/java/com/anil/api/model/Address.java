package com.anil.api.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Table(name = "addresss", schema = "Anil")
@Table
@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "addressId", unique = true, nullable = false)
	private int addressId;
	@Column(name = "fullAddress", unique = true)
	private String fullAddress;
	@Column(name = "postalCode")
	private String postalCode;
	private String city;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private Users users;

	public Address() {
		super();
	}

	public Address(int addressId, String fullAddress, String postalCode, String city, Users users) {
		super();
		this.addressId = addressId;
		this.fullAddress = fullAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.users = users;
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", fullAddress=" + fullAddress + ", postalCode=" + postalCode
				+ ", city=" + city + ", users=" + users + "]";
	}

}
