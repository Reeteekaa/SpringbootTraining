package com.trg.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.jpa.data.Employee;
import com.trg.jpa.exceptions.DuplicateDataException;
import com.trg.jpa.exceptions.MissingDataException;
import com.trg.jpa.repo.EmployeeRepository;

@Service("jpaBean")
public class EmployeeServicejpaImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repo;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getEmployee(int eid) {
		Optional<Employee> opt = repo.findById(eid); //optional: when we work with javastreams it appears more
		if (opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}
		else {
			return null;
		}
		
	}

	@Override
	public void saveEmployee1(Employee e) {
		if (repo.existsById(e.getEmpId())) { //check for save() as it works both for saving and updating
			throw new DuplicateDataException();
		}
		else {
			repo.save(e);
		}

	}

	@Override
	public void updateEmployee(Employee e) {
		if (repo.existsById(e.getEmpId())) { //check for save() as it works both for saving and updating
			repo.save(e);
		}
		else {			
			throw new MissingDataException();
		}
		
	}

	@Override
	public void deleteEmployee(int eid) {
		if(repo.existsById(eid)) {
			repo.deleteById(eid);
		}
		else {
			throw new MissingDataException();
		}
		
	}

}
