package MyServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.CategoriesAnhbo;

/**
 * Servlet implementation class EditCategoriesAnh
 */
@WebServlet("/EditCategoriesAnh")
public class EditCategoriesAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoriesAnh() {
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
			String ml = request.getParameter("maloai");
			
			Long maanh = Long.parseLong(ma);
			Long maloai = Long.parseLong(ml);
			
			CategoriesAnhbo cbo = new CategoriesAnhbo();
			if(cbo.KiemTraTonTai(maloai, maanh) != null) {
				//đã tồn tại, cần phải xóa
				cbo.Xoa(maloai, maanh);
			} else {
				// chưa tồn tại, thêm mới vào
				cbo.Them(maloai, maanh);
			}
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
