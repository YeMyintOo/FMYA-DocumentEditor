package Workspace;

import Components.ImageCursor;
import Components.Paragraph;
import Components.SImage;
import Components.TextAreaCursor;
import Components.TextCursor;
import Components.Video;
import Components.VideoCursor;
import Components.Word;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Document extends Pane {
	Stage stage;
	ScrollPane sp;
	boolean isNew;
	TextCursor field;
	TextAreaCursor area;
	ImageCursor image;
	VideoCursor video;
	Word word;
	Paragraph paragraph;
	public StringProperty selectedTool;
	private Label sample;

	// New File
	public Document(Stage stage) {
		this(stage, "");
		isNew = true;
	}

	// Old Chapter Loading
	public Document(Stage stage, String path) {
		// Loading data to Document Pane
		this.stage = stage;
		isNew = false;
		init();
		addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent key) {
				// Load TextCursor
				if (key.getTarget() instanceof Document) {
					switch (selectedTool.getValue().toString()) {
					case "1": // Word
						field.setLayoutX(key.getX());
						field.setLayoutY(key.getY());
						field.setVisible(true);
						break;
					case "2": // Paragraph
						area.setLayoutX(key.getX());
						area.setLayoutY(key.getY());
						area.setVisible(true);
						break;
					case "3":
						image.setLocation(key.getX(), key.getY());
						image.showBox();
						if (image.flag) {
							int height = Integer.parseInt(image.height.getText().trim());
							int width = Integer.parseInt(image.width.getText().trim());
							double x = image.x;
							double y = image.y;
							SImage image = new SImage(width, height, x, y);
							getChildren().addAll(image);
						}
						break;
					case "4":
						video.setLocation(key.getX(), key.getY());
						video.showBox();
						if (video.flag) {
							int height = Integer.parseInt(video.height.getText().trim());
							int width = Integer.parseInt(video.width.getText().trim());
							double x = video.x;
							double y = video.y;
							Video video = new Video(width, height, x, y);
							getChildren().addAll(video);
						}
						break;
					}
				}
			}
		});

		field.visibleProperty().addListener(e -> {
			if (!field.isVisible()) {
				word = new Word(field.getText());
				word.setX(field.getLayoutX());
				word.setY(field.getLayoutY());
				getChildren().addAll(word, word.editor);
				field.setText("");
			}
		});

		area.visibleProperty().addListener(e -> {
			if (!field.isVisible()) {
				paragraph = new Paragraph(area.getText());
				paragraph.setX(area.getLayoutX());
				paragraph.setY(area.getLayoutY());
				getChildren().addAll(paragraph, paragraph.editor);
				area.setText("");
			}
		});

	}

	public void init() {
		setStyle("-fx-background-color:white");
		selectedTool = new SimpleStringProperty();
		selectedTool.setValue("1");
		sp = new ScrollPane();
		field = new TextCursor();
		area = new TextAreaCursor();
		image = new ImageCursor(stage);
		video = new VideoCursor(stage);
		sample = new Label();
		sample.textProperty().bind(selectedTool);
		sample.setLayoutX(400);
		sample.setLayoutY(400);

		getChildren().addAll(field, area, image, sample, video);

	}

	public void addKeyWards(Word word) {
		getChildren().add(word);
	}
}
