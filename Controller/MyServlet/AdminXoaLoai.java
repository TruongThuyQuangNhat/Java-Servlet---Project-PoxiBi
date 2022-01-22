package MyServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategoriesAnhbo;
import bo.CategoriesUserbo;
import bo.Loaibo;

/**
 * Servlet implementation class AdminXoaLoai
 */
@WebServlet("/AdminXoaLoai")
public class AdminXoaLoai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXoaLoai() {
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
			
			Loaibo lbo = new Loaibo();
			CategoriesAnhbo cabo = new CategoriesAnhbo();
			cabo.XoaCTGRAnhTheoMaLoai(maloai);
			CategoriesUserbo cubo = new CategoriesUserbo();
			cubo.XoaCategoriesUserTheoMaLoai(maloai);
			
			lbo.XoaLoai(maloai);
			
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
