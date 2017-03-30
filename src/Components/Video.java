package Components;

import java.io.File;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Video extends MediaView {
	private Media media;
	private MediaPlayer mplayer;
	private final String src = "Libs/Videos/";

	public Video(int width, int height, double x, double y) {
		this(width, height, x, y, "Sample.mp4");
	}

	public Video(int width, int height, double x, double y, String path) {
		try {
			File f = new File(src + path);
			media = new Media(f.toURI().toString());
			mplayer = new MediaPlayer(media);
			mplayer.setAutoPlay(true);
			mplayer.setCycleCount(MediaPlayer.INDEFINITE);
			setMediaPlayer(mplayer);
			setFitWidth(width);
			setFitHeight(height);
			setX(x);
			setY(y);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setOnMouseClicked(e -> {
			if (e.getButton() == MouseButton.SECONDARY) {
				// showeditor();
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
}
