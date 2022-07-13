package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationModel 
{
	
	
	public RegistrationModel
	(	@NotNull(message = "First name is a required field") String firstName,
		@NotNull(message = "Last name is a required field") String lastName,
		@NotNull(message = "Email is a required field") String email,
		@NotNull(message = "Phone number is a required field") String phoneNumber,
		@NotNull(message = "Username is a required field") @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters") String username,
		@NotNull(message = "Password is a required field") @Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters") String password
	) 
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.password = password;
	}
	public RegistrationModel()
	{
		
	}
	@NotNull(message="First name is a required field")
	private String firstName;
	
	@NotNull(message="Last name is a required field")
	private String lastName;
	
	@NotNull(message="Email is a required field")
	private String email;
	
	@NotNull(message="Phone number is a required field")
	private String phoneNumber;
	
	@NotNull(message="Username is a required field")
	@Size(min = 1, max = 32, message="Username must be between 1 and 32 characters")
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min = 1, max = 32, message="Password must be between 1 and 32 characters")
	private String password;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", password=" + password + "]";
	}

	
}
