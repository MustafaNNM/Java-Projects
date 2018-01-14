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
	private List <String> dosyalar;
	
	public FileProcessor(){
		this.setDosyaUrl("C:/Users/King Info Tech/Documents/sunucuYazilim/MyWebApp/files/images/");
		dosyalar= new ArrayList<String>();
	}

	public void setDosyaUrl(String dosyaUrl) {
		this.dosyaUrl = dosyaUrl;
	}
	
	public String  getDosyaUrl() {
		
		return  dosyaUrl;
	}

	public List <String> getDosyalar() {
		File myFolder = new File(this.getDosyaUrl());
		File[] fileArray = myFolder.listFiles();
		  for(File myList: fileArray ){
			  dosyalar.add(myList.getPath());
		  }
		
		return dosyalar;
	}

	

}
