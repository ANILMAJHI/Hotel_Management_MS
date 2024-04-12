package com.anil.api.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Hotel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	@NotNull(message = "name Should't Blank")
	private String name;
	@NotNull(message = "Location Should't Blank")
	private String locatoin;
	@NotNull(message = "about Should't Blank")
	private String about;
	

}
