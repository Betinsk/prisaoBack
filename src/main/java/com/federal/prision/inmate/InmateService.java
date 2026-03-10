package com.federal.prision.inmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.federal.prision.resource.exceptions.DatabaseException;
import com.federal.prision.resource.exceptions.ResourceNotFoundException;

@Service
public class InmateService {

	@Autowired
	InmateRepository inmateRepository;	
	
	public List<Inmate> findAll() {
		return inmateRepository.findAll();
	}
	
	public Inmate findById(Long id) {
		return inmateRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException(
	                    "Inmate not found. Id: " + id));
	}
	
	
	public void deleteInmate(Long id) {
		if (!inmateRepository.existsById(id)) {
	        throw new ResourceNotFoundException(
	            "Entity not found. Id: " + id);
	    }

		 try {
			 inmateRepository.deleteById(id);
		    } catch (DataIntegrityViolationException e) {
		        throw new DatabaseException("Integrity violation");
		    }
	}
}
