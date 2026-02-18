package com.federal.prision.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String streetAddress;
	private String addressComplement;
	private String state;
	private String city;
	private String country;
	
	@ManyToOne
	@JoinColumn(name="person_id")
	@JsonBackReference
	private Person person;
	
	public Address() {
		
	}

	public Address(Integer id, String streetAdress, String adressComplement, String state, String city, String country) {
		this.id = id;
		this.streetAddress = streetAdress;
		this.addressComplement = adressComplement;
		this.state = state;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getStreetAdress() {
		return streetAddress;
	}

	public void setStreetAdress(String streetAdress) {
		this.streetAddress = streetAdress;
	}

	public String getAdressComplement() {
		return addressComplement;
	}

	public void setAdressComplement(String adressComplement) {
		this.addressComplement = adressComplement;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
