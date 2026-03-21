package com.federal.prision.auth;

public class UserDto {
	
	public record LoginRequest(String email, String password) {}

}
