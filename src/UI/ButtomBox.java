package UI;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ButtomBox extends HBox{
	public ButtomBox() {
		setSpacing(4);
		setStyle("-fx-padding:10 20 10 10;" + "-fx-background-color:rgb(220,220,220);" + "-fx-cursor: hand;");
		setAlignment(Pos.BASELINE_RIGHT);
	}
}
