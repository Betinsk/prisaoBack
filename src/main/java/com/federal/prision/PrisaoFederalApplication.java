package com.federal.prision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.federal.prision.domain.Adress;
import com.federal.prision.domain.Person;
import com.federal.prision.repositories.AdressRepository;
import com.federal.prision.repositories.PersonRepository;

@SpringBootApplication
public class PrisaoFederalApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AdressRepository adressRepository;
	
	DateTimeFormatter formatter =
	        DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		SpringApplication.run(PrisaoFederalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Person personOne = new Person(null, "188448443", LocalDate.parse("25/12/1971", formatter) , "Whiter White", "WWhite@gmail.com");
		
		Adress adress = new Adress(null, "123 Central Ave NW","Apt 4B","NM","Albuquerque","US");
		adress.setPerson(personOne);
		personOne.getAdresses().add(adress);
		personRepository.saveAll(Arrays.asList(personOne));	
		adressRepository.saveAll(Arrays.asList(adress));

		
	}

}
