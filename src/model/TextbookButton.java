package model;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TextbookButton {
	private GridPane grid;
	
	public TextbookButton() {
		grid = new GridPane();
		grid.setVgap(20);
		grid.setHgap(50);
		grid.setPadding(new Insets (50));
		
		TextField titleField = new TextField();
		titleField.setPromptText("Title");
		TextField isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		TextField authorField = new TextField();
		authorField.setPromptText("Author");
		TextField priceField = new TextField();
		priceField.setPromptText("Price");
		
		grid.add(titleField, 0, 0);
		grid.add(isbnField, 1, 0);
		grid.add(authorField, 0, 1);
		grid.add(priceField, 1, 1);
		
		
		
	}

	public GridPane getGrid() {
		return grid;
	}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}
	
	
}
