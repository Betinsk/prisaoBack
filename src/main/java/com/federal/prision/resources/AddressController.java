package com.federal.prision.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.domain.Address;
import com.federal.prision.service.AddressService;

@RestController
@RequestMapping(value="address")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Address> addresses = addressService.findAll();
		return ResponseEntity.ok().body(addresses);

	}
	
}
