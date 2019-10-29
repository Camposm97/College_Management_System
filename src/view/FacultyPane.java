package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.CourseStatus;
import model.Faculty;
import model.FacultyBag;
import model.Major;
import model.MiniFacultyCourseBag;
import model.MiniFacultyCourseInfo;
import model.Title;

public class FacultyPane extends GridPane {
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField idField;
	private TextField titleField;
	private TextField salaryField;
	private TextField departmentField;
	private TextField officePhoneField;
	private TextField courseNumberField;
	private TextField courseTitleField;
	private TextField numberOfCreditsField;
	private TextField courseStatusField;
	private VBox vbox1;
	private Button insertButton;
	private Button removeButton;
	private Button findButton;
	private Button updateButton;
	private FacultyBag facultyBag;
	private ComboBox<Title> titleBox;
	private ComboBox<CourseStatus> statusBox;
	private ComboBox<Major> majorBox;
	private Faculty faculty;
	private MiniFacultyCourseInfo miniFacultyCourseInfo;

	public void makeButtons() {
		insertButton = new Button("Insert");
		removeButton = new Button("Remove");
		updateButton = new Button("Update");
		findButton = new Button("Find");

		insertButton.setPrefSize(75, 25);
		removeButton.setPrefSize(75, 25);
		updateButton.setPrefSize(75, 25);
		findButton.setPrefSize(75, 25);
	}

	public void makeTextFields() {
		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		idField = new TextField();
		idField.setPromptText("ID");
		titleField = new TextField();
		titleField.setPromptText("Title");
		salaryField = new TextField();
		salaryField.setPromptText("Salary");
		departmentField = new TextField();
		departmentField.setPromptText("Department");
		officePhoneField = new TextField();
		officePhoneField.setPromptText("Phone Number");
		courseNumberField = new TextField();
		courseNumberField.setPromptText("Course Number");
		courseTitleField = new TextField();
		courseTitleField.setPromptText("Course Title");
		numberOfCreditsField = new TextField();
		numberOfCreditsField.setPromptText("Number of Credits");
		courseStatusField = new TextField();
		courseStatusField.setPromptText("CTT,CTT,CT");
	}

