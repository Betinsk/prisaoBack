package com.federal.prision.inmate;

import java.time.LocalDate;

import com.federal.prision.person.dto.PersonDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class InmateDto extends PersonDto {

	private String commitedCrime;

	private LocalDate arrestDate;

	 private String sentencedYears;

	 public InmateDto(@NotBlank(message = "Social Security is required") String socialSecurity,
			@NotNull(message = "Date of birth is required") @Past LocalDate birthDate,
			@NotBlank(message = "Name is required") String name, @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Gender cannot be empty") String gender, String commitedCrime, LocalDate arrestDate,
			String sentencedYears) {
		super(socialSecurity, birthDate, name, email, gender);
		this.commitedCrime = commitedCrime;
		this.arrestDate = arrestDate;
		this.sentencedYears = sentencedYears;
	 }

	 public String getCommitedCrime() {
		 return commitedCrime;
	 }

	 public void setCommitedCrime(String commitedCrime) {
		 this.commitedCrime = commitedCrime;
	 }

	 public LocalDate getArrestDate() {
		 return arrestDate;
	 }

	 public void setArrestDate(LocalDate arrestDate) {
		 this.arrestDate = arrestDate;
	 }

	 public String getSentencedYears() {
		 return sentencedYears;
	 }

	 public void setSentencedYears(String sentencedYears) {
		 this.sentencedYears = sentencedYears;
	 }
	 
	 
	 
}
