package model;

import java.io.Serializable;

public class MiniStudentInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2799328395684944404L;
	private String courseNumber;
	private String numberOfCredits;
	private Lettergrade letterGrade;
	private CourseStatus courseStatus;

	public MiniStudentInfo(String courseNumber, String numberOfCredits, Lettergrade letterGrade,
			CourseStatus courseStatus) {
		super();
		this.courseNumber = courseNumber;
		this.numberOfCredits = numberOfCredits;
		this.letterGrade = letterGrade;
		this.courseStatus = courseStatus;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getNumberOfCredits() {
		return numberOfCredits;
	}
	public void setNumberOfCredits(String numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	public Lettergrade getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(Lettergrade letterGrade) {
		this.letterGrade = letterGrade;
	}
	public CourseStatus getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}
	@Override
	public String toString() {
		return "MiniStudentInfo [courseNumber=" + courseNumber + ", numberOfCredits=" + numberOfCredits
				+ ", letterGrade=" + letterGrade + ", courseStatus=" + courseStatus + "]";
	}
	
	
}
