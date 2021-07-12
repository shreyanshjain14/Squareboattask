package com.squareboat.task.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.squareboat.task.model.Applieduser;



public interface ApplieduserJPA extends JpaRepository<Applieduser, Integer>{
	@Query("select u from Applieduser u") 
	 public List<Applieduser> getAll();
	@Query("select d from Applieduser d where d.job_ID=?1")
	public List<Applieduser> findByPatient_ID(int id);
}
