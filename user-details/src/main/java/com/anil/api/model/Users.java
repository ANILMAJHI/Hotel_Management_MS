package com.anil.api.model;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
//@Table(name = "users", schema = "Anil")
@Table
public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;
	@Column(name = "firstName")
	private String firstName;
	@Column(name = "lastName")
	private String lastName;
	@Email(message = "*Email should be valid format!***")
	private String email;
	private String phone;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "users", fetch = FetchType.LAZY)
	private Set<Address> addresses;

	public Users() {
		super();
	}

	public Users(long userId, String firstName, String lastName,
			@Email(message = "*Email should be valid format!***") String email, String phone, Set<Address> addresses) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.addresses = addresses;
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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", addresses=" + addresses + "]";
	}

}
