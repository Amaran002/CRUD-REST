package com.amr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.amr.Repository.DataRepository;
import com.amr.entity.Details;

@Service
public class MainService {
	
	@Autowired
	DataRepository repo;
	
	
	public ResponseEntity<Details> saveDetails(@RequestBody Details details) {
		try {
		repo.save(details);
		return new ResponseEntity<>(details, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	public ResponseEntity<Details> getDetails(@PathVariable Long id){
		
		try {
		Optional<Details> getData= repo.findById(id);
		
		if(getData.isPresent()) {
			return new ResponseEntity<> (getData.get(), HttpStatus.OK);
		}else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		}catch(Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	public ResponseEntity<Details> updateDetails(@RequestBody Details details){
		try {
		 repo.save(details);
		    return new ResponseEntity<> (details, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	public ResponseEntity<Details> deleteDetails(@PathVariable Long id){
		try {
		Optional<Details> deleteData = repo.findById(id);
		
		if(deleteData.isPresent()) {
			repo.delete(deleteData.get());
			return new ResponseEntity<> (HttpStatus.ACCEPTED);

		}else
		return new ResponseEntity<> (HttpStatus.NO_CONTENT);
	}catch(Exception e) {
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
}
