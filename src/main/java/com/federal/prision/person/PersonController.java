package com.federal.prision.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.person.dto.PersonDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="person")
public class PersonController {
 
	@Autowired
	PersonService personService; 
	
/*	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDto personDto) {
		Person newPerson = personService.createPerson(personService.fromDto(personDto));
		return ResponseEntity.status(HttpStatus.CREATED).body(newPerson);
	}
	*/
	@PostMapping
	public ResponseEntity<Person> createPersonWithAddress(/*/@Valid*/ @RequestBody PersonDto personDto) {
	    Person person = personService.createPersonWithAddress(personDto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(person);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
	    List<Person> persons = personService.findAll();
	    return ResponseEntity.ok(persons);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Person obj = personService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personRequest) {
	  Person person = personService.updatePerson(id, personRequest);
	     return ResponseEntity.ok().body(person);
	     }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
			   return ResponseEntity.noContent().build();
		                
		}
		
	}
	
