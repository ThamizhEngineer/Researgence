package com.scw.resservice.facultySummary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scw.resservice.model.Facultysummary;
@Repository
public interface FacultysummaryRepository extends CrudRepository<Facultysummary, Integer>{

}
