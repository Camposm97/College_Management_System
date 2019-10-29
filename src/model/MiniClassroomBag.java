package model;

import java.io.Serializable;
import java.util.Random;

public class MiniClassroomBag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2561495882217820896L;
	private static Classroom[] classroomrray;
	private static int nElems;
	
	private Random rand = new Random();
	
	public MiniClassroomBag(int maxSize) {
		classroomrray = new Classroom[maxSize];
		nElems = 0;
	}
	
	public static void insert(Classroom classroom) {
		classroomrray[nElems++] = classroom;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(classroomrray[i]);
		}
	}
	
	public Classroom emitclassRoom() {
		return classroomrray[rand.nextInt(nElems)];
	}
}
