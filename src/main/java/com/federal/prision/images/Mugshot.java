package com.federal.prision.images;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.federal.prision.person.Person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Mugshot {

    @Id
    @GeneratedValue
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;
    
    public Mugshot() {
    	
    }

	public Mugshot(Long id, String imageUrl, Person person) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.person = person;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
    
    
}