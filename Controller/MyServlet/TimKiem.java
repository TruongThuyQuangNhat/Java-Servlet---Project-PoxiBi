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

import bean.Anh;
import bean.Loai;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Bookmarkbo;
import bo.CategoriesAnhbo;
import bo.Commentbo;
import bo.Loaibo;

/**
 * Servlet implementation class TimKiem
 */
@WebServlet("/TimKiem")
public class TimKiem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiem() {
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
			String key = request.getParameter("key");
			
			Anhbo abo = new Anhbo();
			ArrayList<Anh> dsap = new ArrayList<Anh>();
			String tam = request.getParameter("Page");
			if(tam != null) {
				int Page = Integer.parseInt(tam);
				dsap = abo.getDSAnhPageTimKiem(Page, key);
				request.setAttribute("sPage", Page); // Khi Số page thay đổi, thì cập nhật lại
			} else {
				request.setAttribute("sPage", 1); // Số Page mặc định là 1
				dsap = abo.getDSAnhPageTimKiem(1, key);
			}
	        request.setAttribute("dsap", dsap);
	        request.setAttribute("key", key);
	        
	        int count = abo.getSLAnhTimKiem(key);
	        int endPage = count/9;
	        if(count % 9 != 0) {
	        	endPage++;
	        }
	        request.setAttribute("endPage", endPage);
	        
	        
	        Loaibo lbo = new Loaibo();
	        request.setAttribute("lbo", lbo);
			ArrayList<Loai> dsl = lbo.getDSLoai();
	        request.setAttribute("dsl", dsl);
			
	        CategoriesAnhbo cabo = new CategoriesAnhbo();
	        request.setAttribute("cabo", cabo);
	        
	        Commentbo cmbo = new Commentbo();
	        request.setAttribute("cmbo", cmbo);
	        
	        AnhDuocLikebo adlbo = new AnhDuocLikebo();
	        request.setAttribute("adlbo", adlbo);
	        
	        Bookmarkbo bmbo = new Bookmarkbo();
	        request.setAttribute("bmbo", bmbo);
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("TimKiem.jsp");
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
