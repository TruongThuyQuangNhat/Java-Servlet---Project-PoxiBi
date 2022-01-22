package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.Loai;
import bean.MD5Encryptor;
import bean.User;
import bo.Anhbo;
import bo.CategoriesAnhbo;
import bo.Commentbo;
import bo.Loaibo;
import bo.Userbo;

/**
 * Servlet implementation class DangNhapUser
 */
@WebServlet("/DangNhapUser")
public class DangNhapUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhapUser() {
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
			HttpSession session=request.getSession();
			
			Userbo ubo = new Userbo();
			
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			
			if(user != null && pass != null) {
				String password = MD5Encryptor.encrypt(pass);
				User u = ubo.KiemTraDangNhap(user, password);
				if(u != null) {
					session.setAttribute("u", u);
				  } else {
					  request.setAttribute("thongbao", "8");
				  }
			} else {
				request.setAttribute("thongbao", "6");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("Home");
		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
