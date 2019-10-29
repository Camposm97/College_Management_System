package model;

import java.io.Serializable;
import java.util.Random;

public class PersonBag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5570895726004622178L;
	private Person[] personArray;
	private int nElems;
	
	private Random rand = new Random();
	
	public PersonBag(int maxSize) {
		personArray = new Person[maxSize];
		nElems = 0;
	}
	
	public void insert(Person person) {
		personArray[nElems++] = person;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(personArray[i]);
		}
	}
	
	public Person emitPerson() {
		return personArray[rand.nextInt(nElems)];
	}
	
	
}
