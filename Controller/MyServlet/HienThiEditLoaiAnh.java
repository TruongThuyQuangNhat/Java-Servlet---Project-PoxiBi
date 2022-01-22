package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.CategoriesAnh;
import bean.Loai;
import bo.Anhbo;
import bo.CategoriesAnhbo;
import bo.Loaibo;

/**
 * Servlet implementation class HienThiEditLoaiAnh
 */
@WebServlet("/HienThiEditLoaiAnh")
public class HienThiEditLoaiAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiEditLoaiAnh() {
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
			Long maanh = Long.parseLong(ma);
			Loaibo lbo = new Loaibo();
			
			CategoriesAnhbo cabo = new CategoriesAnhbo();
			ArrayList<Long> ds = cabo.getDSLoaiTheoMaAnhKieuLong(maanh);
			ArrayList<Long> dsall = lbo.getAllMaLoai();
			
			dsall.removeAll(ds);
			
			for(Long a: ds) {
				out.println("<button type=\"button\" onclick=\"ChangeLoai("+maanh+","+a+")\" class=\"btn btn-success\">"+lbo.getTenLoaiTheoMaLoai(a)+"</button>");
			}
			out.println("<hr>");
			for(Long a: dsall) {
				out.println("<button type=\"button\" onclick=\"ChangeLoai("+maanh+","+a+")\" class=\"btn btn-light\">"+lbo.getTenLoaiTheoMaLoai(a)+"</button>");
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
