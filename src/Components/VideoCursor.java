package Components;

import UI.ButtomBox;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VideoCursor extends BorderPane {
	public Stage dialog;
	public Stage stage;
	public double x, y;
	public TextField pathF;
	public TextField titleF;
	public TextField width;
	public TextField height;
	private Button browseB;
	private Button closeB;
	private Button okB;
	public boolean flag;

	public VideoCursor(Stage stage) {
		this.stage = stage;
		init();

	}

	public void init() {
		GridPane gp = new GridPane();
		Label title = new Label("Title");
		Label borwse = new Label("Path");
		pathF = new TextField();
		titleF = new TextField();
		width = new TextField();
		height = new TextField();
		browseB = new Button("Browse");
		gp.setHgap(20);
		gp.setVgap(6);
		gp.setPadding(new Insets(20));
		gp.add(title, 0, 0);
		gp.add(titleF, 1, 0);
		gp.add(borwse, 0, 1);
		gp.add(pathF, 1, 1);
		gp.add(browseB, 2, 1);
		gp.add(new Label("Width"), 0, 2);
		gp.add(width, 1, 2);
		gp.add(new Label("Height"), 0, 3);
		gp.add(height, 1, 3);

		closeB = new Button("Close");
		okB = new Button("Ok");

		ButtomBox b = new ButtomBox();
		b.getChildren().addAll(closeB, okB);

		BorderPane root = new BorderPane();
		root.setCenter(gp);
		root.setBottom(b);

		dialog = new Stage();
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(stage);
		dialog.setResizable(false);
		Scene dialogScene = new Scene(root, 400, 250);
		dialog.setScene(dialogScene);

		okB.setOnAction(e -> {
			flag = true;
			dialog.close();
		});
		closeB.setOnAction(e -> {
			flag = false;
			dialog.close();
		});
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void showBox() {
		dialog.showAndWait();
	}

}
