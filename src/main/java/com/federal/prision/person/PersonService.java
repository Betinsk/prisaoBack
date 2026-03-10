package com.federal.prision.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressService;
import com.federal.prision.address.dto.AddressDto;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.person.dto.PersonDto;
import com.federal.prision.resource.exceptions.DatabaseException;
import com.federal.prision.resource.exceptions.ResourceNotFoundException;
import com.federal.prision.resource.exceptions.ValidationException;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressService addressService;
	
	public Person fromDto(PersonDto personDto) {
		Person person = new Person();
		person.setSocialSecurity(personDto.getSocialSecurity());
	    person.setBirthDate(personDto.getBirthDate());
		person.setName(personDto.getName());
		person.setEmail(personDto.getEmail());
	    return person;
	}
	
	public Person createPerson(Person person) {
		
		if(personRepository.existsBySocialSecurity(person.getSocialSecurity())) {
			throw new DatabaseException ("Social Security already registered");
		}
		return personRepository.save(person);
	}
	
		
		@Transactional
		public Person createPersonWithAddress(PersonDto personDto) {
		Person person = fromDto(personDto);
		createPerson(person);
		List<AddressDto> addressDto = personDto.getAddresses();
		 for (AddressDto dto : addressDto) {
		        Address address = addressService.fromDto(dto);
		        addressService.createAddress(address, person.getId());
		    }
		return person;

	}
	
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		return personRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(
	                    "Person not found. Id: " + id));
	}
	
	public Person updatePerson(Long id, Person personRequest) {
		Person person = personRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("User not found"));
				
		person.setSocialSecurity(personRequest.getSocialSecurity());
		person.setBirthDate(personRequest.getBirthDate());
		person.setName(personRequest.getName());
		person.setEmail(personRequest.getEmail());
		return personRepository.save(person);
		
	}
	
	public void deletePerson(Long id) {
		 try {
		        personRepository.deleteById(id);
		    } catch (EmptyResultDataAccessException e) {
		        throw new ResourceNotFoundException(
		            "Object Not Found " + id + ", Type: " + Person.class.getName()
		        );
		    }
	}
}
