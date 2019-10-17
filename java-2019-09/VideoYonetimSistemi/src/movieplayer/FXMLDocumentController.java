package movieplayer;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {
	@FXML
	private MediaView mediaView;
	private MediaPlayer mediaPlayer;
	private String filePath;
	@FXML
	private Slider slider;
	@FXML
	private HBox menuBar;
	@FXML
	private Slider seekSlider;
	@FXML
	private Button openButton;
	@FXML
	private Button playButton;
	@FXML
	private Button pauseButton;
	@FXML
	private Button stopButton;
	@FXML
	private Button exitButton;

	public FXMLDocumentController() {
	}

	@FXML
	private void handleButtonAction(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("select your media(*.mp4)",
				new String[] { "*.mp4" });
		fileChooser.getExtensionFilters().add(filter);
		File file = fileChooser.showOpenDialog(null);
		filePath = file.toURI().toString();
		if (filePath != null) {
			Media media = new Media(filePath);
			mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			DoubleProperty width = mediaView.fitWidthProperty();
			DoubleProperty hieght = mediaView.fitHeightProperty();
			width.bind(Bindings.selectDouble(mediaView.sceneProperty(), new String[] { "width" }));
			hieght.bind(Bindings.select(mediaView.sceneProperty(), new String[] { "hieght" }));
			slider.setValue(mediaPlayer.getVolume() * 100.0D);
			slider.valueProperty().addListener(new InvalidationListener() {
				public void invalidated(Observable observable) {
					mediaPlayer.setVolume(slider.getValue() / 100.0D);
				}
			});
			mediaPlayer.play();
		}
	}

	@FXML
	private void pauseVideo(ActionEvent event) {
		mediaPlayer.pause();
	}

	@FXML
	private void exitVideo(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	private void stopVideo(ActionEvent event) {
		mediaPlayer.stop();
	}

	@FXML
	private void playVideo(ActionEvent event) {
		mediaPlayer.play();
		mediaPlayer.setRate(1.0D);
	}

	@FXML
	private void fastVideo(ActionEvent event) {
		mediaPlayer.setRate(1.5D);
	}

	@FXML
	private void fasterVideo(ActionEvent event) {
		mediaPlayer.setRate(2.0D);
	}

	@FXML
	private void slowVideo(ActionEvent event) {
		mediaPlayer.setRate(0.75D);
	}

	@FXML
	private void slowerVideo(ActionEvent event) {
		mediaPlayer.setRate(0.5D);
	}
	/*implements Initializable implementasyonundan dolayý*/
	public void initialize(URL url, ResourceBundle rb) {
	}
}
