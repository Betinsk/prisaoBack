package com.federal.prision.inmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="inmate")
public class InmateController {

	@Autowired
	InmateService inmateService;
	
	@GetMapping
	public ResponseEntity<List<Inmate>> findAll() {
	    List<Inmate> inmates = inmateService.findAll();
	    return ResponseEntity.ok(inmates);
	}
}
