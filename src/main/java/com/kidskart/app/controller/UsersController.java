package com.kidskart.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kidskart.app.pojo.UserDetails;

@RestController
@RequestMapping("/users")
public class UsersController {

	/*
	 * // Reading Path Variables with @PathVariable annotation
	 * 
	 * @GetMapping(path = "/{userId}") public String getUser(@PathVariable String
	 * userId) { return "User Details :" + userId; }
	 */

	// Reading Query String Request Parameters and making Parameters optional or
	// required
	@GetMapping
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "20") int limit,
			@RequestParam(value = "sort", defaultValue = "binary", required = false) String sort) {

		return "page starts from : " + page + " and limit is : " + limit + "\n sorting is : " + sort;

	}

	// Returning Java Object as Return Value
	// Returning Response as either XML or JSON
	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public UserDetails getUserDetails() {

		UserDetails userDetails = new UserDetails();

		userDetails.setAge(30);
		userDetails.setName("Dilip");

		return userDetails;

	}
	
	// Send Response with status codes 

	@PostMapping
	public ResponseEntity<String> postUser() {
		return new ResponseEntity<String>("User Registred Successfully : Dilip", HttpStatus.BAD_REQUEST); // Intentional  of keeping bad request 
	}

	@PutMapping
	public String updateUser() {
		return "User Details updated : Dilip";
	}

	@DeleteMapping
	public String deleteUser() {
		return "User Deleted : Dilip Registred";
	}

}
