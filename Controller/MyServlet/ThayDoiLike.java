package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bo.AnhDuocLikebo;
import bo.Anhbo;

/**
 * Servlet implementation class ThayDoiLike
 */
@WebServlet("/ThayDoiLike")
public class ThayDoiLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThayDoiLike() {
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
			
			String ma = request.getParameter("maanh");
			String mu = request.getParameter("mauser");
			String text = request.getParameter("text");
			
			Long maanh = Long.parseLong(ma);
			Long mauser = Long.parseLong(mu);
			
			AnhDuocLikebo adlbo = new AnhDuocLikebo();
			Anhbo abo = new Anhbo();
			Anh anh = new Anh();
			
			if(text.equals("Liked")) {
				adlbo.ThemAnhDuocLike(mauser, maanh);
				abo.UpdateTangLuotlike(maanh);
			} else {
				adlbo.XoaAnhDuocLike(mauser, maanh);
				abo.UpdateGiamLuotlike(maanh);
			}
			
			anh = abo.getAnhTheoMaAnh(maanh);
			Long luotlike = anh.getLuotlike();
			out.println(luotlike);
			
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
