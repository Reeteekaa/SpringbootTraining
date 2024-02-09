package com.trg.jpa;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trg.jpa.data.Employee;
import com.trg.jpa.repo.EmployeeRepository;

@Component
public class Dbinit implements CommandLineRunner {

	@Autowired
	EmployeeRepository repo;
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Employee(100, "Suresh", 22000, LocalDate.of(1998, 12, 3)));
		repo.save(new Employee(200, "Aarohi", 10000, LocalDate.of(1988, 2, 14)));
		repo.save(new Employee(300, "Raagini", 42000, LocalDate.of(2015, 9, 24)));
		
		System.out.println("3 Rows added to EMPTBL");
	}
		
}


