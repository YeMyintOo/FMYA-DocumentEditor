package Components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

public class TextAreaCursor extends TextArea {

	public TextAreaCursor() {
		super();
		setMinWidth(200);
		setMinHeight(200);
		setPrefWidth(400);
		setMaxWidth(800);
		// setPrefRowCount(10);
		// setPrefColumnCount(200);
		setVisible(false);
		textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				setPrefWidth(getText().length() * 7);
			}
		});

		setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ESCAPE) {
				setVisible(false);
			}
		});
	}
}
