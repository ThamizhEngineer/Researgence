package com.scw.resservice.facultySummary;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scw.resservice.model.FacultyDetail;

@Repository
public interface FacultydetailRepository extends CrudRepository<FacultyDetail, String>{

	@Query(value="SELECT * FROM s_faculty_detail WHERE slno =?1",nativeQuery=true)
	List<FacultyDetail> findBySlno(Integer slno);

}
