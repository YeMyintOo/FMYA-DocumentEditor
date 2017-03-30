package UI;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BoxBook extends Stage {
	protected BorderPane root;
	protected Icons sample; // Sample Books;
	protected Icons exercise; // Exercise Books;
	protected Button clsBtn; // Close Button;
	public int book;
	public BoxBook(Stage owner) {
		super();
		initModality(Modality.WINDOW_MODAL); // Prevent click parent stage
		initOwner(owner);
		setResizable(false);
		setTitle("Choose Book");

		sample = new Icons("sample.png");
		exercise = new Icons("sample.png");

		root = new BorderPane();
		GridPane gp = new GridPane();
		gp.setHgap(20);
		gp.setAlignment(Pos.BASELINE_CENTER);
		gp.add(sample, 0, 1);
		gp.add(exercise, 1, 1);

		HBox hbox = new ButtomBox();
		clsBtn = new Button("Close");
		hbox.getChildren().add(clsBtn);

		root.setCenter(gp);
		root.setBottom(hbox);

		Scene scene = new Scene(root, 600, 350, Color.WHITE);
		setScene(scene);
		controller();
	}

	public void controller() {
		sample.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent arg0) {
				book=1;
				close();
			}
		});
	}
}
