package view;

import app.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import utils.Utils;

public class BottomPane {
	private HBox ButtonBox;
	private Button studentButton;
	private Button facultyButton;
	private Button classroomButton;
	private Button courseButton;
	private Button textbookButton;
	private Button exitButton;
	private Button restoreButton;
	private Button backupButton;
	private BorderPane root;
	
	public BottomPane(BorderPane root) {
		this.root = root;
		ButtonBox = new HBox(30);
		studentButton = new Button("Student");
		facultyButton = new Button("Faculty");
		textbookButton = new Button("Textbook");
		classroomButton = new Button("Classroom");
		restoreButton = new Button("Restore");
		backupButton = new Button("Backup");
		exitButton = new Button("Exit");
		
		ButtonBox.getChildren().addAll(studentButton, facultyButton, textbookButton, classroomButton,exitButton,restoreButton,backupButton);
		ButtonBox.setAlignment(Pos.CENTER);
		ButtonBox.setPadding(new Insets(30));
		
		setButtonListener();

	}

	private void setButtonListener() {
		studentButton.setOnAction(e -> {
			root.setCenter(new StudentPane());
		});
		facultyButton.setOnAction(e -> {
			root.setCenter(new FacultyPane());
		});
		classroomButton.setOnAction(e -> {
			root.setCenter(new ClassroomPane());
		});
		textbookButton.setOnAction(e -> {
			root.setCenter(new TextbookPane());
		});
		exitButton.setOnAction(e->{
			App.pStage.close();
		});
		restoreButton.setOnAction(e->{
			Utils.restore();
		});
		backupButton.setOnAction(e->{
			Utils.backup();
		});
	}

	public HBox getButtonBox() {
		return ButtonBox;
	}

	public Button getStudentButton() {
		return studentButton;
	}

	public void setStudentButton(Button studentButton) {
		this.studentButton = studentButton;
	}

	public Button getFacultyButton() {
		return facultyButton;
	}

	public void setFacultyButton(Button facultyButton) {
		this.facultyButton = facultyButton;
	}

	public Button getClassroomButton() {
		return classroomButton;
	}

	public void setClassroomButton(Button classroomButton) {
		this.classroomButton = classroomButton;
	}

	public Button getCourseButton() {
		return courseButton;
	}

	public void setCourseButton(Button courseButton) {
		this.courseButton = courseButton;
	}

	public Button getTextbookButton() {
		return textbookButton;
	}

	public void setTextbookButton(Button textbookButton) {
		this.textbookButton = textbookButton;
	}

	public Button getExitButton() {
		return exitButton;
	}

	public void setExitButton(Button exitButton) {
		this.exitButton = exitButton;
	}

	public Button getRestoreButton() {
		return restoreButton;
	}

	public void setRestoreButton(Button restoreButton) {
		this.restoreButton = restoreButton;
	}

	public Button getBackupButton() {
		return backupButton;
	}

	public void setBackupButton(Button backupButton) {
		this.backupButton = backupButton;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public void setButtonBox(HBox buttonBox) {
		ButtonBox = buttonBox;
	}
	
}
