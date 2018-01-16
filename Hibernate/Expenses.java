package com.AU.Assignment;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expenses {
	@Id
	private int id;
	private String type;
	private int expense;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
}
