package model;

import java.io.Serializable;

public class Faculty extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7029837459908173477L;
	private Title title;
	private double salary;
	private Major department;
	private String officePhone;
	private MiniFacultyCourseBag miniFacultyCourseBag;

	public Faculty(String firstName, String lastName, String id, Title title, double salary, Major department,
			String officePhone, MiniFacultyCourseBag miniFacultyCourseBag) {
		super(lastName, lastName, id);
		this.title = title;
		this.salary = salary;
		this.department = department;
		this.officePhone = officePhone;
		this.miniFacultyCourseBag = miniFacultyCourseBag;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Major getDepartment() {
		return department;
	}

	public void setDepartment(Major department) {
		this.department = department;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Override
	public String toString() {
		return "Faculty [name = " + firstName + " " + lastName + " " +"id = " + id + ", title=" + title + ", salary=" + salary
				+ ", department=" + department + ", officePhone=" + officePhone + ", " + miniFacultyCourseBag + "]";
	}

}
