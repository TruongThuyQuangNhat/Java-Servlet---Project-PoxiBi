package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.User;
import bo.Anhbo;
import bo.Userbo;

/**
 * Servlet implementation class HienThiQuanLyAnhNangCao
 */
@WebServlet("/HienThiQuanLyAnhNangCao")
public class HienThiQuanLyAnhNangCao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiQuanLyAnhNangCao() {
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
			PrintWriter out= response.getWriter();
			String mu = request.getParameter("mauser");
			Long mauser = Long.parseLong(mu);
			
//			Userbo ubo = new Userbo();
//			User boss = ubo.getUserTheoMaUser(mauser);
			
			Anhbo abo = new Anhbo();
			ArrayList<Anh> ds = abo.getDSAnhTheoMauser(mauser);
			
			for(Anh a: ds) {
				out.println("<div class=\"card\">\r\n"
						+ "    <img src=\""+a.getTenanh()+"\" class=\"card-img-top\" alt=\"image\">\r\n"
						+ "    <div class=\"card-body\">\r\n"
						+ "      <h5 class=\"card-title\">"+a.getTieude()+"</h5>\r\n"
						+ "    </div>\r\n"
						+ "    <div class=\"card-footer\">\r\n"
						+ "      <a type=\"button\" class=\"btn btn-danger\" onclick=\"XoaAnh("+a.getMaanh()+")\" style=\"float:right\">Xóa</a>\r\n"
						+ "      <button class=\"btn btn-primary\" style=float:left\" data-toggle=\"modal\" data-target=\"#myModal"+a.getMaanh()+"\">Edit Tên Ảnh</button>\r\n"
						+ "      <a type=\"button\" href=\"EditLoai?maanh="+a.getMaanh()+"\" class=\"btn btn-primary\" style=float:left\">Edit Loại Ảnh</a>\r\n"
						+ "    </div>\r\n"
						+ "  </div>\r\n"
						+ "<div class=\"container\">\r\n"
						+ "		<div class=\"modal fade\" id=\"myModal"+a.getMaanh()+"\" role=\"dialog\">\r\n"
						+ "			<div class=\"modal-dialog\">\r\n"
						+ "				<!-- Modal content-->\r\n"
						+ "				<div class=\"modal-content\">\r\n"
						+ "					<div class=\"modal-header\">\r\n"
						+ "						<h4 class=\"modal-title\">Chỉnh sửa tên ảnh</h4>\r\n"
						+ "						<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
						+ "					</div>\r\n"
						+ "					<div class=\"modal-body\">\r\n"
						+ "							<div class=\"form-group\">\r\n"
						+ "								<label for=\"email\">Tên hiện tại:</label> <input type=\"text\"\r\n"
						+ "									class=\"form-control\" readonly name=\"name\" value=\""+a.getTieude()+"\">\r\n"
						+ "							</div>\r\n"
						+ "							<div class=\"form-group\">\r\n"
						+ "								<label for=\"pwd\">Tên mới:</label> <input type=\"text\"\r\n"
						+ "									class=\"form-control\" id=\"tenanhmoi_"+a.getMaanh()+"\" name=\"newname\">\r\n"
						+ "								<br>\r\n"
						+ "								<button onclick=\"EditName("+a.getMaanh()+")\" style=\"float:right\" data-dismiss=\"modal\" class=\"btn btn-primary\">Lưu</button>\r\n"
						+ "							</div>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
