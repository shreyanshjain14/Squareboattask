package com.squareboat.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.squareboat.task.Repositories.EmployeeJPA;
import com.squareboat.task.Repositories.ApplieduserJPA;
import com.squareboat.task.Repositories.JobsJPA;
import com.squareboat.task.Repositories.UserJPA;
import com.squareboat.task.model.category;
import com.squareboat.task.model.Applieduser;
import com.squareboat.task.model.Jobs;
import com.squareboat.task.model.UsersLog;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class App_Controller 
{
	@Autowired
	EmployeeJPA empjpa;
	@Autowired
	JobsJPA patjpa;
	@Autowired
	UserJPA ujpa;
    @Autowired
    ApplieduserJPA pdjpa;

	 
	@GetMapping("")
	public List<Jobs> getPatients()
	{
		List<Jobs> pat2=patjpa.findAll();
		return pat2;
	}
	
	@DeleteMapping("/pat/{id}")
    public Jobs delete(@PathVariable int id)
    {
		Jobs deletedpat=null;
		List<Jobs> pat=patjpa.findAll();
		for(Jobs patient : pat)
		{
			if (patient.getJob_ID()==id) 
			{
				patjpa.deleteById(id);
				pat.remove(patient);
				deletedpat=patient;
				break;
			}
		}
		return deletedpat;
    }
	@PostMapping("/add")
	public Jobs create(@RequestBody Jobs user) {
		patjpa.save(user);
		System.out.println();
		return user;
	}
	@PostMapping("/genuser")
	public UsersLog createUser(@RequestBody UsersLog users)
	{
		ujpa.save(users);
		System.out.println();
		return users;
	}
	@GetMapping("/getdoc")
	public List<category> listDoc()
	{
		List<category> empname=empjpa.getname();
		return empname;
	}

	@GetMapping("/applieduser")
	public List<Applieduser> listDiagnosis()
	{
		List<Applieduser> d =pdjpa.getAll();
		return d;
	}
	@PostMapping("/diagsave")
	public Applieduser createDiag(@RequestBody Applieduser diag)
	{
		pdjpa.save(diag);
		System.out.println();
		return diag;
	}
	@GetMapping("/chosen/{id}")
	public List<Applieduser> chosenP(@PathVariable int id)
	{
		List<Applieduser> di=pdjpa.findByPatient_ID(id);
		return di;
	}
}
