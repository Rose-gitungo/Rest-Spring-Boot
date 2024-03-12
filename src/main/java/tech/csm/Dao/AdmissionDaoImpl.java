package tech.csm.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tech.csm.model.CollegeMaster;

import tech.csm.model.AdmissionTbl;
@Repository
public class AdmissionDaoImpl implements AdmissionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<AdmissionTbl> getAllAdmission() {
		String sql="call getAllapplication()";
		List<AdmissionTbl> admissionList=new ArrayList<>();
				jdbcTemplate.query(sql, new RowMapper<AdmissionTbl>() {

			@Override
			public AdmissionTbl mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdmissionTbl a= new AdmissionTbl();
				a.setEnrollementId(rs.getInt("enrollement_id"));
				a.setApplicantName(rs.getString("applicant_name"));
				
				CollegeMaster c= new CollegeMaster();
				c.setCollegeId(rs.getInt("college_id"));
				c.setCollegeName(rs.getString("college_name"));
				c.setCourseFee(rs.getDouble("course_fee"));
				c.setTotalSeats(rs.getInt("total_seats"));
				
				a.setCollege(c);
				a.setEnrollmentDate(rs.getDate("enrollment_date"));
				a.setFourthOption(rs.getString("fourth_optional"));
				admissionList.add(a);

				return a;
			}});
		return admissionList;
	}
	

	@Override
	public Integer getAdmissionByEId(Integer eId) {
				Integer x= jdbcTemplate.queryForObject("CALL getAdmissionByeId(?)",Integer.class ,eId);
				System.out.println(x);
				return x;
		
	}

	@Override
	public void deleteUser(Integer eId) {
		 jdbcTemplate.update("CALL deleteUser(?)", eId);
		}

	@Override
	public void AdmitUser(AdmissionTbl admission) {
		 Integer collegeId = admission.getCollege().getCollegeId();
			jdbcTemplate.update("CALL saveUser(?, ?, ?, ?, ?)",admission.getEnrollementId(),admission.getApplicantName(),
					admission.getFourthOption(),admission.getEnrollmentDate(),collegeId);
		
	}



}
