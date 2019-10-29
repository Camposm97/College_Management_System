package model;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class FacultyButton {
private GridPane grid;
	
	public FacultyButton() {
		grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(50);
		grid.setPadding(new Insets (50));
		
		TextField firstNameField = new TextField();
		firstNameField.setPromptText("First Name");
		TextField lastNameField = new TextField();
		lastNameField.setPromptText("Last Name");
		TextField idField = new TextField();
		idField.setPromptText("ID");
		TextField titleField = new TextField();
		titleField.setPromptText("Title");
		TextField salaryField = new TextField();
		salaryField.setPromptText("Salary");
		TextField departmentField = new TextField();
		departmentField.setPromptText("Department");
		TextField officePhoneField = new TextField();
		officePhoneField.setPromptText("Phone Number");
		TextField courseNumberField = new TextField();
		courseNumberField.setPromptText("Course Number");
		TextField  courseTitleField = new TextField();
		courseTitleField.setPromptText("Course Title");
		TextField numberOfCreditsField = new TextField();
		numberOfCreditsField.setPromptText("Number of Credits");
		TextField courseStatus = new TextField();
		courseStatus.setPromptText("CTT,CTT,CT");
		
		grid.add(firstNameField, 0, 0);
		grid.add(lastNameField, 1, 0);
		grid.add(idField, 0, 1);
		grid.add(titleField, 1, 1);
		grid.add(salaryField, 1, 2);
		grid.add(departmentField, 2, 1);
		grid.add(officePhoneField, 2, 2);
		grid.add(courseNumberField, 2, 3);
		grid.add(courseTitleField, 3, 2);
		grid.add(numberOfCreditsField, 3, 3);
		grid.add(courseStatus, 3, 4);
		
		
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	
}
