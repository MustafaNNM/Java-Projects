package com.kinginfotech.fileExplore;
import java.io.IOException;

public class Demo {

	public static void main(String[] args)  throws IOException{
	    FileProcessor  myFile = new FileProcessor();
	    System.out.println(myFile.getDosyaUrl());
	    System.out.println(myFile.getDosyalar()); 
  }
}
