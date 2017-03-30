package Components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class TextCursor extends TextField {

	public TextCursor() {
		super();
		setMinWidth(50);
		setPrefWidth(50);
		setMaxWidth(1000);
		setVisible(false); // Default
		textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				setPrefWidth(getText().length() * 7);
			}
		});
		setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				setVisible(false);
			}
		});

	}
}
