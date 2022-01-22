package MyServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MD5Encryptor;
import bo.Userbo;

/**
 * Servlet implementation class DangKyUser
 */
@WebServlet("/DangKyUser")
public class DangKyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyUser() {
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
			String hoten = (String)request.getAttribute("hoten");
			String anh = (String)request.getAttribute("anh");
			String sodt = (String)request.getAttribute("sodt");
			String email = (String)request.getAttribute("email");
			String pass = (String)request.getAttribute("pass");
			String repass = (String)request.getAttribute("repass");
			
			if(anh == null) {
				request.setAttribute("thongbao", "8");
				 anh = "user.jpg";
			}
			
			Userbo ubo = new Userbo();
			
			if(repass.equals("") && pass.equals("")) {
				request.setAttribute("thongbao", "7");
			} else {
				if(pass.equals(repass)) {
					if(ubo.EmailDaTonTai(email)) {
						request.setAttribute("thongbao", "4");
					} else {
						request.setAttribute("thongbao", "5");
						String anh2 = "image_user\\" + anh;
						String pass2 = MD5Encryptor.encrypt(pass);
						ubo.DangKyUser(hoten, anh2, sodt, email, pass2);
					}
				} else {
					request.setAttribute("thongbao", "3");
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
