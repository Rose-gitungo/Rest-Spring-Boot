package tech.csm.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tech.csm.model.CollegeMaster;

@Repository
public class CollegeDaoImpl implements CollegeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<CollegeMaster> getAllColleges() {
		String sql="call getAllColleges()";
		List<CollegeMaster> colleList = new ArrayList<>();
		jdbcTemplate.query(sql, new RowMapper<CollegeMaster>() {

			@Override
			public CollegeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
				CollegeMaster c= new CollegeMaster();
				c.setCollegeId(rs.getInt(1));
				c.setCollegeName(rs.getString(2));
				c.setTotalSeats(rs.getInt(3));
				c.setCourseFee(rs.getDouble(4));
				colleList.add(c);
				return c;
			}});
		return colleList;
		
		
	}

	@Override
	public CollegeMaster getCollegeById(Integer id) {
	    String sql = "CALL GetCollegeById(?)";
	    CollegeMaster c = new CollegeMaster();;
	    jdbcTemplate.query(sql, new PreparedStatementSetter() {
	  
	    				@Override
	    				public void setValues(PreparedStatement ps) throws SQLException {
	    					ps.setInt(1, id);
	    					
	    				}}, new RowMapper<CollegeMaster>() {
	    	
	    					@Override
	    					public CollegeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
	    						c.setCollegeId(rs.getInt("college_id"));
	    						c.setCollegeName(rs.getString("college_name"));
	    						c.setCourseFee(rs.getDouble("course_fee"));
	    						c.setTotalSeats(rs.getInt("total_seats"));
	    						return c;
	    					}
	    				});
	    return c;
	    		    
	}

	
	public void updateTotalSeats(Integer id,Integer updateSeats) {
		String sql="call updateTotalSeats(?,?)" ;
		 jdbcTemplate.update(sql, updateSeats, id);
	}

}
