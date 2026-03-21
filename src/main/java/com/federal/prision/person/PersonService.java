package com.federal.prision.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressService;
import com.federal.prision.address.dto.AddressDto;
import com.federal.prision.mapper.PersonMapper;
import com.federal.prision.person.dto.PersonDto;
import com.federal.prision.person.dto.PersonUpdateDto;
import com.federal.prision.resource.exceptions.DatabaseException;
import com.federal.prision.resource.exceptions.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressService addressService;
	
    private final PersonMapper personMapper = new PersonMapper();


	public Person createPerson(Person person) {
		
		if(personRepository.existsBySocialSecurity(person.getSocialSecurity())) {
			throw new DatabaseException ("Social Security already registered");
		}
		return personRepository.save(person);
	}
	
		
		@Transactional
		public Person createPersonWithAddress(PersonDto personDto) {
		Person person = personMapper.fromDto(personDto);
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
	
	public Person updatePerson(Long id, PersonUpdateDto personUpdateDto) {
		Person person = personRepository.findById(id).orElseThrow(
		() -> new ResourceNotFoundException("Person  not found"));
				
		personMapper.updateFromDto(personUpdateDto, person);
		
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
