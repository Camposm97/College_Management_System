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
import model.Classroom;
import model.ClassroomBag;
import model.CourseStatus;
import model.Major;
import model.ProjectorOrNot;
import model.RoomBuilding;
import model.Title;

public class ClassroomPane extends GridPane {
	private TextField roomNumberField;
	private TextField roomBuildingField;
	private TextField capacityField;
	private TextField projectorOrNotField;
	private VBox box2;
	private Button insertButton;
	private Button removeButton;
	private Button findButton;
	private Button updateButton;
	private ComboBox<RoomBuilding> buildingBox;
	private ComboBox<ProjectorOrNot> projectorBox;
	private ClassroomBag classroomBag;
	private Classroom classroom;

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

	public void makeTextFields() {

		roomNumberField = new TextField();
		roomNumberField.setPromptText("Room Number");
		roomBuildingField = new TextField();
		roomBuildingField.setPromptText("Building Name");
		capacityField = new TextField();
		capacityField.setPromptText("Capacity");
		projectorOrNotField = new TextField();
		projectorOrNotField.setPromptText("Projector?");
	}

	public void setUpButtonListeners() {

		updateButton.setOnAction(e -> {
			int roomNumber = Integer.parseInt(roomNumberField.getText());
			classroom = this.classroomBag.findByRoomBuilding(roomNumber);
			if (roomNumberField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Please Enter a RoomNumber");
				alert.showAndWait();
			} else if (buildingBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Please Select a Room Number");
				alert.showAndWait();
			} else if (capacityField.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.WARNING, "Please Enter a Capacity");
				alert.showAndWait();
			} else if (projectorBox.getValue() == null) {
				Alert alert = new Alert(AlertType.WARNING, "Please Selct an True or False");
				alert.showAndWait();
			} else if (classroom != null) {

				roomNumber = Integer.parseInt(roomNumberField.getText());
				RoomBuilding roomBuilding = buildingBox.getValue();
				ProjectorOrNot projectorOrNot = projectorBox.getValue();
				int capacity = Integer.parseInt(capacityField.getText());

				classroom.setRoomNumber(roomNumber);
				classroom.setRoomBuilding(roomBuilding);
				classroom.setCapacity(capacity);
				classroom.setProjectorOrNot(projectorOrNot);

				roomBuildingField.setText("");
				roomBuildingField.setText("");
				capacityField.setText("");
				projectorBox.getSelectionModel().clearSelection();

				System.out.println("Classroom Changed and Added");

			} else {
				System.out.println("Classroom doesnt exist");
			}

		});

		insertButton.setOnAction(e -> {
			int roomNumber = Integer.parseInt(roomNumberField.getText());
			RoomBuilding roomBuilding = buildingBox.getValue();
			ProjectorOrNot projectorOrNot = projectorBox.getValue();
			int capacity = Integer.parseInt(capacityField.getText());

			Classroom classroom = new Classroom(roomNumber, roomBuilding, capacity, projectorOrNot);
			classroomBag.insert(classroom);
			System.out.println(classroom + " Added");

			roomBuildingField.setText("");
			capacityField.setText("");
			projectorBox.getSelectionModel().clearSelection();

		});

		removeButton.setOnAction(e -> {
			int roomNumber = Integer.parseInt(roomNumberField.getText());

			if (classroom != null) {
				classroomBag.deleteByRoomNumber(roomNumber);
				System.out.println(roomNumber + " Removed");

				roomNumberField.setText("");
				roomBuildingField.setText("");
				capacityField.setText("");
				projectorBox.getSelectionModel().clearSelection();

			} else {
				System.out.println("Doesnt exist");
			}

		});

		findButton.setOnAction(e -> {
			int roomNumber = Integer.parseInt(roomNumberField.getText());
			classroom = classroomBag.findByRoomBuilding(roomNumber);

			if (classroom != null) {
				
				roomNumberField.setText(String.valueOf((classroomBag.findByRoomBuilding(roomNumber).getRoomNumber())));
				roomBuildingField.setText(String.valueOf(classroomBag.findByRoomBuilding(roomNumber).getRoomBuilding()));
				capacityField.setText(String.valueOf(classroomBag.deleteByRoomNumber(roomNumber).getCapacity()));

				System.out.println(classroom + " Found");
			} else {
				System.out.println("Doesnt exist");
			}
		});

	}

	public ClassroomPane() {

		super();
		buildingBox = new ComboBox<>();
		projectorBox = new ComboBox<>();
		classroomBag = App.classroomBag;
		this.setVgap(20);
		this.setHgap(50);
		this.setPadding(new Insets(50));

		RoomBuilding[] building = RoomBuilding.values();

		ObservableList<RoomBuilding> buildingList = FXCollections.observableArrayList(building);
		buildingBox = new ComboBox<>();
		buildingBox.setItems(buildingList);

		ProjectorOrNot[] projector = ProjectorOrNot.values();

		ObservableList<ProjectorOrNot> projectorList = FXCollections.observableArrayList(projector);
		projectorBox = new ComboBox<>();
		projectorBox.setItems(projectorList);

		makeButtons();
		setUpButtonListeners();
		makeTextFields();

		HBox box1 = new HBox(40);
		HBox hbox2 = new HBox(40);

		box1.setAlignment(Pos.CENTER);
		box2 = new VBox(30);
		box2.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(insertButton, removeButton, findButton, updateButton);
		hbox2.getChildren().addAll(roomNumberField, buildingBox, projectorBox, capacityField);

		this.add(box1, 0, 0);
		this.add(hbox2, 0, 1);

		this.setAlignment(Pos.CENTER);

	}

	public VBox getBox2() {
		return box2;
	}

	public void setBox2(VBox box2) {
		this.box2 = box2;
	}

}
