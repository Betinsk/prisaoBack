package com.federal.prision.person.dto;

import java.time.LocalDate;
import java.util.List;

import com.federal.prision.address.dto.AddressDto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class PersonDto {

	@NotBlank(message = "Social Security is required")
    private String socialSecurity;

    @NotNull(message = "Date of birth is required")
    @Past
    private LocalDate birthDate;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    private String email;

    @Valid
    @NotNull(message = "Address is required")
    private List<AddressDto> addresses;

    public PersonDto() {
    }
    
	public PersonDto(@NotBlank(message = "Social Security is required") String socialSecurity,
			@NotNull(message = "Date of birth is required") @Past LocalDate birthDate,
			@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Email is required") String email) {
		this.socialSecurity = socialSecurity;
		this.birthDate = birthDate;
		this.name = name;
		this.email = email;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
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

	public List<AddressDto> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}
	

    
}
