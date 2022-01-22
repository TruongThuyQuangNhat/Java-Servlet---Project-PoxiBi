package MyServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MD5Encryptor;
import bean.User;
import bo.Userbo;

/**
 * Servlet implementation class EditPass
 */
@WebServlet("/EditPass")
public class EditPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPass() {
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
			
			String password = request.getParameter("password");
			String newpassword = request.getParameter("newpassword");
			String mu = request.getParameter("mauser");
			Long mauser = Long.parseLong(mu);
			
			Userbo ubo = new Userbo();
			User boss = ubo.getUserTheoMaUser(mauser);
			String pass = MD5Encryptor.encrypt(password);
			String newpass = MD5Encryptor.encrypt(newpassword);
			
			if(pass.equals(boss.getPass())) {
				request.setAttribute("thongbao", "5");
				ubo.UpdatePass(mauser, newpass);
			} else {
				request.setAttribute("thongbao", "6");
			}
			
			
			
			boss = ubo.getUserTheoMaUser(mauser);
			request.setAttribute("boss", boss);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("ThongTinCaNhan.jsp");
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
