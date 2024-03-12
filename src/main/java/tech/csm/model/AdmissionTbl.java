package tech.csm.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AdmissionTbl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty
	private Integer enrollementId;
	@JsonProperty
	private String applicantName;
	@JsonProperty
	private String fourthOption;
	@JsonProperty
	private Date enrollmentDate;
	@JsonProperty
	private CollegeMaster college;

}
