package model;

import java.io.Serializable;
import java.util.Random;

public class CourseBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -797424168538709628L;
	private static Course[] courseArray;
	private static int nElems;
	
	private Random rand = new Random();
	
	public CourseBag(int maxSize) {
		courseArray = new Course[maxSize];
		nElems = 0;
	}
	
	public void insert(Course course) {
		courseArray[nElems++] = course;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(courseArray[i]);
		}
	}
	
	public Course emitCourse() {
		return courseArray[(int) (Math.random() * nElems)];
	}
	
	public  Course deleteByCourseNumber(String courseNumber) {
		int i = 0;
		for (i = 0; i < nElems; i++) {
			if (courseArray[i].getCourseNumber().equals(courseNumber)) {
				break;
			}
		}

		if (i == nElems) { // not exist
			return null;
		} else { // found
			Course course = courseArray[i];
			for (int j = i; j < nElems - 1; j++) {
				courseArray[j] = courseArray[j + 1];
			}
			nElems--;
			return course;
		}
	}

	public Course findByCourseNumber(String courseNumber) {
		for (int i = 0; i < nElems; i++) {
			if (courseArray[i].getCourseNumber().equals(courseNumber)) {
				return courseArray[i];
			}
		}
		return null;
	}

	
	
}
