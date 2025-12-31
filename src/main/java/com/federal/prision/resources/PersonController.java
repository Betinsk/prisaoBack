package com.federal.prision.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.domain.Person;

@RestController
@RequestMapping(value="personController")
public class PersonController {

	DateTimeFormatter formatter =
	        DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> getPersons() {
		
		List<Person> listPerson = new ArrayList<>();
		
		Person person = new Person(1, "125884897", LocalDate.parse("05/12/1993", formatter), "Whiter White", "White@outlook.com"); 
		listPerson.add(person);
		
		return listPerson;
	}
	
	
}
