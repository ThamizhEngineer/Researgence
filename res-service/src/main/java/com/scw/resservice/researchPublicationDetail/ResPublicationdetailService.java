package com.scw.resservice.researchPublicationDetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scw.resservice.model.FacultyDetail;
import com.scw.resservice.model.ResPublicationDetails;

@RestController
@RequestMapping(path = "/publication")
public class ResPublicationdetailService {
	@Autowired
	ResPublicationDetailRepo pubrepo;
	
	@GetMapping("/get")
	public Iterable<ResPublicationDetails> fetchAll(){
		return pubrepo.findAll();
	}
	
	@GetMapping("/finddetail")
	public List<ResPublicationDetails> findbyDetail(@RequestParam(name="Recordid", required=false) Integer Recordid){
		return pubrepo.findByRecordid(Recordid);
	}
}
