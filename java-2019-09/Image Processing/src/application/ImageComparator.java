package application;

import org.opencv.core.Core;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;

public class ImageComparator extends Application {
	BorderPane root = null;
	Scene scene = null;

	@Override
	public void start(Stage primaryStage) {

		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("Interface.fxml"));
		} catch (RuntimeException e) {
			System.err.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (LoadException e) {
			System.err.println("LoadException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			System.err.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		if (root != null) {
			try {
				scene = new Scene(root, 400, 400);
			} catch (NullPointerException e) {
				System.out.println("NullPointerException");
				e.printStackTrace();
				System.exit(1);
				return;
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
			try {
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
			try {
				primaryStage.setScene(scene);
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
			try {
				primaryStage.show();
			} catch (Exception e) {
				System.out.println("Exception");
				e.printStackTrace();
				System.exit(1);
				return;
			}
		} else {
			System.out.println("root null olamaz");
		}
	}

	static String path = null;

	public static void main(String[] args) {
		// load the native OpenCV library
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		path = "c:\\opencv\\build\\bin\\";
		try {
			System.load(path + "\\opencv_ffmpeg343_64.dll");// opencv_ffmpeg343_64.dll
			// String path =
			// VMSAPP.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			// path = URLDecoder.decode(path, "UTF-8");
			// System.out.println("Present Project Directory : " + path);
			// System.load(new File(new File(path).list().toString()) + "/opencv"
			// + "/opencv_ffmpeg343_64.dll");// opencv_ffmpeg343_64.dll
			// File fileOut = new File("."+path);
			// System.load("" + System.getProperty("user.dir") + path +
			// "opencv_ffmpeg343_64.dll");
			// System.load(fileOut.toString());
		} catch (UnsatisfiedLinkError e) {
			System.err.println("Native code library failed to load.\n" + e);
			System.exit(1);
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
		try {
			launch(args);
		} catch (SecurityException e) {
			System.out.println("input.position(start); IOException");
			e.printStackTrace();
			System.exit(1);
			return;
		} catch (Exception e) {
			System.out.println("input.position(start); Exception");
			e.printStackTrace();
			System.exit(1);
			return;
		}
	}
}
