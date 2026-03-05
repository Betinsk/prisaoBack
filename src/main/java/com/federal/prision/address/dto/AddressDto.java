package com.federal.prision.address.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;

public class AddressDto  implements Serializable {
	private static final long serialVersionUID = 1L;

		@NotBlank(message = "Street name is required")
		private String street;
		
		@NotBlank(message = "addressComplement name is required")
		private String addressComplement;
		
		@NotBlank(message = "State is required")
		private String state;
		
		@NotBlank(message = "City is required")
		private String city;
		
		@NotBlank(message = "City is required")
		private String country;
		private Long personId;

		public AddressDto() {
		}

		public AddressDto(String street, String addressComplement, String state, String city, String country, Long personId) {
			this.street = street;
			this.addressComplement = addressComplement;
			this.state = state;
			this.city = city;
			this.country = country;
			this.personId = personId;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getAddressComplement() {
			return addressComplement;
		}

		public void setAddressComplement(String addressComplement) {
			this.addressComplement = addressComplement;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public Long getPersonId() {
			return personId;
		}

		public void setPersonId(Long personId) {
			this.personId = personId;
		}
	}

