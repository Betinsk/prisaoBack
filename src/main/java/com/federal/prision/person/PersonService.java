package com.federal.prision.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.person.dto.PersonDto;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	
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
			throw new RuntimeException("Social Security already registered");
		}
		return personRepository.save(person);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		Optional<Person> obj = personRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not Found "+ id+ ", Type: "+ Person.class.getName()));
	}
	
	public Person updatePerson(Long id, Person personRequest) {
		Person person = personRepository.findById(id).orElseThrow(
		() -> new RuntimeException("User not found"));
				
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
		        throw new ObjectNotFoundException(
		            "Object Not Found " + id + ", Type: " + Person.class.getName()
		        );
		    }
	}
}
