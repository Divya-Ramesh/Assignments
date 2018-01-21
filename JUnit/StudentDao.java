package dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Student;

public class StudentDAO {

	private  Map<Integer,Student> studentList;
	static {
		
	}
	@SuppressWarnings("deprecation")
	public StudentDAO() {
		// TODO Auto-generated constructor stub
		studentList=new HashMap<Integer,Student>();
		studentList.put(1,new Student(1, "Divya", "Ramesh", "Bangalore", new Date(1997, 01, 13), 9178191760, 6, "cs"));
		studentList.put(2,new Student(2, "Anusha", "BS", "Sirsi", new Date(1996, 05, 03), 910723876, 5, "cs"));
		
	}

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentList.get(student.getRollNo())!=null)
		return null;
		studentList.put(student.getRollNo(), student);
		return studentList.get(student.getRollNo());
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		if(studentList.get(student.getRollNo())==null)
			return null;
		studentList.put(student.getRollNo(), student);	
		
		return studentList.get(student.getRollNo());

	}

	public Student getStudent(int rollNo) {
		// TODO Auto-generated method stub
		if(studentList.get(rollNo)==null)
			return null;
			
		
		return studentList.get(rollNo);
	}

	

	public Student deleteStudent(int rollNo) {
		// TODO Auto-generated method stub
		if(studentList.get(rollNo)==null)
			return null;
		Student stud=studentList.remove(rollNo);
		return stud;
	}

}