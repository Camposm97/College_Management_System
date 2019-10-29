package model;

import java.io.Serializable;

public class MiniFacultyCourseInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6367870570525438740L;
	private String courseNumber;
	private String courseTitle;
	private String numberOfCredits;
	private CourseStatus courseStatus;

	public MiniFacultyCourseInfo(String courseNumber, String courseTitle, String numberOfCredits,
			CourseStatus courseStatus) {
		super();
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.numberOfCredits = numberOfCredits;
		this.courseStatus = courseStatus;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(String numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public CourseStatus getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(CourseStatus courseStatus) {
		this.courseStatus = courseStatus;
	}

	@Override
	public String toString() {
		return "MiniFacultyCourseInfo [courseNumber=" + courseNumber + ", courseTitle=" + courseTitle
				+ ", numberOfCredits=" + numberOfCredits + ", courseStatus=" + courseStatus + "]";
	}

}
