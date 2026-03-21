package com.federal.prision.person.dto;

import java.time.LocalDate;

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
    
    @NotBlank(message = "Gender cannot be empty")
    private String gender;

    
    public PersonUpdateDto() {
    	
    }

	public PersonUpdateDto(@NotNull(message = "Date of birth is required") @Past LocalDate birthDate,
			@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Gender cannot be empty") String gender)
{
		super();
		this.birthDate = birthDate;
		this.name = name;
		this.email = email;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
	

}
