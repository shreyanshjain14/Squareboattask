package com.squareboat.task.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.squareboat.task.model.Jobs;

public interface JobsJPA extends JpaRepository<Jobs, Integer> 
{
	@Query("SELECT u FROM jobs u WHERE u.job_ID = ?1")
	public Jobs findById(int id);

}
