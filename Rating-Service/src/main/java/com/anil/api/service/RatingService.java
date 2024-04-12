package com.anil.api.service;

import java.util.List;

import com.anil.api.entity.Rating;

public interface RatingService {

	Rating saveRating(Rating rating);

	List<Rating> findAllRating();

	Rating findRatingId(String ratingId);

	// get all by UserId
	List<Rating> findRatingByUseId(String userId);

	// get all by hotelId
	List<Rating> findRatingByHotelId(String hotelId);

}
