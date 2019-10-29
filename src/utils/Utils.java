package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import app.App;
import model.ClassroomBag;
import model.CourseBag;
import model.FacultyBag;
import model.PersonBag;
import model.StudentBag;
import model.TextbookBag;

public class Utils {

	public static void restore() {
		restoreTextbookBag();
		restoreClassroomBag();
		restoreStudentBag();
		restoreFacultyBag();
	}

	public static void backup() {
		backupTextbookBag(App.textBookBag);
		backupClassroomBag(App.classroomBag);
		backupStudentBag(App.studentBag);
		backupFacultyBag(App.facultyBag);
	}

	private static void backupFacultyBag(FacultyBag facultyBag) {
		try {
			FileOutputStream fos = new FileOutputStream("data/facultyBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(facultyBag);
			oos.close();
			facultyBag.display();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//RESTORES TEXTBOOK, BACKS BOTH TEXTBOOK AND FACULTY UP
	private static void backupStudentBag(StudentBag studentBag) {
		try {
			FileOutputStream fos = new FileOutputStream(new File("data/studentBag.dat"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(studentBag);
			oos.close();
			studentBag.display();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void backupTextbookBag(TextbookBag textbookBag) {
		try {
			FileOutputStream fos = new FileOutputStream("data/textbookBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(textbookBag);
			oos.close();
			textbookBag.display();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private static void backupClassroomBag(ClassroomBag classroomBag) {
		try {
			FileOutputStream fos = new FileOutputStream("data/classroomBag.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(classroomBag);
			oos.close();
			classroomBag.display();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	private static void restoreFacultyBag() {
		FileInputStream fis = null;
		File file = new File("data/facultyBag.dat");
		if (file.exists()) {
			try {
				fis = new FileInputStream("data/facultyBag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				App.facultyBag = (FacultyBag) (ois.readObject());
				App.facultyBag.display();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void restoreClassroomBag() {

		FileInputStream fis = null;
		File file = new File("data/classroomBag.dat");
		if (file.exists()) {
			try {
				fis = new FileInputStream("data/classroomBag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				App.classroomBag = null;
				App.classroomBag = (ClassroomBag) (ois.readObject());
				App.classroomBag.display();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void restoreStudentBag() {

		FileInputStream fis = null;
		File file = new File("data/studentBag.dat");
		if (file.exists()) {
			try {
				fis = new FileInputStream("data/studentBag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				App.studentBag = null;
				App.studentBag = (StudentBag) (ois.readObject());
				App.studentBag.display();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private static void restoreTextbookBag() {

		FileInputStream fis = null;
		File file = new File("data/textbookBag.dat");
		if (file.exists()) {
			try {
				fis = new FileInputStream("data/textbookBag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				App.textBookBag = null;
				App.textBookBag = (TextbookBag) (ois.readObject());
				App.textBookBag.display();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
}
