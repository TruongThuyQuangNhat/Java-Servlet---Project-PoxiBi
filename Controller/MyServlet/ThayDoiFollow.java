package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.Follow;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Followbo;

/**
 * Servlet implementation class ThayDoiFollow
 */
@WebServlet("/ThayDoiFollow")
public class ThayDoiFollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThayDoiFollow() {
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
			
			String mf = request.getParameter("mauserfollow");
			String mu = request.getParameter("mauser");
			String text = request.getParameter("text");
			
			Long mauserfollow = Long.parseLong(mf);
			Long mauser = Long.parseLong(mu);
			
			Followbo flbo = new Followbo();
			
			if(text.equals("Following")) {
				flbo.ThemFollow(mauser, mauserfollow);
			} else {
				flbo.XoaFollow(mauser, mauserfollow);
			}
			
			int sofollow = flbo.DemFollow(mauser);
			out.println(sofollow);
			
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
