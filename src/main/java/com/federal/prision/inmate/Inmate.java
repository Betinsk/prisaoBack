package com.federal.prision.inmate;

import java.time.LocalDate;

import com.federal.prision.person.Person;

import jakarta.persistence.Entity;

@Entity
public class Inmate extends Person{

	private String commitedCrime;

	private LocalDate arrestDate;

	 private Integer sentenceYears;
	
	 public Inmate() {
		 
	 }

	 public Inmate(Long id, String socialSecurity, LocalDate birthDate, String name, String email, String gender, String commitedCrime,
			LocalDate arrestDate, Integer sentenceYears) {
		super(id, socialSecurity, birthDate, name, email, gender);
		this.commitedCrime = commitedCrime;
		this.arrestDate = arrestDate;
		this.sentenceYears = sentenceYears;
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

	 public Integer getSentenceYears() {
		 return sentenceYears;
	 }

	 public void setSentenceYears(Integer sentenceYears) {
		 this.sentenceYears = sentenceYears;
	 }
	 
	 
	 
}

