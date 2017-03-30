package Components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

public class Paragraph extends Text {
	private StringProperty data;
	public TextAreaCursor editor;
	// Properties
	MenuItem bold;

	public Paragraph(String word) {
		init();
		setText(word);
		setOnMouseDragged(e -> {
			setX(e.getX());
			setY(e.getY());
		});
		setOnMouseClicked(e -> {
			if (e.getClickCount() == 2) {
				editor.setVisible(true);

			}
		});

		editor.setOnKeyTyped(e -> {
			System.out.println("" + e.getCharacter());
			if (e.getCode() == KeyCode.ENTER) {

			}
		});

	}

	public void init() {
		data = new SimpleStringProperty();
		editor = new TextAreaCursor();
		editor.setVisible(false);
		data.bindBidirectional(editor.textProperty());
		data.bindBidirectional(this.textProperty());
		editor.layoutXProperty().bind(this.xProperty());
		editor.layoutYProperty().bind(this.yProperty().subtract(20));

	}

	public TextAreaCursor getEditor() {
		return editor;
	}
}
