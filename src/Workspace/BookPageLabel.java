package Workspace;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class BookPageLabel extends BorderPane {
	public Label label;
	private HBox options;
	public Button open; // Open this Chapter in Text Editor(Document)
	public Button delete; // Delete This Chapter

	// e.g Chapter-1
	public BookPageLabel(String pageName) {
		init(pageName);
	}

	public void init(String pageName) {
		label = new Label(pageName);
		label.setFont(Font.font("Arial", FontPosture.REGULAR, 10));
		label.setAlignment(Pos.BOTTOM_LEFT);
		setCenter(label);

		open = new Button("O");
		delete = new Button("D");

		options = new HBox();
		options.setSpacing(4);
		options.setPrefSize(100, 40);
		options.setStyle("-fx-padding:5 5 5 5;" + "-fx-background-color:rgb(220,220,220);" + "-fx-cursor: hand;");
		options.getChildren().addAll(open, delete);
		setRight(options);
	}
}
