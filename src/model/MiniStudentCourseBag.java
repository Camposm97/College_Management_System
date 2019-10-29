package model;

import java.io.Serializable;
import java.util.Random;

public class MiniStudentCourseBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1147546351745344737L;
	private MiniStudentInfo[] courseArray;
	private int nElems;
	
	private Random rand = new Random();
	
	public MiniStudentCourseBag(int maxSize) {
		courseArray = new MiniStudentInfo[maxSize];
		nElems = 0;
	}
	
	public void insert(MiniStudentInfo course) {
		courseArray[nElems++] = course;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(courseArray[i]);
		}
	}
	
	public MiniStudentInfo emitCourse() {
		return courseArray[rand.nextInt(nElems)];
	}
	
}
