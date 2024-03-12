package tech.csm.Dao;

import java.util.List;

import tech.csm.model.AdmissionTbl;

public interface AdmissionDao {

	List<AdmissionTbl> getAllAdmission();

	void deleteUser(Integer eId);

	void AdmitUser(AdmissionTbl admission);

	Integer getAdmissionByEId(Integer eId);

	

}
