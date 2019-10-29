package model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

public class MiniFacultyCourseBag implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1774192136095305582L;
	private MiniFacultyCourseInfo[] infoArray;
	private int nElems;

	private Random rand = new Random();

	public MiniFacultyCourseBag(int maxSize) {
		infoArray = new MiniFacultyCourseInfo[maxSize];
		nElems = 0;
	}

	public void insert(MiniFacultyCourseInfo info) {
		infoArray[nElems++] = info;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(infoArray[i]);
		}
	}

	public MiniFacultyCourseInfo emitCourse() {
		return infoArray[rand.nextInt(nElems)];
	}

	@Override
	public String toString() {
		return "MiniFacultyCourseBag [" + Arrays.toString(infoArray);
	}

}
