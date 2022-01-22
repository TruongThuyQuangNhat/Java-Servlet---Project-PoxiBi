package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Loai;
import bo.Loaibo;

/**
 * Servlet implementation class AdminHienThiLoai
 */
@WebServlet("/AdminHienThiLoai")
public class AdminHienThiLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHienThiLoai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			PrintWriter out= response.getWriter();//tao ra doi tuong out
			
			Loaibo lbo = new Loaibo();
			ArrayList<Loai> ds = lbo.getDSLoai();
			
			for(Loai l: ds) {
				out.println("<a type=\"button\" data-toggle=\"modal\" data-target=\"#EditLoai"+l.getMaloai()+"\" class=\"btn btn-light\">"+l.getTenloai()+"</a>\r\n"
						+ "<div class=\"container\">\r\n"
						+ "		<div class=\"modal fade\" id=\"EditLoai"+l.getMaloai()+"\" role=\"dialog\">\r\n"
						+ "			<div class=\"modal-dialog\">\r\n"
						+ "				<!-- Modal content-->\r\n"
						+ "				<div class=\"modal-content\">\r\n"
						+ "					<div class=\"modal-header\">\r\n"
						+ "						<h4 class=\"modal-title\">Chỉnh sửa Tên Loại</h4>\r\n"
						+ "						<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
						+ "					</div>\r\n"
						+ "					<div class=\"modal-body\">\r\n"
						+ "							<div class=\"form-group\">\r\n"
						+ "								<label for=\"email\">Tên hiện tại:</label> <input type=\"text\"\r\n"
						+ "									class=\"form-control\" readonly name=\"name\" value=\""+l.getTenloai()+"\">\r\n"
						+ "							</div>\r\n"
						+ "							<div class=\"form-group\">\r\n"
						+ "								<label for=\"pwd\">Tên mới:</label> <input type=\"text\"\r\n"
						+ "									class=\"form-control\" id=\"tenloaimoi_"+l.getMaloai()+"\" name=\"newname\">\r\n"
						+ "								<br>\r\n"
						+ "								<button onclick=\"EditName("+l.getMaloai()+")\" style=\"float:right\" data-dismiss=\"modal\" class=\"btn btn-primary\">Lưu</button>\r\n"
						+ "								<button onclick=\"XoaLoai("+l.getMaloai()+")\" style=\"float:left\" data-dismiss=\"modal\" class=\"btn btn-danger\">Xóa ("+l.getTenloai()+")</button>\r\n"
						+ "							</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
