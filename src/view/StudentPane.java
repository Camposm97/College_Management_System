package view;

import app.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Major;
import model.Student;
import model.StudentBag;

public class StudentPane extends GridPane {
	private TextField firstNameField;
	private TextField lastNameField;
	private TextField idField;
	private TextField majorField;
	private TextField gpaField;
	private VBox vbox1;
	private Button insertButton;
	private Button removeButton;
	private Button findButton;
	private Button updateButton;
	private ComboBox<Major> majorBox;
	private StudentBag studentBag;
	private Student student;
	
	public void makeTextFields() {

		firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		idField = new TextField();
		idField.setPromptText("ID");
		majorField = new TextField();
		majorField.setPromptText("Major");
		gpaField = new TextField();
		gpaField.setPromptText("Gpa");
	}

	public void makeButtons() {
		insertButton = new Button("Insert");
		removeButton = new Button("Remove");
		updateButton = new Button("Update");
		findButton = new Button("Find");

		insertButton.setPrefSize(70, 25);
		removeButton.setPrefSize(70, 25);
		updateButton.setPrefSize(70, 25);
		findButton.setPrefSize(70, 25);
	}

	public void setUpButtonListeners() {

		updateButton.setOnAction(e -> {
			String id = this.idField.getText();
			 student = this.studentBag.findById(id);
			 
			if (id == (null)) {
				Alert alert = new Alert(AlertType.WARNING, "Please Enter an ID");
				alert.showAndWait();
			} else if (firstNameField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a FirstName");
				alert.showAndWait();
			} else if (lastNameField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a LastName");
				alert.showAndWait();
			} else if (majorBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a major");
				alert.showAndWait();
			} else if (gpaField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Enter a GPA");
				alert.showAndWait();

			} else if (student != null) {

				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				Major major = (majorBox.getValue());
				double gpa = Double.parseDouble(gpaField.getText());

				student.setFirstName(firstName);
				student.setLastName(lastName);
				student.setMajor(major);
				student.setGpa(gpa);

				this.firstNameField.setText("");
				this.lastNameField.setText("");
				this.majorBox.getSelectionModel().clearSelection();
				this.idField.setText("");
				this.gpaField.setText("");
				this.idField.setText("");

				System.out.println("Student Changed and Added");

			} else {
				System.out.println("Student doesnt exist");
			}

		});

		insertButton.setOnAction(e -> {
			String firstName = firstNameField.getText();
			String lastName =lastNameField.getText();
			String id = idField.getText();
			Major major = majorBox.getValue();
			double gpa = Double.parseDouble(gpaField.getText());

			student = new Student(firstName, lastName, id, major, gpa);
			App.studentBag.insert(student);
			System.out.println(student + " Added");

			firstNameField.setText("");
			lastNameField.setText("");
			majorField.setText("");
			gpaField.setText("");

		});

		removeButton.setOnAction(e -> {
			String id = idField.getText();
			if (student != null) {
				studentBag.deleteByID(id);
				System.out.println(student + " removed");
				
				firstNameField.setText("");
				lastNameField.setText("");
				majorField.setText("");
				idField.setText("");
				gpaField.setText("");
				majorBox.getSelectionModel().clearSelection();
				
			} else {
				System.out.println("Doesnt exist");
			}

		});

		findButton.setOnAction(e -> {
			String id = idField.getText();
			student = studentBag.findById(id);
			
			if (student != null) {
				firstNameField.setText(studentBag.findById(id).getFirstName());
				lastNameField.setText(studentBag.findById(id).getLastName());
				idField.setText(studentBag.findById(id).getId());
				majorField.setText(String.valueOf(studentBag.findById(id).getMajor()));
				gpaField.setText(String.valueOf(studentBag.findById(id).getGpa()));
				System.out.println(student + " Found");
			} else {
				System.out.println("Doesnt exist");
			}
		});

	}

	public StudentPane() {

		super();

		studentBag = App.studentBag;
		majorBox = new ComboBox<>();

		this.setVgap(20);
		this.setHgap(50);
		this.setPadding(new Insets(50));

		Major[] majors = Major.values();

		ObservableList<Major> list = FXCollections.observableArrayList(majors);
		majorBox = new ComboBox<>();
		majorBox.setItems(list);

		makeButtons();
		setUpButtonListeners();
		makeTextFields();

		HBox hbox1 = new HBox(40);
		HBox hbox2 = new HBox(40);
		hbox1.setAlignment(Pos.CENTER);
		hbox1 = new HBox(30);
		hbox1.setAlignment(Pos.CENTER);
		hbox1.getChildren().addAll(insertButton, removeButton, findButton, updateButton);
		hbox2.getChildren().addAll(firstNameField, lastNameField, idField, majorBox, gpaField);

		this.add(hbox1, 0, 0);
		this.add(hbox2, 0, 1);

		this.setAlignment(Pos.CENTER);

	}

	public VBox getVbox1() {
		return vbox1;
	}

	public void setVbox1(VBox vbox1) {
		this.vbox1 = vbox1;
	}

}
