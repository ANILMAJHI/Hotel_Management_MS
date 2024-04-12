package com.anil.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
// @Table(name = "users", schema = "Anil")
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "userId", unique = true, nullable = false)
	private String userId;

	private String name;

	// @Email(message = "*Email should be valid format!***")
	private String email;

	@Column(name = "about")
	private String about;
	private String phone;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();

}