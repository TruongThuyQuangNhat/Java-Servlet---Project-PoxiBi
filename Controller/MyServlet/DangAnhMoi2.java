package MyServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.User;
import bo.Anhbo;

/**
 * Servlet implementation class DangAnhMoi2
 */
@WebServlet("/DangAnhMoi2")
public class DangAnhMoi2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangAnhMoi2() {
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
			
			String tb = (String) request.getAttribute("thongbao");
			User u = (User) session.getAttribute("u");
			String tieude = (String) request.getAttribute("tieude");
			String anh = (String) request.getAttribute("anh");
			
			if(tb == null) {
				Anhbo abo = new Anhbo();
				String anh2 = "image_anh/" + anh;
				abo.ThemAnhMoi(anh2, u.getMauser(), tieude);
				
				Anh a = abo.getAnhTheoTenAnh(anh2);
				request.setAttribute("maanh", a.getMaanh());
				RequestDispatcher rd= request.getRequestDispatcher("ChonLoaiChoAnhMoi.jsp");
				  rd.forward(request, response);
			} else {
				request.setAttribute("thongbao", tb);
				RequestDispatcher rd= request.getRequestDispatcher("DangAnhMoi.jsp");
				  rd.forward(request, response);
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
