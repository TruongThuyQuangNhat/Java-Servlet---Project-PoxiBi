package MyServlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bo.Userbo;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Userbo ubo = new Userbo();
			User boss = new User();
			HttpSession session = request.getSession();
			String anh = (String) request.getAttribute("anh");
			String thongbao = (String) request.getAttribute("thongbao");
			if (thongbao != null) {
				request.setAttribute("thongbao", thongbao);
				String mu2 = (String) request.getAttribute("mauser");
				Long mauser2 = Long.parseLong(mu2);
				boss = ubo.getUserTheoMaUser(mauser2);
			} else {
				if (anh != null) {
					request.setAttribute("thongbao", "1");
					String mu2 = (String) request.getAttribute("mauser");
					Long mauser2 = Long.parseLong(mu2);
					String hoten = (String) request.getAttribute("hoten");
					String sodt = (String) request.getAttribute("sodt");
					String anh2 = "image_user\\" + anh;
					// xoa file anh
					boss = ubo.getUserTheoMaUser(mauser2);
					String dirUrl = request.getServletContext().getRealPath("") + File.separator + boss.getAnhuser();
					File myObj = new File(dirUrl);
					if (myObj.delete()) {
						System.out.println("Deleted the file: " + myObj.getName());
					} else {
						System.out.println("Failed to delete the file.");
					}

					ubo.UpdateUser(mauser2, hoten, anh2, sodt);
					boss = ubo.getUserTheoMaUser(mauser2);
					session.setAttribute("u", boss);

				} else {
					request.setAttribute("thongbao", "1");
					String mu2 = (String) request.getAttribute("mauser");
					Long mauser2 = Long.parseLong(mu2);
					String hoten = (String) request.getAttribute("hoten");
					String sodt = (String) request.getAttribute("sodt");
					boss = ubo.getUserTheoMaUser(mauser2);
					ubo.UpdateUser(mauser2, hoten, boss.getAnhuser(), sodt);
					boss = ubo.getUserTheoMaUser(mauser2);
					session.setAttribute("u", boss);
				}
			}

			request.setAttribute("boss", boss);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("ThongTinCaNhan.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
