package com.federal.prision.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federal.prision.domain.Address;
import com.federal.prision.domain.Person;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.repositories.AddressRepository;
import com.federal.prision.repositories.PersonRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	public Address createAddress(Address address, Long personId) {
		Person person = personRepository.findById(personId)
		.orElseThrow(() -> new RuntimeException("Person not found"));
		address.setPerson(person);
		return addressRepository.save(address);
	}
	
	
	
	public List<Address> findAll() {
		 List<Address> adressList = addressRepository.findAll();
		    if (adressList.isEmpty()) {
		        throw new ObjectNotFoundException(
		            "Dont have a list. Type: " + Address.class.getName()
		        );
		    }
		    return adressList;
	}
}
