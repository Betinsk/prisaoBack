package com.federal.prision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressRepository;
import com.federal.prision.auth.Role;
import com.federal.prision.auth.User;
import com.federal.prision.auth.UserRepository;
import com.federal.prision.inmate.Inmate;
import com.federal.prision.inmate.InmateRepository;
import com.federal.prision.person.Person;
import com.federal.prision.person.PersonRepository;

@SpringBootApplication
public class PrisaoFederalApplication implements CommandLineRunner{

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
    private InmateRepository inmateRepository;

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
		
		Person personOne = new Person(null, "645984", LocalDate.parse("25/12/1971", formatter) , "Whiter White", "WWhite@gmail.com", "Male");
		
		Address address = new Address(null, "123 Central Ave NW","Apt 4B","NM","Albuquerque","US", personOne);
		Address addressTwo = new Address(null, "123 main street Ave NW","Apt 4B","NM","TEXAS","US", personOne);

		address.setPerson(personOne);
		personOne.getAddresses().addAll(Arrays.asList(address, addressTwo));
		personRepository.saveAll(Arrays.asList(personOne));
		addressRepository.saveAll(Arrays.asList(address));
		
		Address inmateAddress = new Address(null, "123 Central Ave NW","Apt 4B","NM","Albuquerque","US", personOne);

		
		Inmate inmate = new Inmate(null, "549488545", LocalDate.parse("25/12/1971", formatter), "Whiter White", "WWhite@gmail.com", "Male", "Drug dealer", LocalDate.parse("25/05/2008", formatter), "32");
		Inmate inmate2 = new Inmate(null, "84989", LocalDate.parse("21/12/1991", formatter), "Jessy Pinkman", "Pinkmane@gmail.com", "Male", "Drug dealer", LocalDate.parse("30/05/2008", formatter), "28");
		
		
		inmateAddress.setPerson(inmate);
		inmate.getAddresses().add(inmateAddress); 
		inmateRepository.saveAll(Arrays.asList(inmate, inmate2));
		addressRepository.saveAll(Arrays.asList(inmateAddress));

		

		User user = new User();
		user.setEmail("admin@email.com");
		user.setPassword(encoder.encode("123456"));
		user.setRole(Role.ROLE_ADMIN);
		user.setPerson(personOne);

		userRepository.save(user); 
	}

}
