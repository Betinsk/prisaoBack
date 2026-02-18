package com.federal.prision.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.domain.Person;
import com.federal.prision.service.PersonService;

@RestController
@RequestMapping(value="person")
public class PersonController {

	@Autowired
	PersonService personService;
	 
	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
	    List<Person> persons = personService.findAll();
	    return ResponseEntity.ok(persons);
	}

	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getPersonById(@PathVariable Integer id) {
		Person obj = personService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
