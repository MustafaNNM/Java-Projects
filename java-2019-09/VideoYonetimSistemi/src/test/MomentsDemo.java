package test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
class MomentsClass {
	private Mat src;
    private JFrame frame;
    private JLabel imgSrcLabel;
    private JLabel imgContoursLabel;
    public MomentsClass(String[] args) {
    	  String filename = args.length > 0 ? args[0] : ".\\img\\whiteinblack.png";
          src = Imgcodecs.imread(filename);
          if (src.empty()) {
              System.err.println("Cannot read image: " + filename);
              System.exit(0);
          }
          
          //Imgproc.blur(srcGray, srcGray, new Size(3, 3));
          // Create and set up the window.
          frame = new JFrame("Finding contours in your image demo");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          // Set up the content pane.
          Image img = HighGui.toBufferedImage(src);
          addComponentsToPane(frame.getContentPane(), img);
          // Use the content pane's default BorderLayout. No need for
          // setLayout(new BorderLayout());
          // Display the window.
          frame.pack();
          frame.setVisible(true);
          Mat countors=findContours(src);
          imgContoursLabel.setIcon(new ImageIcon(HighGui.toBufferedImage(countors)));
          frame.repaint();
    }
    private Mat findContours(Mat src) {
        List<MatOfPoint> contours = new ArrayList<>();
        Mat srcGray = new Mat();
        Mat hierarchy = new Mat();
        Imgproc.cvtColor(src, srcGray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.findContours(srcGray, contours, hierarchy, Imgproc.RETR_TREE, Imgproc.CHAIN_APPROX_SIMPLE);
        List<Moments> mu = new ArrayList<>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            mu.add(Imgproc.moments(contours.get(i)));
        }
        List<Point> mc = new ArrayList<>(contours.size());
        for (int i = 0; i < contours.size(); i++) {
            //add 1e-5 to avoid division by zero
            mc.add(new Point(mu.get(i).m10 / (mu.get(i).m00 + 1e-5), mu.get(i).m01 / (mu.get(i).m00 + 1e-5)));
        }
        Mat drawing = Mat.zeros(srcGray.size(), CvType.CV_8UC3);
        for (int i = 0; i < contours.size(); i++) {
        	Scalar color = new Scalar(0, 255, 0);// new Scalar(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Imgproc.drawContours(drawing, contours, i, color, 2, Core.LINE_8, hierarchy, 0, new Point());
            Imgproc.circle(drawing, mc.get(i), 4, color, -1);
        }
        System.out.println("\t Info: Area and Contour Length \n");
        for (int i = 0; i < contours.size(); i++) {
            System.out.format(" * Contour[%d] - Area (M_00) = %.2f - Area OpenCV: %.2f - Length: %.2f\n", i,
                    mu.get(i).m00, Imgproc.contourArea(contours.get(i)),
                    Imgproc.arcLength(new MatOfPoint2f(contours.get(i).toArray()), true));
        }
        return drawing;
    }
    private void addComponentsToPane(Container pane, Image img) {
    	if (!(pane.getLayout() instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        JPanel imgPanel = new JPanel();
        imgSrcLabel = new JLabel(new ImageIcon(img));
        imgPanel.add(imgSrcLabel);
        Mat blackImg = Mat.zeros(src.size(), CvType.CV_8U);
        imgContoursLabel = new JLabel(new ImageIcon(HighGui.toBufferedImage(blackImg)));
        imgPanel.add(imgContoursLabel);
        pane.add(imgPanel, BorderLayout.CENTER);
    }
}
public class MomentsDemo {
    public static void main(String[] args) {
        // Load the native OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // Schedule a job for the event dispatch thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MomentsClass(args);
            }
        });
    }
}