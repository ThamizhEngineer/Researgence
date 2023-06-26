package com.scw.resservice.researchScore;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scw.resservice.model.ReseacherScore;

@Repository
public interface ResearchScoreRepository extends CrudRepository<ReseacherScore,Integer> {

	List<ReseacherScore> findByPubcount(Integer pubcount);

}
