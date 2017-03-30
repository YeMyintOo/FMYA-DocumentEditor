package UI;

import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Icons extends ImageView {
	protected final String src="Libs/Images/";
	public Icons() {
		this("default.png");
	}
	public Icons(String path) {
		super();
		try {
			Image i = new Image(new FileInputStream(src+"/"+path));
			setImage(i);
			setFitHeight(200);
			setFitWidth(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
