package test;

import java.io.File;
 
import javax.swing.filechooser.FileSystemView;
 
/**
 *
 * @author www.codejava.net
 *
 */
public class DrivesListingExample {
 
    public static void main(String[] args) {
         
        FileSystemView fsv = FileSystemView.getFileSystemView();
         
        File[] drives = File.listRoots();
        if (drives != null && drives.length > 0) {
            for (File aDrive : drives) {
                System.out.println("Drive Letter: " + aDrive);
                System.out.println("\tType: " + fsv.getSystemTypeDescription(aDrive));
                System.out.println("\tDisplay name: " + fsv.getSystemDisplayName(aDrive));
                System.out.println("\tIs drive: " + fsv.isDrive(aDrive));
                System.out.println("\tIs floppy: " + fsv.isFloppyDrive(aDrive));
                System.out.println("Readable: " + aDrive.canRead());
                System.out.println("Writable: " + aDrive.canWrite());
                System.out.println("\tTotal space: " + aDrive.getTotalSpace()/ (1024*1024) + " MB");
                System.out.println("\tFree space: " + aDrive.getFreeSpace()/ (1024*1024) + " MB");
                System.out.println("\tUsable space: " + aDrive.getUsableSpace()/ (1024*1024) + " MB");
                System.out.println();
            }
        }
    }
}