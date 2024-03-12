package tech.csm.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CollegeMaster implements Serializable {
	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private Integer collegeId;
	@JsonProperty
	private String collegeName;
	@JsonProperty
	private Integer totalSeats;
	@JsonProperty
	private Double courseFee;

}
