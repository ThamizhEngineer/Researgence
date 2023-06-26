package com.scw.resservice.researchScore;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scw.resservice.model.FacultyDetail;
import com.scw.resservice.model.Facultysummary;
import com.scw.resservice.model.ReseacherScore;

@RestController
@RequestMapping(path = "/score")
public class ResearchScoreService {
	
	@Autowired
	ResearchScoreRepository scorerepo;
	
	@GetMapping("/getall")
	public Iterable<ReseacherScore> fetchAll(){
		return scorerepo.findAll();
	}
	
	@GetMapping("/getdetail")
	public List<ReseacherScore> findbyDetail(@RequestParam(name="Pubcount", required=false) Integer Pubcount){
		return scorerepo.findByPubcount(Pubcount);
	}

}
