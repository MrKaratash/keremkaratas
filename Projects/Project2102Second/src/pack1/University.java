package pack1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class University {

	ArrayList<Department> departments = new ArrayList<Department>();
	
	
	int deptID;
	
	
	public Integer getDeptID() {
		return deptID;
	}

	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}

	public String getString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public int getInt(String message) {
		return Integer.parseInt( JOptionPane.showInputDialog(message) );
	}
	
	public void newDepartment() {
		
		deptID = getInt("Department ID");
		
		/*if( departments.stream().filter(d->d.deptId==deptId).findFirst().isEmpty() ) {
			Department dept = new Department();
			dept.deptId = getInt("Department ID");
			dept.title = getString("Department title");
			this.departments.add(dept);
			JOptionPane.showMessageDialog(null, "Department saved!");
		}
		else {
			JOptionPane.showMessageDialog(null, "Department is present");
		}*/
		
		while(departments.stream().filter(d->d.deptId==deptID).findFirst().isPresent()) {
			
			deptID = getInt("This department ID is present,\nEnter a valid department ID");
		}
		Department dept = new Department();
		dept.deptId = deptID;
		dept.title = getString("Department title");
		this.departments.add(dept);
		JOptionPane.showMessageDialog(null, "Department saved!");
	}
	
	public void newCourse(int deptId) {
		
	}
	
	public void newStudent(int deptId) {
		Student stu = new Student(getInt("Student ID"),
								  getString("Name"),
								  getString("Surname"));
		for (Department d : departments) {
			if(d.deptId==deptId) {
				d.students.add(stu);
				//d.addStudent(stu);
			}
		}
		JOptionPane.showMessageDialog(null, "Student saved");
	}
	
	public void getDepartments() {
		
	}
	
	public void getDepartment(int deptId) {
		
		if(departments.stream().filter(d->d.deptId==deptId).findFirst().isPresent()) {
			Department de = departments.stream().filter(d->d.deptId==deptId).findFirst().get();
			JOptionPane.showMessageDialog(null, de.deptId+" "+de.title);
		}
		else {
			JOptionPane.showMessageDialog(null, "There is no department with this ID");
		}
	}
	
	public void getStudents() {
		
	}
	
	public void getStudents(int deptId) {
		
	}
	
	public static void main(String[] args) {
		
		University univ = new University();
		Department d = new Department();
		d.deptId= 1;
		d.title="sdf";
		
		univ.departments.add(d);
		univ.newDepartment();
		univ.getDepartment(2);
		
	}

}
