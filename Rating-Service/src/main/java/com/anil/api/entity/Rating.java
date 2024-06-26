package com.anil.api.entity;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String ratingId;
	private String userId;
	private String hotelId;
	private int rate;
	private String feedback;

	@Transient
	private ArrayList<Hotel> hotel = new ArrayList<>();
	// private Hotel hotel;

}
