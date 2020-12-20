package com.navyug.ATM.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.navyug.ATM.h2.models.User;
import com.navyug.ATM.service.NavyugAtmService;




@RestController
@CrossOrigin(origins = "*")
public class AtmController {

	@Autowired
	NavyugAtmService navService;
	
	
	@GetMapping("/check-balance/{account_id}")
	private ResponseEntity<?> getBalance(@PathVariable("account_id") Long id) 
	{
		
	try {
		return new ResponseEntity<>(navService.getBalance(id),HttpStatus.OK);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/withdraw")
	private ResponseEntity<?> withdraw(@RequestBody Map<String,Object> requestBody) 
	{
	
	try {
		return new ResponseEntity<>(navService.withdrawMoney(requestBody),HttpStatus.OK);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/deposit")
	private ResponseEntity<?> deposit(@RequestBody Map<String,Object> requestBody) 
	{
	try {
		return new ResponseEntity<>(navService.depositMoney(requestBody),HttpStatus.OK);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/newUser")
	private ResponseEntity<?> newUser(@RequestBody User user) 
	{
		
	try {
		return new ResponseEntity<>(navService.addNewUser(user),HttpStatus.OK);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new ResponseEntity<>("ERROR",HttpStatus.BAD_REQUEST);
	}
}
