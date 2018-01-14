package com.tr.kodgraf.httpexample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class GetHTTPMethod {
	
	public String getInternetData() throws Exception {
		BufferedReader reader = null;
		String data = null;
		try {
			HttpClient client = new DefaultHttpClient();
			URI website = new URI("http://www.kodgraf.com");
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent())
					);
			StringBuffer buffer = new StringBuffer("");
			String line = "";
			String newLine = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				buffer.append(line + newLine);
				//data = data + (line + newLine);
			}
			reader.close(); 
			data = buffer.toString();
			return data;
		} finally {
			if (reader != null) {
				try {
					reader.close();
					return data;
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		}
	}
}
