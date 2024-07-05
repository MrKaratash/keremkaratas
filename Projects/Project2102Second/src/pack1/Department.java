package pack1;

import java.util.ArrayList;

public class Department {

	int deptId;
	String title;
	
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Course> courses = new ArrayList<Course>();
	
	public void addStudent(Student stu) {
		this.students.add(stu);
	}
	
	public void addCourse(Course cou) {
		this.courses.add(cou);
	}

	
	
	
}
