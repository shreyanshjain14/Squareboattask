package com.squareboat.task.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Applieduser")
public class Applieduser {
	
	
    
	@Id
	private int job_ID;
	
	@OneToOne
    @JoinColumn(name = "job_ID", nullable = false)
    private Jobs Jobs;
	
	@Column(nullable = false)
	private String username;
	
	@Column
	private String email;





	public int getJob_ID() {
		return job_ID;
	}





	public void setJob_ID(int job_ID) {
		this.job_ID = job_ID;
	}





	public Jobs getJobs() {
		return Jobs;
	}





	public void setJobs(Jobs jobs) {
		Jobs = jobs;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public Applieduser() {
		super();
	}
	
	
}
