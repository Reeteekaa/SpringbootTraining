package com.trg.jpa.data;

import java.time.LocalDate;

import javax.persistence.*;


//import javax.xml.bind.annotation.XmlRootElement;
//@XmlRootElement

@Entity
@Table(name = "EMPTBL") //not required if the table name is EMPLOYEE
public class Employee {
	@Id
	@Column(name = "EMPID")
	private int empId;
	@Column(length=15) //by default length is 255
	private String name;
	private int salary;
	
	@Column(name="DOB")
	private LocalDate dob;
	
	public Employee(int empId, String name, int salary, LocalDate dob) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.dob = dob;
	}
	public Employee() {
		super();
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	

}
