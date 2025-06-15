package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Calculator {

	@GetMapping("/add/{iNo1}/{iNo2}")
	String add(@PathVariable int iNo1, @PathVariable int iNo2)
	{
		return "addition is " + (iNo1 + iNo2);
	}
	
	
	@GetMapping("sub/{iNo1}/{iNo2}")
	String sub(@PathVariable int iNo1, @PathVariable int iNo2)
	{
		return "substraction is "+ (iNo1 - iNo2);
	}
}
