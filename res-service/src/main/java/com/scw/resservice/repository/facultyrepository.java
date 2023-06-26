package com.scw.resservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.scw.resservice.model.Facultysummary;

@Repository
public interface facultyrepository  extends CrudRepository<Facultysummary, Integer> {

}
