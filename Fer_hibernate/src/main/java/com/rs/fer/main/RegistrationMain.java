package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FerService;
import com.rs.fer.service.FERServiceImpl;

public class RegistrationMain {

	public static void main(String[] args) {
		
		FerService ferService = new FERServiceImpl();
		
		User user = new User();
		user.setFirstName("q");
		user.setMiddleName("q");
		user.setLastName("q");
		
		user.setUsername("q");
		user.setPassword("q");
		
		user.setEmail("q@gmail.com");
		user.setMobile("10100102154");
		
		boolean isRegister = ferService.registration(user);
		
		if (isRegister) {
			System.out.println("Registration completed successfully...");
		} else {
			System.out.println("Registration failed");

		}
	}

}
