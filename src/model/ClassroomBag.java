package model;

import java.io.Serializable;
import java.util.Random;

public class ClassroomBag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5301906832643308667L;
	private  Classroom[] classroomArray;
	private   int nElems;

	private Random rand = new Random();

	public ClassroomBag(int maxSize) {
		classroomArray = new Classroom[maxSize];
		nElems = 0;
	}

	public  void insert(Classroom classroom) {
		classroomArray[nElems++] = classroom;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(classroomArray[i]);
		}
	}

	public Classroom emitclassRoom() {
		return classroomArray[rand.nextInt(nElems)];
	}



	public Classroom deleteByRoomNumber(int roomNumber) {
		int i = 0;
		for (i = 0; i < nElems; i++) {
			if (classroomArray[i].getRoomNumber() == (roomNumber)) {
				break;
			}
		}

		if (i == nElems) { // not exist
			return null;
		} else { // found
			Classroom classroom = classroomArray[i];
			for (int j = i; j < nElems - 1; j++) {
				classroomArray[j] = classroomArray[j + 1];
			}
			nElems--;
			return classroom;
		}
	}

	public Classroom findByRoomBuilding(int roomNumber) {
		for (int i = 0; i < nElems; i++) {
			if (classroomArray[i].getRoomNumber() == (roomNumber)) {
				return classroomArray[i];
			}
		}
		return null;
	}
}
