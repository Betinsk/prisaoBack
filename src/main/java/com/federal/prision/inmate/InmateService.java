package com.federal.prision.inmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.federal.prision.address.Address;
import com.federal.prision.address.AddressService;
import com.federal.prision.address.dto.AddressDto;
import com.federal.prision.person.PersonService;
import com.federal.prision.resource.exceptions.DatabaseException;
import com.federal.prision.resource.exceptions.ResourceNotFoundException;

@Service
public class InmateService {

	@Autowired
	InmateRepository inmateRepository;

	@Autowired
	PersonService personService;
	
	@Autowired 
	AddressService addressService;

	public Inmate fromDto(InmateDto inmateDto) {
		Inmate inmate = new Inmate();
		inmate.setSocialSecurity(inmateDto.getSocialSecurity());
		inmate.setBirthDate(inmateDto.getBirthDate());
		inmate.setName(inmateDto.getName());
		inmate.setEmail(inmateDto.getEmail());
		inmate.setGender(inmateDto.getGender());
		inmate.setArrestDate(inmateDto.getArrestDate());
		inmate.setSentenceYears(inmateDto.getSentenceYears());
		inmate.setCommitedCrime(inmateDto.getCommitedCrime());
		return inmate;
	}

	public Inmate createInmate(InmateDto inmateDto) {

	    Inmate inmate = fromDto(inmateDto);

	    inmate = inmateRepository.save(inmate);

	    List<AddressDto> addressDto = inmateDto.getAddresses();

	    for (AddressDto dto : addressDto) {
	        Address address = addressService.fromDto(dto);
	        addressService.createAddress(address, inmate.getId());
	    }

	    return inmate;
	}

	public List<Inmate> findAll() {
		return inmateRepository.findAll();
	}

	public Inmate findById(Long id) {
		return inmateRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Inmate not found. Id: " + id));
	}

	public void deleteInmate(Long id) {
		if (!inmateRepository.existsById(id)) {
			throw new ResourceNotFoundException("Entity not found. Id: " + id);
		}

		try {
			inmateRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
