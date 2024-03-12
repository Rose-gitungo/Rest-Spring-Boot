package tech.csm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tech.csm.model.AdmissionTbl;
import tech.csm.model.CollegeMaster;
import tech.csm.service.AdmissionService;
import tech.csm.service.CollegeService;

@RestController
@RequestMapping("/getform")
public class MyController {

	@Autowired
	CollegeService collegeService;
	
	@Autowired
	AdmissionService admissionService;
		
	 @GetMapping("/colleges")
	    public List<CollegeMaster> getAllColleges() { 
	        return collegeService.getAllColleges();
	    }
	 
	 @GetMapping("/admission")
	    public List<AdmissionTbl> getAllAdmissions() { 
	        return admissionService.getAllAdmissions();
	    }
	 
	 @DeleteMapping("/deleteUser/{eId}")
	 public ResponseEntity<String> deleteAdmission(@PathVariable("eId") Integer eId) {
		 admissionService.deleteUser(eId);
		 return ResponseEntity.ok("User deleted successfully");
	 }
	
	 @GetMapping("/getCollegeById/{id}")
	 public CollegeMaster getCollegeById(@PathVariable("id") Integer id) {
		return collegeService.getCollegeById(id);
		 
	 }
	 
	 @PostMapping("/AdmitStudent")
	 public ResponseEntity<String> saveAdmission(@RequestBody AdmissionTbl admission,RedirectAttributes rd) {
		 admissionService.AdmitUser(admission);
		 return ResponseEntity.ok("User SAved successfully");
	 }
}
