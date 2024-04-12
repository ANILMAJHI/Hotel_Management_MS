package com.anil.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.api.entity.Rating;
import com.anil.api.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	RatingService service;

	@PostMapping
	public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {

		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		Rating saveRating = service.saveRating(rating);
		return new ResponseEntity<Rating>(saveRating, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> findAllRating() {
		List<Rating> allRating = service.findAllRating();
		return new ResponseEntity<List<Rating>>(allRating, HttpStatus.OK);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> findRatingById(@PathVariable String ratingId) {
		Rating rating = service.findRatingId(ratingId);
		return new ResponseEntity<Rating>(rating, HttpStatus.OK);
	}

	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> findRatingByUserId(@PathVariable String userId) {
		List<Rating> ratingUserId = service.findRatingByUseId(userId);
		return new ResponseEntity<List<Rating>>(ratingUserId, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> findRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratingHotelId = service.findRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingHotelId, HttpStatus.OK);
	}
}