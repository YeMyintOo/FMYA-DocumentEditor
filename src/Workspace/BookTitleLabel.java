package Workspace;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class BookTitleLabel extends BorderPane {
	private Label label;
	private HBox options;
	public Button export; // Export As HTML Package
	public Button delete; // Delete Book
	public Button newPage; // New Page

	public BookTitleLabel(String bookName) {
		init(bookName);
	
	}

	public void init(String bookName) {
		label = new Label(bookName);
		label.setFont(Font.font("Arial", FontPosture.REGULAR, 22));
		label.setAlignment(Pos.CENTER_LEFT);
		setCenter(label);

		export = new Button("E");
		delete = new Button("D");
		newPage = new Button("N");

		options = new HBox();
		options.setSpacing(4);
		options.setPrefSize(100, 40);
		options.setStyle("-fx-padding:5 5 5 5;" + "-fx-background-color:rgb(220,220,220);" + "-fx-cursor: hand;");
		options.getChildren().addAll(export, delete, newPage);
		setRight(options);
	}

}
