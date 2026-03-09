package com.federal.prision.inmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InmateService {

	@Autowired
	InmateRepository inmateRepository;	
	
	public List<Inmate> findAll() {
		return inmateRepository.findAll();
	}
	
}
