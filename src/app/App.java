package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ClassroomBag;
import model.FacultyBag;
import model.StudentBag;
import model.TextbookBag;
import view.BottomPane;
import view.ClassroomPane;
import view.FacultyPane;
import view.StudentPane;
import view.TextbookPane;

public class App extends Application {
	private Button textbookButton;
	private Button classroomButton;
	private Button studentButton;
	private Button facultyButton;
	
	
	public static TextbookBag textBookBag;
	public static ClassroomBag classroomBag;
	public static FacultyBag facultyBag;
	public static StudentBag studentBag;
	
	public static Stage pStage;
	
public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pStage = primaryStage;
		
		textBookBag = new TextbookBag(100);
		classroomBag = new ClassroomBag(100);
		facultyBag = new FacultyBag(100);
		studentBag = new StudentBag(100);
		
		BorderPane root = new BorderPane();
		BottomPane bottomPane = new BottomPane(root);
		root.setBottom(bottomPane.getButtonBox());
		
		textbookButton = bottomPane.getTextbookButton();
		classroomButton = bottomPane.getClassroomButton();
		studentButton = bottomPane.getStudentButton();
		facultyButton = bottomPane.getFacultyButton();
		
		VBox centerBox = new VBox(20);
		root.setCenter(centerBox);
		Scene scene = new Scene(root, 700, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("College Management System");
		primaryStage.show();	
		scene.getStylesheets().add("Stylesheet.css");
		
	textbookButton.setOnAction(e ->{
		 root.setCenter(new TextbookPane());
	});
	classroomButton.setOnAction(e ->{
		root.setCenter(new ClassroomPane());
	});
	studentButton.setOnAction(e ->{
		root.setCenter(new StudentPane());
	});
	facultyButton.setOnAction(e->{
		root.setCenter(new FacultyPane());
	});
	}

}
