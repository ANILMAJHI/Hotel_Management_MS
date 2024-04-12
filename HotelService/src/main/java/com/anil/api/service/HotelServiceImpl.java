package com.anil.api.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.api.entity.Hotel;
import com.anil.api.exception.HotelNotFoundException;
import com.anil.api.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository repository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		return repository.save(hotel);
	}

	@Override
	public List<Hotel> findAllHotel() {

		return repository.findAll();
	}

	@Override
	public Hotel findHotelId(String id) {

		return repository.findById(id).orElseThrow(() -> new HotelNotFoundException("not found resouce"));
	}

}