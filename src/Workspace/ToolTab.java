package Workspace;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ToolTab extends HBox {
	public Button newBook; // Swap with Icons
	public Button wordB;
	public Button paragraphB;
	public Button imageB;
	public Button videoB;

	public ToolTab() {
		setPrefHeight(40);
		newBook = new Button("New Book");
		wordB = new Button("Word");
		paragraphB = new Button("Paragraph");
		imageB = new Button("Image");
		videoB = new Button("Video");

		getChildren().addAll(newBook, wordB, paragraphB, imageB, videoB);
	}
}
