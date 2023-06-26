package com.scw.resservice.researchPublicationDetail;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scw.resservice.model.ResPublicationDetails;

@Repository
public interface ResPublicationDetailRepo extends CrudRepository<ResPublicationDetails,Integer>{

	List<ResPublicationDetails> findByRecordid(Integer recordid);

}
