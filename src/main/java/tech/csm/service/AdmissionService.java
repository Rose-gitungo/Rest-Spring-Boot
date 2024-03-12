package tech.csm.service;

import java.util.List;

import tech.csm.model.AdmissionTbl;

public interface AdmissionService {

	List<AdmissionTbl> getAllAdmissions();

	void deleteUser(Integer eId);

	void AdmitUser(AdmissionTbl admission);

}
