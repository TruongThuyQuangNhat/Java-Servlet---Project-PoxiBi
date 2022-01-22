package MyServlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class TestUploadFile
 */
@WebServlet("/TestUploadFile")
public class TestUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("TestUploadFile.jsp");
		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		final int MaxMemorySize = 1024 * 1024 * 10;  // 10Mb
		final int MaxRequestSize = 1024 * 1024 * 20;  // 20Mb
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setSizeThreshold(MaxMemorySize);
		fileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		
		upload.setSizeMax(MaxRequestSize);
		
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("") + File.separator + "image_user";
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + File.separator + nameimg;
						File file = new File(fileImg);// tạo file
						boolean kt = file.exists();
						try {
							if(kt == true) {
								request.setAttribute("thongbao", "2");
							} else {
								fileItem.write(file);// lưu file
								request.setAttribute("thongbao", "1");
								System.out.println("UPLOAD THÀNH CÔNG...!");
								System.out.println("Đường dẫn lưu file là: " + dirUrl);
								request.setAttribute("anh", nameimg); // Tên ảnh
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				} else// Neu la control
				{
					String tentk = fileItem.getFieldName();
					if (tentk.equals("masach"))
						request.setAttribute("masach", fileItem.getString("utf-8"));
					if (tentk.equals("tensach"))
						request.setAttribute("tensach", fileItem.getString("utf-8"));
					if (tentk.equals("soluong"))
						request.setAttribute("soluong", fileItem.getString("utf-8"));
					if (tentk.equals("gia"))
						request.setAttribute("gia", fileItem.getString("utf-8"));
					if (tentk.equals("maloai"))
						request.setAttribute("maloai", fileItem.getString("utf-8"));
					if (tentk.equals("sotap"))
						request.setAttribute("sotap", fileItem.getString("utf-8"));
					if (tentk.equals("tacgia"))
						request.setAttribute("tacgia", fileItem.getString("utf-8"));
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("TestUploadFile.jsp");
		rd.forward(request, response);
	}

}
