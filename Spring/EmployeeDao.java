package com.au2018.EmployeeDataForum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class EmployeeDao {  
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	public int addEmployee(Employee e){  
	    String query="insert into employees values('"+e.getEid()+"','"+e.getName()+"','"+e.getSalary()+"')";  
	    return jdbcTemplate.update(query);  
	}  
	public int updateEmployee(Employee e){  
	    String query="update employees set ename='"+e.getName()+"',eage='"+e.getSalary()+"' where eid='"+e.getEid()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	public int deleteEmployee(Employee e){  
	    String query="delete from employees where eid='"+e.getEid()+"' ";  
	    return jdbcTemplate.update(query);  
	}  
	  
	public List<Employee> getAllEmployeesRowMapper(){
		 return jdbcTemplate.query("select * from employees",new RowMapper<Employee>(){  
			 public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Employee e=new Employee();  
		        e.setEid(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        e.setSalary(rs.getInt(3));  
		        return e;  
		    }  
		    });  
		}
	public Employee getEmpById(int id){
		return jdbcTemplate.query("select * from employees where eid="+id,new RowMapper<Employee>(){  
		    
			 public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Employee e=new Employee();  
		        e.setEid(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        e.setSalary(rs.getInt(3));  
		        return e;  
		    }  
		    }).get(0);
	
	}
	
	public void insertList(final List<Employee> emps){
		String sql = "INSERT INTO employees VALUES (?, ?, ?)";

		List<Object[]> parameters = new ArrayList<Object[]>();

		for (Employee emp : emps) {
	        parameters.add(new Object[] {emp.getEid(),
	            emp.getName(), emp.getSalary()}
	        );
	    }
	    jdbcTemplate.batchUpdate(sql, parameters);
	}
	public Employee get5thEmployeebyAge() {
		return jdbcTemplate.query("select * from employees order by salary",new RowMapper<Employee>(){  
			 public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Employee e=new Employee();  
		        e.setEid(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        e.setSalary(rs.getInt(3));  
		        return e;  
		    }  
		    }).get(4);  
		}
	
}  