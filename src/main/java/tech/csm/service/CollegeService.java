package tech.csm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.csm.model.CollegeMaster;


public interface CollegeService {

	List<CollegeMaster> getAllColleges();

	CollegeMaster getCollegeById(Integer id);

}
