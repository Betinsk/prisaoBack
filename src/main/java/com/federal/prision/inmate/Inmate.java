package com.federal.prision.inmate;

import java.time.LocalDate;

import com.federal.prision.person.Person;

import jakarta.persistence.Entity;

@Entity
public class Inmate extends Person{

	private String commitedCrime;

	private LocalDate arrestDate;

	 private String sentencedYears;
	
	 public Inmate() {
		 
	 }

	 public Inmate(Long id, String socialSecurity, LocalDate birthDate, String name, String email, String gender, String imageUrl, String commitedCrime,
			LocalDate arrestDate, String sentencedYears) {
		super(id, socialSecurity, birthDate, name, email, gender, imageUrl);
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

