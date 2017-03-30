package Workspace;

import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WorkSpace extends BorderPane {
	private Stage stage;
	private Explorer exp;
	private ToolTab tool;
	private TabPane tabPane;

	public WorkSpace(Stage stage, int booktype) {
		this.stage = stage;
		init();
		tool.newBook.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				addNewBookFrame("Sample Book");
			}
		});
	}

	public void init() {
		exp = new Explorer();
		tool = new ToolTab();
		tabPane = new TabPane();
		setCenter(tabPane);
		setLeft(exp);
		setTop(tool);

	}

	public void addDocumentTab(String chapterName) {
		Tab tab = new Tab();
		Document doc = new Document(stage);

		tool.wordB.setOnAction(e -> {
			Document d = (Document) tabPane.getSelectionModel().getSelectedItem().getContent();
			d.selectedTool.set("1");
		});
		tool.paragraphB.setOnAction(e -> {
			Document d = (Document) tabPane.getSelectionModel().getSelectedItem().getContent();
			d.selectedTool.set("2");
		});
		tool.imageB.setOnAction(e -> {
			Document d = (Document) tabPane.getSelectionModel().getSelectedItem().getContent();
			d.selectedTool.set("3");
		});
		tool.videoB.setOnAction(e -> {
			Document d = (Document) tabPane.getSelectionModel().getSelectedItem().getContent();
			d.selectedTool.set("4");
		});

		tab.setContent(doc);
		tab.setText(chapterName);
		tabPane.getTabs().add(tab);

	}

	public void addNewBookFrame(String bookName) {
		BookFrame frame = new BookFrame(bookName);
		exp.box.getChildren().addAll(frame);
		frame.label.export.setOnAction(e -> {
			System.out.println("Export HTML File");
		});
		frame.label.delete.setOnAction(e -> {
			exp.box.getChildren().remove(frame);
		});
		frame.label.newPage.setOnAction(e -> {
			BookPageLabel chapter = new BookPageLabel("Chapter1");
			chapter.open.setOnAction(s -> {
				addDocumentTab(chapter.label.getText());
			});
			frame.box.getChildren().addAll(chapter);
		});

	}
}
