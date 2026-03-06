package com.federal.prision.address;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.federal.prision.address.dto.AddressDto;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.person.Person;
import com.federal.prision.person.PersonRepository;

import jakarta.transaction.Transactional;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	
	public Address fromDto(AddressDto addressDto) {
		Address address = new Address();
		address.setStreet(addressDto.getStreet());
		address.setAddressComplement(addressDto.getAddressComplement());
		address.setState(addressDto.getState());
		address.setCity(addressDto.getCity());
		address.setCountry(addressDto.getCountry());
		
		Person person = new Person();
	    person.setId(addressDto.getPersonId());

	    address.setPerson(person);
		
	    return address;
	}
	
	public Address createAddress(Address address, Long personId) {
		Person person = personRepository.findById(personId)
		.orElseThrow(() -> new RuntimeException("Person not found"));
		address.setPerson(person);
		return addressRepository.save(address);
	}
	
	public Address findById(Long id) {
		Optional<Address> address = addressRepository.findById(id);
		return address.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not Found "+ id+ ", Type: "+ Address.class.getName()));	
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
	
	public Address updateAddress(Long id, Address addressRequest) {
		Address address = addressRepository.findById(id).orElseThrow(
				() -> new RuntimeException("User not found"));
		
		address.setStreet(addressRequest.getStreet());
		address.setAddressComplement(addressRequest.getAddressComplement());
		address.setState(addressRequest.getState());
		address.setCity(addressRequest.getCity());
		address.setCountry(addressRequest.getCountry());
		return addressRepository.save(address);
	}
	
	public void deleteAdress(Long id) {
		 try {
		        addressRepository.deleteById(id);
		    } catch (EmptyResultDataAccessException e) {
		        throw new ObjectNotFoundException(
		            "Object Not Found " + id + ", Type: " + Address.class.getName()
		        );
		    }
	}
	
	
	
}
