package movieplayer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;






public class Movieplayer
  extends Application
{
  public Movieplayer() {}
  
  public void start(final Stage stage)
    throws Exception
  {
    Parent root = (Parent)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("MehmetAkifMediaPlayer");
    stage.show();
  }
  


  public static void main(String[] args)
  {
    launch(args);
  }
}
