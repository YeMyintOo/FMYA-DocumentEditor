package Workspace;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Explorer extends BorderPane {
	protected VBox box;
	protected ScrollPane sp;

	public Explorer() {
		setPrefSize(340, 600);
		init();
	}

	public void init() {
		box = new VBox();
		box.setMinWidth(300);
		sp = new ScrollPane();
		sp.setMaxHeight(600);
		sp.setStyle("-fx-padding:10 10 10 10");
		sp.setContent(box);
		setCenter(sp);

	}
}
