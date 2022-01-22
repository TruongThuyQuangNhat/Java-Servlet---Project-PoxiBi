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
 * Servlet implementation class AdminHienThiAnh
 */
@WebServlet("/AdminHienThiAnh")
public class AdminHienThiAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHienThiAnh() {
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
			Anhbo abo = new Anhbo();
			ArrayList<Anh> dsa = abo.getDSAnh();
			
			Userbo ubo = new Userbo();
			
			for(Anh a: dsa) {
				User u = ubo.getUserTheoMaUser(a.getMauser());
				out.println(" <div style=\"margin-top:30px\" class=\"anh col-sm-4\">\r\n"
						+ "<div class=\"card\">\r\n"
						+ "		<div class=\"card-header\">\r\n"
						+ "<table >\r\n"
						+ "    <tbody>\r\n"
						+ "      <tr>\r\n"
						+ "        <td rowspan=\"2\"><image class=\"rounded-circle\" style=\"height:50px; width:50px\" src=\""+u.getAnhuser()+"\"></td>\r\n"
					    + "			<td><h5>&nbsp;&nbsp;"+u.getTenuser()+"</h5></td>\r\n"
						+ "      </tr>\r\n"
						+ "		<tr><td><h5>&nbsp;&nbsp;"+a.getNgaydang()+"</h5><td></tr>\r\n"
						+ "    </tbody>\r\n"
						+ "</table>\r\n"
						+ "		</div>\r\n"
						+ "    	<img src=\""+a.getTenanh()+"\" class=\"card-img-top\" alt=\"image\">\r\n"
						+ "    	<div class=\"card-body\">\r\n"
						+ "     	<a href=\"XemThongTinAnh?maanh="+a.getMaanh()+"\"><h5 class=\"card-title\">"+a.getTieude()+"</h5></a><h5>Lượt thích: "+a.getLuotlike()+"</h5>\r\n"
						+ "    </div>\r\n"
						+ "		<div class=\"card-footer\"><a onclick=\"XoaAnh("+a.getMaanh()+")\" class=\"btn btn-danger\">Xóa</a></div>"
						+ "</div></div>");
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
