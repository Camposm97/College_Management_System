package view;

import app.App;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Textbook;
import model.TextbookBag;

public class TextbookPane extends GridPane {

	private TextField titleField;
	private TextField isbnField;
	private TextField authorField;
	private TextField priceField;
	private VBox box2;
	private Button insertButton;
	private Button removeButton;
	private Button findButton;
	private Button updateButton;
	private TextbookBag textbookBag;
	private Textbook textbook;


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
		titleField = new TextField();
		titleField.setPromptText("Title");
		isbnField = new TextField();
		isbnField.setPromptText("ISBN");
		authorField = new TextField();
		authorField.setPromptText("Author");
		priceField = new TextField();
		priceField.setPromptText("Price");
	}

	public void setUpButtonListeners() {

		updateButton.setOnAction(e -> {
				String isbn = this.isbnField.getText();
				textbook = this.textbookBag.findByISBN(isbn);
				if(titleField.getText().isEmpty()) {
					Alert alert = new Alert(AlertType.WARNING, "Please Enter a Title");
					alert.showAndWait();
					} else if(isbnField.getText().isEmpty()){
						Alert alert = new Alert(AlertType.WARNING, "Please Enter an ISBN");
						alert.showAndWait();
					} else if(authorField.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.WARNING, "Please Enter an Author");
						alert.showAndWait();
					} else if(priceField.getText().isEmpty()) {
						Alert alert = new Alert(AlertType.WARNING, "Please Enter a Price");
						alert.showAndWait();
					}
				
				if (textbook != null) {
					String title = this.titleField.getText();
					String author = (this.authorField.getText());
					double price = Double.parseDouble(this.priceField.getText());
	
					textbook.setBookTitle(title);
					textbook.setAuthor(author);
					textbook.setPrice(price);
	
					this.titleField.setText("");
					this.authorField.setText("");
					this.priceField.setText("");
					System.out.println("Textbook updated and added");
				} else {
					System.out.println("Textbook doesnt exist");
				}
			});

		insertButton.setOnAction(e -> {
			String title = this.titleField.getText();
			String isbn = this.isbnField.getText();
			String author = this.authorField.getText();
			double price = Double.parseDouble(this.priceField.getText());

			textbook = new Textbook(title, isbn, author, price);
			App.textBookBag.insert(textbook);
			System.out.println(textbook + " Inserted");

			titleField.setText("");
			authorField.setText("");
			priceField.setText("");
			
		});
		
		removeButton.setOnAction(e -> {
			String isbn = this.isbnField.getText();
			if (textbook != null) {
				this.textbookBag.deleteByISBN(isbn);
				System.out.println(isbn + " removed");
				
				titleField.setText("");
				isbnField.setText("");
				authorField.setText("");
				priceField.setText("");
			} else {
				System.out.println("Doesnt exist");
			}

		});

		findButton.setOnAction(e -> {
			String isbn = this.isbnField.getText();
			textbook = this.textbookBag.findByISBN(isbn);
			
			titleField.setText(textbookBag.findByISBN(isbn).getBookTitle());
			isbnField.setText(textbookBag.findByISBN(isbn).getIsbn());
			authorField.setText(textbookBag.findByISBN(isbn).getAuthor());
			priceField.setText(String.valueOf(textbookBag.findByISBN(isbn).getPrice()));
			
			if (textbook != null) {
				System.out.println(textbook + " found");
			} else {
				System.out.println("Doesnt Exist");
			}
		});

	}
	public TextbookPane() {

		super();
		textbookBag = App.textBookBag;

		this.setVgap(20);
		this.setHgap(50);
		this.setPadding(new Insets(50));

		makeButtons();
		makeTextFields();
		setUpButtonListeners();

		HBox box1 = new HBox(40);
		HBox hbox2 = new HBox(40);
		HBox box3 = new HBox(40);
		box1.setAlignment(Pos.CENTER);
		box2 = new VBox(30);
		box2.setAlignment(Pos.CENTER);
		box1.getChildren().addAll(insertButton, removeButton, findButton, updateButton);
		hbox2.getChildren().addAll(titleField, isbnField);
		box3.getChildren().addAll(authorField, priceField);
		this.add(box1, 0, 0);
		this.add(hbox2, 0, 1);
		this.add(box3, 0, 2);

		this.setAlignment(Pos.CENTER);
	}
	
	public VBox getBox2() {
		return box2;
	}

	public void setBox2(VBox box2) {
		this.box2 = box2;
	}

}
