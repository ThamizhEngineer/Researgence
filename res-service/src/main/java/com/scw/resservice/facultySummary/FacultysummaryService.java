package com.scw.resservice.facultySummary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scw.resservice.model.FacultyDetail;
import com.scw.resservice.model.Facultysummary;

@RestController
@RequestMapping(path = "/faculty")
public class FacultysummaryService {
	
	@Autowired
	FacultysummaryRepository facultyRepo;
	
	@Autowired
	FacultydetailRepository detailRepo;

	@GetMapping("/getall")
	public Iterable<Facultysummary> fetchAll(){
		return facultyRepo.findAll();
	}
	
	@GetMapping("/getdetail")
	public List<FacultyDetail> findbyDetail(@RequestParam(name="Slno", required=false) Integer Slno){
		return detailRepo.findBySlno(Slno);
	}
}
