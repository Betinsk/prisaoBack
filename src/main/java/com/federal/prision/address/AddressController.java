package com.federal.prision.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.federal.prision.address.dto.AddressDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="addresses")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<Address> addresses = addressService.findAll();
		return ResponseEntity.ok().body(addresses);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable Long id){
		Address address = addressService.findById(id);	
		return ResponseEntity.ok().body(address);
	}
	
	@PostMapping("/persons/{personId}/addresses")
	    public Address create(
	        @PathVariable Long personId,
	        @Valid @RequestBody AddressDto addressDto
	    ) {
	        return addressService.createAddress(addressService.fromDto(addressDto), personId);
	    }
	
	@PutMapping("/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody @Valid AddressDto addressRequest) {
	Address address = addressService.updateAddress(id, addressService.fromDto(addressRequest));
	    return ResponseEntity.ok().body(address);
	     }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
		addressService.deleteAdress(id);
			   return ResponseEntity.noContent().build();
		                
		}
		
}
