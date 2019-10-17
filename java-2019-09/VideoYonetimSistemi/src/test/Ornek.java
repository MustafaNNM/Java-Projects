package test;

import org.opencv.core.Mat;
import org.opencv.video.BackgroundSubtractor;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;
import org.opencv.videoio.VideoCapture;

public class Ornek {
    public static void main(String[] args){
        VideoCapture capture = new VideoCapture(0);
          Mat camImage = new Mat();
          BackgroundSubtractorMOG2 backgroundSubtractorMOG = Video.createBackgroundSubtractorMOG2();
            if (capture.isOpened()) {
                while (true) {
                    capture.read(camImage);


                    Mat fgMask=new Mat();
                    backgroundSubtractorMOG.apply(camImage, fgMask,0.1);

                    Mat output=new Mat();
                    camImage.copyTo(output,fgMask);

                    //output nesnesini kullanabilirsiniz
                   }
                }
    }
}