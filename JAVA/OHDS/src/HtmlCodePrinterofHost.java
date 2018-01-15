import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

public class HtmlCodePrinterofHost  {

	/**
	 * @param response 
	 * @param bufferedreader
	 */
	private static void readlinesofbufferedreader(HttpServletResponse response, BufferedReader bufferedreader) {
		String line;
		StringBuffer sb = new StringBuffer("");
		try {
			while ((line = bufferedreader.readLine()) != null) {
			    sb.append(line+"\n");
			    response.getWriter().println(line+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb);
		//try {
			//response.getWriter().println(sb);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}

	/**
	 * @param inputStreamReader
	 * @return
	 */
	private static BufferedReader createbufferedreader(InputStreamReader inputStreamReader) {
		BufferedReader bufferedreader;
		bufferedreader = new BufferedReader(inputStreamReader);
		return bufferedreader;
	}

	/**
	 * @param connectionStream
	 * @param inputStreamReader
	 * @return
	 */
	private static InputStreamReader createinputstreamreader(InputStream connectionStream, InputStreamReader inputStreamReader) {
		try {
			inputStreamReader = new InputStreamReader(connectionStream, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		return inputStreamReader;
	}

	/**
	 * @param connection
	 * @param connectionStream
	 * @return
	 */
	private static InputStream getconnectionStreamofconnection(URLConnection connection, InputStream connectionStream) {
		try {
			connectionStream=connection.getInputStream();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		return connectionStream;
	}

	/**
	 * @param url
	 * @param connection
	 * @return
	 */
	private static URLConnection openurlconnection(URL url, URLConnection connection) {
		try {
			connection = url.openConnection();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return connection;
	}

	private static URL createURL(String host, URL url) {
		try {
			url = new URL(host);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}

	public void printhtmlcodesofhost(HttpServletResponse response, String host) {
		URL url = null;
		URLConnection connection=null;
		InputStream connectionStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedreader=null;
		url = createURL(host, url);
		connection = openurlconnection(url, connection);
		connectionStream = getconnectionStreamofconnection(connection, connectionStream);
		inputStreamReader = createinputstreamreader(connectionStream, inputStreamReader);
		bufferedreader = createbufferedreader(inputStreamReader);
		readlinesofbufferedreader(response,bufferedreader);
		
	}



}