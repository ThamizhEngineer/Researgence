package com.scw.resservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scw.resservice.model.Facultysummary;
import com.scw.resservice.repository.facultyrepository;

@RestController
@RequestMapping(path = "/summary")
@Component
@Service
public class Facultyservice {
	
	@Autowired
	facultyrepository repo;
	
	@GetMapping("/getall")
	public Iterable<Facultysummary> fetchAll(){
		return repo.findAll();
	}
}
