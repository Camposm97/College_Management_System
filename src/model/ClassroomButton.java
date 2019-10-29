package model;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ClassroomButton {
private GridPane grid;
	
	public ClassroomButton() {
		grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(50);
		grid.setPadding(new Insets (50));
		
		TextField roomNumberField = new TextField();
		roomNumberField.setPromptText("Room Number");
		TextField roomBuildingField = new TextField();
		roomBuildingField.setPromptText("Building Name");
		
		grid.add(roomNumberField, 0, 0);
		grid.add(roomBuildingField, 1, 0);
		
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	
}		
