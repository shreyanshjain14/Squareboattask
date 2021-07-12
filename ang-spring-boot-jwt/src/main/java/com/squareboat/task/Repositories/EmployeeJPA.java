package com.squareboat.task.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.squareboat.task.model.category;


public interface EmployeeJPA extends JpaRepository<category, Integer>
{
	
//	 
	@Query("select name from  category") 
	 public List<category> getname();

}
