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
import bean.CategoriesAnh;
import bean.Loai;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Bookmarkbo;
import bo.CategoriesAnhbo;
import bo.Commentbo;
import bo.Loaibo;

/**
 * Servlet implementation class TimKiemAnh
 */
@WebServlet("/TimKiemAnh")
public class TimKiemAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemAnh() {
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
			
			String ml = request.getParameter("maloai");
			Long maloai = Long.parseLong(ml);
			
			
			Anhbo abo = new Anhbo();
			CategoriesAnhbo cabo = new CategoriesAnhbo();
			 request.setAttribute("cabo", cabo);
			 
			ArrayList<Anh> dsa = abo.getDSAnh();
			ArrayList<Anh> dsap = new ArrayList<Anh>(); // ds chính
			String tam = request.getParameter("Page");
			if(tam != null) {
				int Page = Integer.parseInt(tam);
				ArrayList<CategoriesAnh> dsca = cabo.get_CTGRA_TheoMaLoai(maloai, Page-1);
				for(CategoriesAnh ca: dsca) {
					for(Anh a: dsa) {
						if(ca.getMaanh() == a.getMaanh()) {
							dsap.add(a);
						}
					}
				}
				request.setAttribute("sPage", Page); // Khi Số page thay đổi, thì cập nhật lại
			} else {
				request.setAttribute("sPage", 1); // Số Page mặc định là 1
				ArrayList<CategoriesAnh> dsca = cabo.get_CTGRA_TheoMaLoai(maloai, 0);
				for(CategoriesAnh ca: dsca) {
					for(Anh a: dsa) {
						if(ca.getMaanh() == a.getMaanh()) {
							dsap.add(a);
						}
					}
				}
			}
	        request.setAttribute("dsap", dsap);
	        
	        int count = cabo.getSL(maloai);
	        int endPage = count/9;
	        if(count % 9 != 0) {
	        	endPage++;
	        }
	        request.setAttribute("endPage", endPage);
	        
	        
	        Loaibo lbo = new Loaibo();
	        request.setAttribute("lbo", lbo);
			ArrayList<Loai> dsl = lbo.getDSLoai();
	        request.setAttribute("dsl", dsl);
			
	        
	        Commentbo cmbo = new Commentbo();
	        request.setAttribute("cmbo", cmbo);
	        
	        AnhDuocLikebo adlbo = new AnhDuocLikebo();
	        request.setAttribute("adlbo", adlbo);
	        
	        Bookmarkbo bmbo = new Bookmarkbo();
	        request.setAttribute("bmbo", bmbo);
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
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
