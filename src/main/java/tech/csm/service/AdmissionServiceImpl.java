package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tech.csm.Dao.AdmissionDao;
import tech.csm.Dao.CollegeDao;
import tech.csm.model.AdmissionTbl;
import tech.csm.model.CollegeMaster;

@Service
@Transactional
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	AdmissionDao admissionDao;
	
	@Autowired
	CollegeDao collegeDao;
	
	@Override
	public List<AdmissionTbl> getAllAdmissions() {
		return admissionDao.getAllAdmission();
	}
	
		@Override
		public void deleteUser(Integer eId) {			
			Integer collegeId = admissionDao.getAdmissionByEId(eId);
		 CollegeMaster c=collegeDao.getCollegeById(collegeId);		  
		 Integer seatsupdated= c.getTotalSeats()+1;
		 collegeDao.updateTotalSeats(collegeId,seatsupdated);
			 admissionDao.deleteUser(eId);
			
		}

		@Override
		public void AdmitUser(AdmissionTbl admission) {
			 Integer collegeId = admission.getCollege().getCollegeId();
			 CollegeMaster c= collegeDao.getCollegeById(collegeId);			 
			 Integer updatedSeats=c.getTotalSeats()-1;
			
			 if (updatedSeats!=0) {
				 c.setTotalSeats(updatedSeats);
				 collegeDao.updateTotalSeats(collegeId,updatedSeats);
				 admissionDao.AdmitUser(admission);
			}else {
				System.out.println("Seats are not enough in uni!");
			}
		}
		


}
