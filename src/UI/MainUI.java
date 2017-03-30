package UI;

import java.io.File;

import Workspace.WorkSpace;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainUI extends Application {
	private Scene scene;
	private Stage stage;
	private BorderPane root;
	private MenuTab menuTab;

	@Override
	public void start(Stage stage) throws Exception {
		init();
		this.stage = stage;
		scene = new Scene(root, 600, 600);
		stage.setScene(scene);
		File f = new File("Libs/Css/Keywards.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
		// stage.setFullScreen(true);
		stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		stage.setTitle("ForMyanmar Docuemnt Editor");
		// stage.centerOnScreen();
		stage.show();

		controller();
	}

	public void init() {
		root = new BorderPane();
		menuTab = new MenuTab();
		root.setTop(menuTab);
	}

	public void controller() {
		// Actions
		menuTab.nBook.setOnAction(e -> {
			BoxBook box = new BoxBook(stage);
			box.showAndWait();
			WorkSpace ws = new WorkSpace(stage, box.book);
			root.setCenter(ws);
		});

	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
