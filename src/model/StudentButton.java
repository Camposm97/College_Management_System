package model;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class StudentButton {
private GridPane grid;
	
	public StudentButton() {
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
		TextField majorField = new TextField();
		majorField.setPromptText("Major");
		TextField gpaField = new TextField();
		gpaField.setPromptText("Gpa");
		TextField courseNumberField = new TextField();
		courseNumberField.setPromptText("Course Number");
		TextField courseTitleField = new TextField();
		courseTitleField.setPromptText("Course Title");
		TextField numberOfCreditsField = new TextField();
		numberOfCreditsField.setPromptText("Number Of Credits");
		TextField courseStatus = new TextField();
		courseStatus.setPromptText("Course Status");
		
		
		grid.add(firstNameField, 0, 0);
		grid.add(lastNameField, 1, 0);
		grid.add(idField, 0, 1);
		grid.add(majorField, 1, 1);
		grid.add(gpaField, 0, 1);
		grid.add(courseNumberField, 1, 2);
		grid.add(courseTitleField, 2, 1);
		grid.add(numberOfCreditsField, 2, 2);
		grid.add(courseStatus, 2, 1);
		
		
		
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	
}
