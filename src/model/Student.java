package model;

import java.io.Serializable;

public class Student extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6486651366084321184L;
	
	private Major major;
	private double gpa;
	private MiniStudentCourseBag miniStudentCourseBag;

	
	public Student(String firstName, String lastName, String id, Major major,double gpa) {
		super(firstName, lastName,id);
		this.major = major;
		this.gpa = gpa;
	}
	
	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public MiniStudentCourseBag getMiniStudentCourseBag() {
		return miniStudentCourseBag;
	}

	public void setMiniStudentCourseBag(MiniStudentCourseBag miniStudentCourseBag) {
		this.miniStudentCourseBag = miniStudentCourseBag;
	}

	@Override
	public String toString() {
		return "Student [name=" + firstName + " " + lastName + ", ID  " + id +", major=" + major + ", gpa=" + gpa + ", miniStudentCourseBag=" + miniStudentCourseBag + "]";
	}
	
}
