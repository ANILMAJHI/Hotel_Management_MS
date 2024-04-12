package com.anil.api.service;

import java.util.List;

import com.anil.api.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> findAllHotel();

	Hotel findHotelId(String id);

}
