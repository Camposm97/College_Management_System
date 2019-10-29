package model;

import java.io.Serializable;

public class StudentBag implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8708025719197565538L;
	private Student[] studentArray;
	private int nElems;
	
	public StudentBag() {};

	public StudentBag(int maxSize) {
		studentArray = new Student[maxSize];
		nElems = 0;
	}

	public  void insert(Student student) {
		studentArray[nElems++] = student;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(studentArray[i]);
		}
	}

	public Student deleteByID(String id) {
		int i = 0;
		for (i = 0; i < nElems; i++) {
			if (studentArray[i].getId().equals(id)) {
				break;
			}
		}

		if (i == nElems) { // not exist
			return null;
		} else { // found
			Student student = studentArray[i];
			for (int j = i; j < nElems - 1; j++) {
				studentArray[j] = studentArray[j + 1];
			}
			nElems--;
			return student;
		}
	}

	public Student findById(String id) {
		for (int i = 0; i < nElems; i++) {
			if (studentArray[i].getId().equals(id)) {
				return studentArray[i];
			}
		}
		return null;
	}

}
