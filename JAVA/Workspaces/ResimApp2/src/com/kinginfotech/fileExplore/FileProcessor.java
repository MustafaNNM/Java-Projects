package com.kinginfotech.fileExplore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="gallery",eager = true)
@RequestScoped
public class FileProcessor {
	private String dosyaUrl;
	
	
	public FileProcessor(){
		this.setDosyaUrl("C:\\Users\\MehmetAkif-PC\\workspace\\ResimApp2\\WebContent\\resources\\images\\");
		filelist= new ArrayList<String>();
	}

	public void setDosyaUrl(String dosyaUrl) {
		this.dosyaUrl = dosyaUrl;
	}
	
	public String  getDosyaUrl() {
		
		return  dosyaUrl;
	}

	public List <String> getDosyalar() {
		List <String> filelist;
		filelist= new ArrayList<String>();
		File[] fileArray = new File("C:\\Users\\MehmetAkif-PC\\workspace\\ResimApp2\\WebContent\\resources\\images\\").listFiles();
		  for(File file: fileArray ){
			  filelist.add(file.getPath());
		  }
		return filelist;
	}

	

}
