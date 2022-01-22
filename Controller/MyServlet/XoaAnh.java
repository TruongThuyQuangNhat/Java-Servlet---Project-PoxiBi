package MyServlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.CategoriesAnh;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Bookmarkbo;
import bo.CategoriesAnhbo;
import bo.Commentbo;

/**
 * Servlet implementation class XoaAnh
 */
@WebServlet("/XoaAnh")
public class XoaAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaAnh() {
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
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

			String ma = request.getParameter("maanh");
			Long maanh = Long.parseLong(ma);
			Anhbo abo = new Anhbo();
			
			// xoa file anh
			Anh anh = abo.getAnhTheoMaAnh(maanh);
			String dirUrl = request.getServletContext().getRealPath("") + File.separator + anh.getTenanh();
			File myObj = new File(dirUrl);
			if (myObj.delete()) {
				System.out.println("edit anh nang cao Deleted the file: " + myObj.getName());
			} else {
				System.out.println("edit anh nang cao Failed to delete the file.");
			}

			Commentbo cmbo = new Commentbo();
			cmbo.XoaCommentTheoMaanh(maanh);

			CategoriesAnhbo ca = new CategoriesAnhbo();
			ca.XoaCTGRAnh(maanh);

			Bookmarkbo bmbo = new Bookmarkbo();
			bmbo.XoaBMTheoMaanh(maanh);

			AnhDuocLikebo adl = new AnhDuocLikebo();
			adl.XoaAnhDuocLikeTheoMaanh(maanh);
			
			abo.XoaAnh(maanh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
