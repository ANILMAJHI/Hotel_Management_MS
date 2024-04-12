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

import com.anil.api.entity.Hotel;
import com.anil.api.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {

		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		Hotel saveHotel = hotelService.createHotel(hotel);
		return new ResponseEntity<>(saveHotel, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> findAllHotel() {
		List<Hotel> hotels = hotelService.findAllHotel();
		return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> findHotelId(@PathVariable String id) {
		Hotel hotelId = hotelService.findHotelId(id);
		return new ResponseEntity<Hotel>(hotelId, HttpStatus.OK);

	}
}