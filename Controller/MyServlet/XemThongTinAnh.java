package MyServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Anh;
import bean.CategoriesAnh;
import bean.User;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Bookmarkbo;
import bo.CategoriesAnhbo;
import bo.Commentbo;
import bo.Followbo;
import bo.Loaibo;
import bo.Userbo;

/**
 * Servlet implementation class XemThongTinAnh
 */
@WebServlet("/XemThongTinAnh")
public class XemThongTinAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemThongTinAnh() {
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
			
			String ma = request.getParameter("maanh");
			
			Long maanh = Long.parseLong(ma);
			Anhbo abo = new Anhbo();
			Anh anh = abo.getAnhTheoMaAnh(maanh);
			request.setAttribute("anh", anh);
			
			Userbo ubo = new Userbo();
			User boss = ubo.getUserTheoMaUser(anh.getMauser());
			request.setAttribute("boss", boss);
			
			int soluong = abo.getSoLuongAnhTheoMaUser(boss.getMauser());
			request.setAttribute("soluong", soluong);
			
			CategoriesAnhbo cabo = new CategoriesAnhbo();
			ArrayList<CategoriesAnh> dsl = cabo.getDSLoaiTheoMaAnh(maanh);
			request.setAttribute("dsl", dsl);
			
			Loaibo lbo = new Loaibo();
	        request.setAttribute("lbo", lbo);
	        
	        AnhDuocLikebo adlbo = new AnhDuocLikebo();
	        request.setAttribute("adlbo", adlbo);
	        
	        Bookmarkbo bmbo = new Bookmarkbo();
	        request.setAttribute("bmbo", bmbo);
	        
	        Followbo flbo = new Followbo();
	        request.setAttribute("flbo", flbo);
	        
	        CategoriesAnh cta = cabo.get1CTGRATheoMaAnh(maanh);
	        ArrayList<CategoriesAnh> ds5ctgra = cabo.get_5_CTGRA_TheoMaAnhVaMaLoai(maanh, cta.getMaloai());
	        ArrayList<Anh> ds5a = new ArrayList<Anh>();
	        for(CategoriesAnh a: ds5ctgra) {
	        	ds5a.add(abo.getAnhTheoMaAnh(a.getMaanh()));
	        }
	        request.setAttribute("ds5a", ds5a);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("XemThongTinAnh.jsp");
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
