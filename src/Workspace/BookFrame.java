package Workspace;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class BookFrame extends BorderPane {
	protected BookTitleLabel label;
	protected VBox box;

	public BookFrame() {
		this("Sample Book");
	}

	public BookFrame(String bookName) {
		init(bookName);
		label.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				if (box.isVisible()) {
					box.setVisible(false);
					getChildren().remove(box);
				} else {
					box.setVisible(true);
					setCenter(box);
				}
			}
		});
	}

	public void init(String bookName) {
		label = new BookTitleLabel(bookName);
		box = new VBox();
		setTop(label);
		setCenter(box);
	}
}
