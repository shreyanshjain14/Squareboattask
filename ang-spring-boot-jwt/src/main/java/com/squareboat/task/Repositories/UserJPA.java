package com.squareboat.task.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squareboat.task.model.UsersLog;



public interface UserJPA extends JpaRepository<UsersLog, Integer>
{


	UsersLog findByUsername(String username);
//	@Query(value="SELECT user.role FROM user where user.username=?1")
//	public String Role(String username);
}
