package com.federal.prision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressRepository;
import com.federal.prision.person.Person;
import com.federal.prision.person.PersonRepository;

@SpringBootApplication
public class PrisaoFederalApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	DateTimeFormatter formatter =
	        DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		SpringApplication.run(PrisaoFederalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	/*	Person personOne = new Person(null, "188148443", LocalDate.parse("25/12/1971", formatter) , "Whiter White", "WWhite@gmail.com");
		
		Address address = new Address(null, "123 Central Ave NW","Apt 4B","NM","Albuquerque","US", personOne);
		address.setPerson(personOne);
		personOne.getAddresses().add(address);
		personRepository.saveAll(Arrays.asList(personOne));
		addressRepository.saveAll(Arrays.asList(address));
		*/
	}

}
