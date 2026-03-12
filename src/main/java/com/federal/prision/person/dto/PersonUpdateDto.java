package com.federal.prision.person.dto;

import java.time.LocalDate;

import com.federal.prision.person.Person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PersonUpdateDto {

	@NotNull(message = "Date of birth is required")
    @Past
    private LocalDate birthDate;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;
    
    public PersonUpdateDto() {
    	
    }

	public PersonUpdateDto(@NotNull(message = "Date of birth is required") @Past LocalDate birthDate,
			@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Email is required") String email) {
		super();
		this.birthDate = birthDate;
		this.name = name;
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	public void updateFromDto(PersonUpdateDto personUpdateDto, Person person) {
	    person.setName(personUpdateDto.getName());
	    person.setEmail(personUpdateDto.getEmail());
	    person.setBirthDate(personUpdateDto.getBirthDate());
	}
	
}
