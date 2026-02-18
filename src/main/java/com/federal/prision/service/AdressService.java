package com.federal.prision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federal.prision.domain.Address;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.repositories.AdressRepository;

@Service
public class AdressService {

	@Autowired
	AdressRepository adressRepository;
	
	public List<Address> findAll() {
		 List<Address> adressList = adressRepository.findAll();
		    if (adressList.isEmpty()) {
		        throw new ObjectNotFoundException(
		            "Dont have a list. Type: " + Address.class.getName()
		        );
		    }
		    return adressList;
	}
}
