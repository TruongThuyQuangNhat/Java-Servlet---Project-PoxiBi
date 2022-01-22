package MyServlet;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadAnh
 */
@WebServlet("/DownloadAnh")
public class DownloadAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadAnh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
	 	String name = request.getParameter("anh");
	 	
	    String fullPath = context.getRealPath("/" + File.separator + name);
	    Path path = Paths.get(fullPath);
	    byte[] data = Files.readAllBytes(path);
	    // Thiết lập thông tin trả về
	    response.setContentType("application/octet-stream");
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
	    response.setContentLength(data.length);
	    InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data));
	    // Ghi file ra response outputstream. 
	    OutputStream outStream = response.getOutputStream();
	    byte[] buffer = new byte[4096];
	    int bytesRead = -1;
	    while ((bytesRead = inputStream.read(buffer)) != -1) {
	      outStream.write(buffer, 0, bytesRead);
	    }
	    inputStream.close();
	    outStream.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
