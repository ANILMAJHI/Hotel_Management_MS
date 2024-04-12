package com.anil.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.api.entity.Rating;
import com.anil.api.exception.RatingNotFountException;
import com.anil.api.repository.RatingRepository;

import jakarta.transaction.Transactional;

@Service
public class RatingServiceImp implements RatingService {

	@Autowired
	RatingRepository ratingRepository;

	@Override
	@Transactional
	public Rating saveRating(Rating rating) {

		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> findAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating findRatingId(String ratingId) {
		return ratingRepository.findById(ratingId)
				.orElseThrow(() -> new RatingNotFountException("Rating are not available..."));
	}

	@Override
	public List<Rating> findRatingByUseId(String userId) {

		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> findRatingByHotelId(String hotelId) {

		return ratingRepository.findByHotelId(hotelId);
	}

}