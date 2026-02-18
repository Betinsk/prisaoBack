package com.federal.prision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federal.prision.domain.Adress;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.repositories.AdressRepository;

@Service
public class AdressService {

	@Autowired
	AdressRepository adressRepository;
	
	public List<Adress> findAll() {
		 List<Adress> adressList = adressRepository.findAll();
		    if (adressList.isEmpty()) {
		        throw new ObjectNotFoundException(
		            "Dont have a list. Type: " + Adress.class.getName()
		        );
		    }
		    return adressList;
	}
}
