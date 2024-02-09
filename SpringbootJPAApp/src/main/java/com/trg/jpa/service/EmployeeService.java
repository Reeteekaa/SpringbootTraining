package com.trg.jpa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.trg.jpa.data.Employee;
import com.trg.jpa.exceptions.DuplicateDataException;

@Service
public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	Employee getEmployee(int eid);
	void saveEmployee1(Employee e) throws DuplicateDataException;
	void updateEmployee(Employee e);
	void deleteEmployee(int eid);
}