	public void setUpButtonListeners() {

		updateButton.setOnAction(e -> {

			String id = this.idField.getText();
			faculty = this.facultyBag.findById(id);
			if (id == (null)) {
				Alert alert = new Alert(AlertType.WARNING, "Please Enter an ID");
				alert.showAndWait();
			} else if (firstNameField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a FirstName");
				alert.showAndWait();
			} else if (lastNameField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a LastName");
				alert.showAndWait();
			} else if (titleBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Title");
				alert.showAndWait();
			} else if (salaryField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Salary");
				alert.showAndWait();
			} else if (majorBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Major");
				alert.showAndWait();
			} else if (officePhoneField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Phone Number");
				alert.showAndWait();
			} else if (courseNumberField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Course Number");
				alert.showAndWait();
			} else if (courseTitleField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Course Title");
				alert.showAndWait();
			} else if (numberOfCreditsField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter Number Of Credits");
				alert.showAndWait();
			} else if (statusBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a Course Status");
				alert.showAndWait();
			} else if (faculty != null) {
				
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				Title title = titleBox.getValue();
				double salary = Double.parseDouble(salaryField.getText());
				Major department = majorBox.getValue();
				String phoneNumber = officePhoneField.getText();

				String courseNumber = courseNumberField.getText();
				String courseTitle = courseTitleField.getText();
				String numberOfCredits = numberOfCreditsField.getText();
				CourseStatus courseStatus = statusBox.getValue();
				miniFacultyCourseInfo = new MiniFacultyCourseInfo(courseNumber, courseTitle, numberOfCredits,
						courseStatus);

				faculty.setFirstName(firstName);
				faculty.setLastName(lastName);
				faculty.setTitle(title);
				faculty.setSalary(salary);
				faculty.setDepartment(department);
				faculty.setOfficePhone(phoneNumber);

				miniFacultyCourseInfo.setCourseNumber(courseNumber);
				miniFacultyCourseInfo.setCourseTitle(courseTitle);
				miniFacultyCourseInfo.setNumberOfCredits(numberOfCredits);
				miniFacultyCourseInfo.setCourseStatus(courseStatus);
				System.out.println("Faculty Changed and Added");

				this.firstNameField.setText("");
				this.lastNameField.setText("");
				this.titleBox.getSelectionModel().clearSelection();
				this.salaryField.setText("");
				this.majorBox.getSelectionModel().clearSelection();
				this.officePhoneField.setText("");
				this.courseNumberField.setText("");
				this.courseTitleField.setText("");
				this.numberOfCreditsField.setText("");
				this.statusBox.getSelectionModel().clearSelection();

			} else {
				System.out.println("Faculty doesnt exist");
			}

		});

		insertButton.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			String id = idField.getText();
			Title title = titleBox.getValue();
			double salary = Double.parseDouble(salaryField.getText());
			Major department = majorBox.getValue();
			String phoneNumber = officePhoneField.getText();

			String courseNumber = this.courseNumberField.getText();
			String courseTitle = this.courseTitleField.getText();
			String numberOfCredits = this.numberOfCreditsField.getText();
			CourseStatus courseStatus = statusBox.getValue();
			miniFacultyCourseInfo = new MiniFacultyCourseInfo(courseNumber, courseTitle, numberOfCredits, courseStatus);
			MiniFacultyCourseBag facBag = new MiniFacultyCourseBag(1);
			facBag.insert(miniFacultyCourseInfo);
			faculty = new Faculty(firstName, lastName, id, title, salary, department, phoneNumber, facBag);
			App.facultyBag.insert(faculty);
			System.out.println(faculty + " Added");

			firstNameField.setText("");
			lastNameField.setText("");
			salaryField.setText("");
			officePhoneField.setText("");
			courseNumberField.setText("");
			courseTitleField.setText("");
			numberOfCreditsField.setText("");
			
		});

		removeButton.setOnAction(e -> {
			String id = this.idField.getText();
			facultyBag.deleteByID(id);

			if (faculty != null) {
				System.out.println(faculty + " removed");
				firstNameField.setText("");
				lastNameField.setText("");
				idField.setText("");
				titleBox.getSelectionModel().clearSelection();
				salaryField.setText("");
				majorBox.getSelectionModel().clearSelection();
				officePhoneField.setText("");
				courseNumberField.setText("");
				courseTitleField.setText("");
				numberOfCreditsField.setText("");
				statusBox.getSelectionModel().clearSelection();
				System.out.println(faculty + " Removed");
			} else {
				System.out.println("Doesnt exist");
			}

		});

		findButton.setOnAction(e -> {
			String id = idField.getText();
			faculty = facultyBag.findById(id);

			if (faculty != null) {
				firstNameField.setText(facultyBag.findById(id).getFirstName());
				lastNameField.setText(facultyBag.findById(id).getLastName());
				idField.setText(facultyBag.findById(id).getId());
				titleField.setText(String.valueOf(facultyBag.findById(id).getTitle()));
				salaryField.setText(String.valueOf(facultyBag.findById(id).getSalary()));
				departmentField.setText(String.valueOf(facultyBag.findById(id).getDepartment()));
				officePhoneField.setText(facultyBag.findById(id).getOfficePhone());
				System.out.println(faculty + " Found");
			} else {
				System.out.println("Doesnt exist");
			}
		});

	}

	public FacultyPane() {
		super();
		titleBox = new ComboBox<>();
		statusBox = new ComboBox<>();
		majorBox = new ComboBox<>();

		facultyBag = App.facultyBag;
		this.setVgap(10);
		this.setHgap(50);
		this.setPadding(new Insets(30));

		Title[] title = Title.values();

		ObservableList<Title> titleList = FXCollections.observableArrayList(title);
		titleBox = new ComboBox<>();
		titleBox.setItems(titleList);

		CourseStatus[] courseStatus = CourseStatus.values();

		ObservableList<CourseStatus> courseStatusList = FXCollections.observableArrayList(courseStatus);
		statusBox = new ComboBox<>();
		statusBox.setItems(courseStatusList);

		Major[] majors = Major.values();

		ObservableList<Major> list = FXCollections.observableArrayList(majors);
		majorBox = new ComboBox<>();
		majorBox.setItems(list);
		makeButtons();
		setUpButtonListeners();
		makeTextFields();
		HBox box1 = new HBox(20);
		VBox box2 = new VBox(20);
		HBox box3 = new HBox(20);
		VBox box4 = new VBox(20);
		box1.setAlignment(Pos.CENTER);
		box2.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(insertButton, removeButton, findButton, updateButton);
		box2.getChildren().addAll(firstNameField, lastNameField, idField);
		box3.getChildren().addAll(titleBox, salaryField, majorBox, officePhoneField);
		box4.getChildren().addAll(courseNumberField, courseTitleField, numberOfCreditsField, statusBox);

		this.add(box1, 0, 0);
		this.add(box2, 0, 1);
		this.add(box3, 0, 2);
		this.add(box4, 0, 3);
		this.setAlignment(Pos.CENTER);
	}

	public VBox getVbox1() {
		return vbox1;
	}

	public void setVbox1(VBox vbox1) {
		this.vbox1 = vbox1;
	}

}
