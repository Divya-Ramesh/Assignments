package com.AU.Assignment;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.AU.Assignment.*;

public class Main {
	public static void main(String args[]){
		List<Expenses> el = new ArrayList<Expenses>();
		
		Laptop l = new Laptop();
		l.setLid(1);
		l.setBrand("Dell");
		l.setPrice(25000);
		
		Employee e = new Employee();
		e.setEid(1);
		e.setName("A");
		e.setSalary(20000);
		
		e.setLaptop(l);
		l.setEmployee(e);
		
		Expenses ex = new Expenses();
		ex.setId(1);
		ex.setType("Travel");
		ex.setExpense(2000);
		el.add(ex);
		Expenses ex1 = new Expenses();
		ex1.setId(2);
		ex1.setType("Food");
		ex1.setExpense(2000);
		el.add(ex1);
		e.setExpenses(el);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Laptop.class).addAnnotatedClass(Expenses.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.save(l);
		session.save(e);
		session.save(ex);
		session.save(ex1);
		
		tx.commit();
		
		Employee employee = session.get(Employee.class, 1);
		
		System.out.println("\nDetails of employee with id = 1");
		
		System.out.print("The expenses are ");
		for (Expenses e1: employee.getExpenses()) {
			System.out.print(e1.getType()+" , ");
		}
		
		System.out.print("\nThe laptop owned is ");
		System.out.println(employee.getLaptop().getBrand());
	}
}
