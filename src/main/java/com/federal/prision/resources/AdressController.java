package com.federal.prision.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.domain.Adress;
import com.federal.prision.service.AdressService;

@RestController
@RequestMapping(value="adress")
public class AdressController {

	@Autowired
	AdressService adressService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Adress> adresses = adressService.findAll();
		return ResponseEntity.ok().body(adresses);

	}
	
}
