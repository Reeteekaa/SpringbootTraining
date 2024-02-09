package com.trg.jpa.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trg.jpa.data.Employee;
import com.trg.jpa.exceptions.DuplicateDataException;
import com.trg.jpa.exceptions.MissingDataException;
import com.trg.jpa.repo.EmployeeRepository;

@Service("mapBean")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;
	
	Map<Integer,Employee> data = new TreeMap<>();

	public EmployeeServiceImpl () {
		super();
		data.put(100, new Employee(100, "Suresh", 22000, LocalDate.of(1998, 12, 3)));
		data.put(200, new Employee(200, "Aarohi", 10000, LocalDate.of(1988, 2, 14)));
		data.put(300, new Employee(300, "Raagini", 42000, LocalDate.of(2015, 9, 24)));
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<>();
		Collection<Employee> col = data.values();
		list.addAll(col);
		return list;
	}
	
	
	@Override
	public Employee getEmployee(int eid) {
		Employee x = data.get(eid);
		return x;
	}

	@Override
	
	public void saveEmployee1(Employee e) {
		repo.save(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		
		if (data.containsKey(e.getEmpId())) {
			data.put(e.getEmpId(), e);
		}
		else {
			
			throw new MissingDataException();
		}
	}

	@Override
	public void deleteEmployee(int eid) {
		if (data.containsKey(eid)) {
			data.remove(eid);
		}
		else {
			throw new MissingDataException();
		}
	}



}
