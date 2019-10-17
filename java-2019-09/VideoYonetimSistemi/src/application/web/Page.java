package application.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.io.EofException;
import org.eclipse.jetty.server.Request;

public class Page {
	private String URI="";

	public Page(String string) {
		URI=string;
	}

	/**
	 * @param request
	 */
	protected void requestURI_toString(HttpServletRequest request) {
		String requestURI = "";
		requestURI = request.getRequestURI();
		if (requestURI != null) {
			System.out.println("requestURI:" + requestURI);
		} else {
			System.out.println("requestURI null");
		}
	}
	/**
	 * @param response
	 */
	protected void close_response_writer(final HttpServletResponse response) {
		try {
			response.getWriter().close();
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
			System.exit(1);
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
			return;
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
			return;
		}
		return;
	}
	
	/**
	 * @param baseRequest
	 * @param response
	 */
	@SuppressWarnings("unused")
	protected void response_writer_println(Request baseRequest, final HttpServletResponse response,String to_print) {
		try {
			response.getWriter().println(to_print);
		} catch (EofException e) {
			System.out.println("response.getWriter().println(videolar); EofException");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			e.printStackTrace();
			close_response_writer(response);
			System.exit(1);
			return;
		} catch (IOException e) {
			System.out.println("response.getWriter().println(videolar); IOException");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			e.printStackTrace();
			close_response_writer(response);
			System.exit(1);
			return;
		} catch (SecurityException e) {
			System.out.println("response.getWriter().println(videolar); SecurityException");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			e.printStackTrace();
			close_response_writer(response);
			System.exit(1);
			return;
		} catch (Exception e) {
			System.out.println("response.getWriter().println(videolar); Exception");
			response.setStatus(HttpServletResponse.SC_OK);
			baseRequest.setHandled(true);
			e.printStackTrace();
			close_response_writer(response);
			System.exit(1);
			return;
		}finally{
			//requestURI_toString(request);
		}
		return;
	}
	
	/**
	 * @return the uRI
	 */
	public String getURI() {
		return URI;
	}

	/**
	 * @param uRI the uRI to set
	 */
	public void setURI(String uRI) {
		URI = uRI;
	}
}
