package com.anil.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.anil.api.entity.Hotel;
import com.anil.api.entity.Rating;
import com.anil.api.entity.User;
import com.anil.api.exception.UserNotFoundException;
import com.anil.api.extranal.HotelService;
import com.anil.api.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	private static final String RATING_URL = "http://RATING-SERVICE/rating/users/";
	private static final String HOTEL_URL = "http://HOTELSERVICE/hotel/";

	@Override
	public User saveUser(User user) {

		return repository.save(user);
	}

	@Override
	public List<User> findAllUser() {
		return repository.findAll();
	}

	public User getUserId1(String userId) {
		User user = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("Id Not Found"));

		ArrayList<Rating> ratingofUsers = restTemplate.getForObject(RATING_URL + user.getUserId(), ArrayList.class);

		user.setRatings(ratingofUsers);

		return user;

	}

	public User getUserId(String userId) {
		User userById = repository.findById(userId).orElseThrow(() -> new UserNotFoundException("Id Not Found"));

		// fetch rating of the above user from RATING SERVICE
		Rating[] ratingofUsers = restTemplate.getForObject(RATING_URL + userById.getUserId(), Rating[].class);

		if (ratingofUsers != null && ratingofUsers.length > 0) {
			List<Rating> ratings = Arrays.asList(ratingofUsers);

			// Fetch hotel data for each rating
			List<Rating> listRating = ratings.stream().map(rating -> {
				try {
					//ResponseEntity<Hotel> forHotel = restTemplate.getForEntity(HOTEL_URL + rating.getHotelId(), Hotel.class);
					//Hotel hotel = forHotel.getBody();
					Hotel hotel=hotelService.getHotel(rating.getHotelId());
					
					rating.setHotel(hotel);
				} catch (HttpServerErrorException.InternalServerError e) {
					// Handle HotelNotFoundException here
					// For example, you can log the error and set hotel to null or handle it as
					// appropriate
					rating.setHotel(null);
				}
				return rating;
			}).collect(Collectors.toList());

			// Set the updated ratings list with hotel information to the user
			userById.setRatings(listRating);
		}

		return userById;
	}

}
