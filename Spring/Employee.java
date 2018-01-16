package com.au2018.EmployeeDataForum;

public class Employee {
	private int eid;
	private String Name;
	private int Salary;
	
	public Employee(int i, String string, int sal) {
		this.eid=i;
		this.Name=string;
		this.Salary = sal;
	}
	public Employee() {}
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int sal) {
		this.Salary = sal;
	}
}
