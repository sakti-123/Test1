package com.rs.fer.main;

import com.rs.fer.bean.User;
import com.rs.fer.service.FERServiceImpl;
import com.rs.fer.service.FerService;

public class LoginMain {

	public static void main(String[] args) {
		FerService ferService = new FERServiceImpl();
		User user = new User();
		boolean isValidUser = ferService.login("sbd111", "sbd111");
		if (isValidUser) {
			System.out.println("Login Successful...");
		} else {
			System.out.println("Login Failed. Try again...");
		}

	}

}
