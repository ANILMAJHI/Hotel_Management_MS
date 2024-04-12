package com.anil.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.api.entity.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
