package com.federal.prision.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.federal.prision.domain.Person;
import com.federal.prision.exceptions.ObjectNotFoundException;
import com.federal.prision.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findById(Integer id) {
		Optional<Person> obj = personRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not Found "+ id+ ", Type: "+ Person.class.getName()));
		
	}
}
