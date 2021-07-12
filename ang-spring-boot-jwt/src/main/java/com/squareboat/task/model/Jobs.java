package com.squareboat.task.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.squareboat.task.Repositories.JobsJPA;

@Entity(name = "jobs")
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int job_ID;
	
	@Column(name = "skills"  ,length = 50, nullable = false)
	private String skills;
	
	@Column(name = "designation"  ,length = 50, nullable = false)
	private String designation;
	
	@Column(name = "location"  ,length = 50, nullable = false)
	private String loaction;
	
	@Column(name = "CTC"  ,length = 50)
	private String ctc;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="Jobs")
    private Applieduser pd;
	
	@Column
	private String cat;
	
	

	

	public int getJob_ID() {
		return job_ID;
	}


	public void setJob_ID(int job_ID) {
		this.job_ID = job_ID;
	}


	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}



	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLoaction() {
		return loaction;
	}

	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	

	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public Jobs() {
		super();
	}
	
	
}
