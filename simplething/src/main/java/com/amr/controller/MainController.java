package com.amr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amr.entity.Details;
import com.amr.service.MainService;

@RestController
public class MainController {
	
	@Autowired
	MainService service;
	
	@PostMapping("/in")
	public ResponseEntity<Details> postDetails(@RequestBody Details details) {
		return service.saveDetails(details);
		
	}
	
	@GetMapping("/out/{id}")
	public ResponseEntity<Details> getDetails(@PathVariable Long id){
		return service.getDetails(id);
	}
	
	@PutMapping("/put")
	public ResponseEntity<Details> updateDetails(@RequestBody Details details){
		return service.updateDetails(details);
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Details> deleteDetails(@PathVariable Long id){
		return service.deleteDetails(id);
	}
}
