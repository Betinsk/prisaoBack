package com.federal.prision.mapper;

import com.federal.prision.person.Person;
import com.federal.prision.person.dto.PersonDto;
import com.federal.prision.person.dto.PersonUpdateDto;

public class PersonMapper {

	
	public PersonMapper() {
		
	}
	
	public void updateFromDto(PersonUpdateDto personUpdateDto, Person person) {
	    person.setName(personUpdateDto.getName());
	    person.setEmail(personUpdateDto.getEmail());
	    person.setGender(personUpdateDto.getGender());
	    person.setBirthDate(personUpdateDto.getBirthDate());
	}

	
	public Person fromDto(PersonDto personDto) {
		Person person = new Person();
		person.setSocialSecurity(personDto.getSocialSecurity());
	    person.setBirthDate(personDto.getBirthDate());
		person.setName(personDto.getName());
		person.setEmail(personDto.getEmail());
		person.setGender(personDto.getGender());
	    return person;
	}
}
