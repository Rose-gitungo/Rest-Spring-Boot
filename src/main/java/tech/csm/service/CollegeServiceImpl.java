package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.Dao.CollegeDao;
import tech.csm.model.CollegeMaster;
@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeDao collegeDao;
	
	@Override
	public List<CollegeMaster> getAllColleges() {
		return collegeDao.getAllColleges();
	}

	@Override
	public CollegeMaster getCollegeById(Integer id) {
		return collegeDao.getCollegeById(id);
	}

}
