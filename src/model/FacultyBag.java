package model;

import java.io.Serializable;
import java.util.Random;

public class FacultyBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7050161789940882643L;
	private static Faculty[] facultyArray;
	private static int nElems;
	
	private Random rand = new Random();
	
	public FacultyBag(int maxSize) {
		facultyArray = new Faculty[maxSize];
		nElems = 0;
	}
	
	public void insert(Faculty faculty) {
		facultyArray[nElems++] = faculty;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(facultyArray[i]);
		}
	}
	
	public Faculty emitFaculty() {
		return facultyArray[(int) (Math.random() * nElems)];
	}
	
	public  Faculty deleteByID(String id) {
		int i = 0;
		for (i = 0; i < nElems; i++) {
			if (facultyArray[i].getId().equals(id)) {
				break;
			}
		}

		if (i == nElems) { // not exist
			return null;
		} else { // found
			Faculty faculty = facultyArray[i];
			for (int j = i; j < nElems - 1; j++) {
				facultyArray[j] = facultyArray[j + 1];
			}
			nElems--;
			return faculty;
		}
	}

	public Faculty findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (facultyArray[i].getId().equals(id)) {
				return facultyArray[i];
			}
		}
		return null;
	}
	

}
