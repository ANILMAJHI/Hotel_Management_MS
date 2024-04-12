package com.anil.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.api.dto.AddressDto;
import com.anil.api.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	private static final Logger log = LoggerFactory.getLogger(AddressController.class);

	@PostMapping
	public ResponseEntity<AddressDto> save(@RequestBody AddressDto addressDto) {

		log.info("***save the data in db address controller classes*** ");
		AddressDto dto = addressService.save(addressDto);
		return new ResponseEntity<AddressDto>(dto, HttpStatus.OK);

	}
}
