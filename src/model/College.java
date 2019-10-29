package model;

public class College {
	private PersonBag personBag;
	private TextbookBag textbookBag;
	private CourseBag courseBag;
	private ClassroomBag classroomBag;
	
	public College(int maxPersonBag, int maxTextbookBag, int maxCourseBag, int maxClassroomBag) {
		personBag = new PersonBag(maxPersonBag);
		textbookBag = new TextbookBag(maxTextbookBag);
		courseBag = new CourseBag(maxCourseBag);
		classroomBag = new ClassroomBag(maxClassroomBag);
	}

	public PersonBag getPersonBag() {
		return personBag;
	}

	public void setPersonBag(PersonBag personBag) {
		this.personBag = personBag;
	}

	public TextbookBag getTextbookBag() {
		return textbookBag;
	}

	public void setTextbookBag(TextbookBag textbookBag) {
		this.textbookBag = textbookBag;
	}

	public CourseBag getCourseBag() {
		return courseBag;
	}

	public void setCourseBag(CourseBag courseBag) {
		this.courseBag = courseBag;
	}

	public ClassroomBag getClassroomBag() {
		return classroomBag;
	}

	public void setClassroomBag(ClassroomBag classroomBag) {
		this.classroomBag = classroomBag;
	}
	
}
