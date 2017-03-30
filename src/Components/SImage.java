package Components;

import java.io.FileInputStream;

import UI.ButtomBox;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SImage extends ImageView {
	protected final String src = "Libs/Images/";
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

	public SImage(int width, int height, double x, double y) {
		this(width, height, x, y, "exercise.png");
	}

	public SImage(int width, int height, double x, double y, String path) {
		try {
			Image i = new Image(new FileInputStream(src + "/" + path));
			setImage(i);
			setFitWidth(width);
			setFitHeight(height);
			setX(x);
			setY(y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Loadeditor();
		setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.SECONDARY) {
				showeditor();
			}
		});
		addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setX(e.getX());
				setY(e.getY());
			}
		});

	}

	public void Loadeditor() {
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
		dialog.initModality(Modality.APPLICATION_MODAL);
		// dialog.initOwner(this.dialog);
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

	public void showeditor() {
		dialog.showAndWait();
	}
}
