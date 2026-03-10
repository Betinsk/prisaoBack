package com.federal.prision.inmate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.person.Person;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Inmate inmate = inmateService.findById(id);
		return ResponseEntity.ok().body(inmate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInmate(@PathVariable Long id) {
		inmateService.deleteInmate(id);
	return ResponseEntity.ok("Inmate deleted with success "+ id); 
		                
		}
	
	
}
