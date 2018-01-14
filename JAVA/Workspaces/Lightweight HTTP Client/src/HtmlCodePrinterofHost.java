import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HtmlCodePrinterofHost  {

	/**
	 * @param host
	 */
	protected void printhtmlcodesofhost(String host) {
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
		readlinesofbufferedreader(bufferedreader);
	}
	/**
	 * @param bufferedreader
	 */
	private static void readlinesofbufferedreader(BufferedReader bufferedreader) {
		String line;
		StringBuffer sb = new StringBuffer("");
		try {
			while ((line = bufferedreader.readLine()) != null) {
			    sb.append(line+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(sb);
	}
	/**
	 * @param inputStreamReader
	 * @return buffered_reader
	 */
	private static BufferedReader createbufferedreader(InputStreamReader inputStreamReader) {
		BufferedReader buffered_reader;
		buffered_reader = new BufferedReader(inputStreamReader);
		return buffered_reader;
	}
	/**
	 * @param connectionStream
	 * @param inputStreamReader
	 * @return inputStreamReader
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
	 * @return connectionStream
	 */
	private static InputStream getconnectionStreamofconnection(URLConnection connection, InputStream connectionStream) {
		try {
			connectionStream=connection.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connectionStream;
	}
	/**
	 * @param url
	 * @param connection
	 * @return connection
	 */
	private static URLConnection openurlconnection(URL url, URLConnection connection) {
		try {
			connection = url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * @param host
	 * @param url
	 * @return url
	 */
	private static URL createURL(String host, URL url) {
		try {
			url = new URL(host);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return url;
	}
}