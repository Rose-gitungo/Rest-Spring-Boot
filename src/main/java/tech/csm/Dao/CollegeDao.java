package tech.csm.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tech.csm.model.CollegeMaster;

public interface CollegeDao {

	List<CollegeMaster> getAllColleges();

	CollegeMaster getCollegeById(Integer id);
	
	 void updateTotalSeats(Integer id,Integer updateSeats);

}
