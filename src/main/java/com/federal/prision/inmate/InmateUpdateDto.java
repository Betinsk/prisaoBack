package com.federal.prision.inmate;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class InmateUpdateDto {
	
	@NotBlank(message = "Cannot be empty")
	private String commitedCrime;

	@Past
	@NotNull(message = "Cannot be empty")
	private LocalDate arrestDate;

	@NotBlank(message = "Cannot be empty")
	 private String sentencedYears;

	 public InmateUpdateDto(@NotBlank(message = "Cannot be empty") String commitedCrime,
			@NotBlank(message = "Cannot be empty") LocalDate arrestDate,
			@NotBlank(message = "Cannot be empty") String sentencedYears) {
		super();
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
