package com.anil.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rate;
	private String feedback;

	private Hotel hotel;

}