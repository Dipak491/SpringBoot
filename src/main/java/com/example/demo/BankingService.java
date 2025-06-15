package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class BankingService {

	private static final String VALID_USERNAME = "admin";
	private static final String VALID_PASSWORD = "password";
	
	
	
	
//	@PostMapping("/login")
//	String login(@RequestParam String username, @RequestParam String password, HttpSession session)
//	{
//		if(VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password))
//		{
//			session.setAttribute("username", username );
//			return "LOgin sucessfull Welcome "+ username;
//		}
//		else 
//		{
//			return "Invalid username or password";
//		}
//		
//	}
	
	
	
	
	
	
	
	@PostMapping("/login")
	String login(@RequestParam String username, @RequestParam String password, HttpSession session)
	{
		if(VALID_USERNAME.equals(username) && (VALID_PASSWORD.equals(password)))
		{
		return " Login sucessfully";
		}
		else
		{
			return "Invalid";
		}
	}
	
	
	@GetMapping("/logout")
	String logout (HttpSession session)
	{
		session.invalidate();
		return "you have been logout sucessfully";
	}
	
	
	
	
	
	
	
	
	@GetMapping("/deposite/{acc_no}/{amount}")
	String deposite(@PathVariable int acc_no, @PathVariable int amount)
	{
		return "your "+ amount  + " rupees successfully deposited"; 
	}
	
	
	@GetMapping("Welcome")
	String Welcome()
	{
		return "Welcome to the banking application";
	}
}
