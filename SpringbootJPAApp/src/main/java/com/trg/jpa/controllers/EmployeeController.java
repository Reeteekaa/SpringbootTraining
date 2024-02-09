package com.trg.jpa.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trg.jpa.data.Employee;
import com.trg.jpa.data.ResponseMessage;
import com.trg.jpa.exceptions.DuplicateDataException;
import com.trg.jpa.exceptions.MissingDataException;
import com.trg.jpa.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("jpaBean")
	EmployeeService service;
	
	@RequestMapping(path = "{eid}",method = RequestMethod.GET/*, produces = MediaType.APPLICATION_XML_VALUE*/)
	@GetMapping("{eid}")
	//public Employee getEmployee(@PathVariable("eid") int empId) {
	public ResponseEntity<?> getEmployee(@PathVariable("eid") int empId) {
		Employee e = service.getEmployee(empId);
		if(e!=null) {
			//return e;
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
		}
		else {
			//return "Employee with id : " +empId + "not found";
			ResponseMessage rm = new ResponseMessage("Employee with id : " + empId + " not found.", LocalDateTime.now());
			return new ResponseEntity<ResponseMessage>(rm, HttpStatus.NOT_FOUND);
		}
		//return e;
		
	}
	
	//@RequestMapping()
	@GetMapping
	public List<Employee> getAll(){
		return service.getAllEmployees();
		
	}
	
	//@RequestMapping(path="/", method = RequestMethod.POST)
	@PostMapping //here controller do not need to bother about the exceptions
	public ResponseEntity<ResponseMessage> saveEmployee(@RequestBody Employee e) {		
			service.saveEmployee1(e);
			ResponseMessage rm = new ResponseMessage("Employee with id : " + e.getEmpId()+ " saved successfully.", LocalDateTime.now());
			return new ResponseEntity<ResponseMessage>(rm, HttpStatus.OK);
		
		
	}
	
	@PutMapping
	public ResponseEntity<ResponseMessage> updateEmployee(@RequestBody Employee e) {
		
			service.updateEmployee(e);
			ResponseMessage rm = new ResponseMessage("Employee with id : " + e.getEmpId() + " updated successfully.", LocalDateTime.now());
			return new ResponseEntity<ResponseMessage>(rm, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("{eid}")
	public ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable int eid) {
		
			service.deleteEmployee(eid);
			ResponseMessage rm = new ResponseMessage("Employee with id : " + eid + " deleted successfully.", LocalDateTime.now());
			return new ResponseEntity<ResponseMessage>(rm, HttpStatus.ACCEPTED);
			
	}

	
}
