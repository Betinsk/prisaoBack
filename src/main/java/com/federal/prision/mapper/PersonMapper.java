package com.federal.prision.mapper;

import com.federal.prision.person.Person;
import com.federal.prision.person.dto.PersonUpdateDto;

public class PersonMapper {

	
	public PersonMapper() {
		
	}
	
	public void updateFromDto(PersonUpdateDto personUpdateDto, Person person) {
	    person.setName(personUpdateDto.getName());
	    person.setEmail(personUpdateDto.getEmail());
	    person.setBirthDate(personUpdateDto.getBirthDate());
	}
	
	
	
}
