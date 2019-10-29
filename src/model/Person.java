package model;

import java.io.Serializable;

public abstract class Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1833713997261143394L;
	protected String firstName;
	protected String lastName;
	protected String id;

	private static int idCounter = 1;

	
	
	public Person(String firstName, String lastName,String id) {
		this.firstName = firstName;
		this.lastName = lastName;
		String rawId = String.valueOf(idCounter++);
		this.id = rawId;
	}
//
//	public String convertID(String rawId) {
//		String id = rawId;
//		int originalLength = rawId.length();
//
//		for (int i = originalLength; i < 8; i++) {
//			id = "0" + id;
//
//		}
//		return id;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

}
