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
import bo.Anhbo;
import bo.CategoriesAnhbo;
import bo.Loaibo;

/**
 * Servlet implementation class GetDSNext9Anh
 */
@WebServlet("/GetDSNext9Anh")
public class GetDSNext9Anh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDSNext9Anh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String amount = request.getParameter("exits");
			PrintWriter out= response.getWriter();
			
			Long lamount = Long.parseLong(amount);
			
			Anhbo abo = new Anhbo();
			Loaibo lbo = new Loaibo();
			CategoriesAnhbo cabo = new CategoriesAnhbo();
			ArrayList<Anh> dsan9 = abo.getDSAnhNext9(lamount);
			for(Anh ds: dsan9) {
				out.println("<div class=\"col mb-4\">"
						+ "<div id=\"content\" class=\"card anh\">\r\n"
						+ "				<a href=\""+ ds.getTenanh() +"\"> <img src=\""+ ds.getTenanh()+"\"\r\n"
						+ "					alt=\"Avatar\" class=\"image\" style=\"width: 100%\">\r\n"
						+ "				</a>\r\n"
						+ "				<div class=\"middle\">\r\n"
						+ "					<div class=\"text\">\r\n"
						+ "						<c:forEach var=\"ca\" items=\""+cabo.getDSLoaiTheoMaAnh(ds.getMaanh())+"\">\r\n"
//						+ "							<button>"+lbo.getTenLoaiTheoMaLoai((cabo.getDSLoaiTheoMaAnh(ds.getMaanh())).next().getMaloai()) +"/button>\r\n"
						+ "						</c:forEach>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "				<div class=\"middle2\">\r\n"
						+ "					<div class=\"text\">\r\n"
						+ "						<p class=\"text-white bg-dark\">\r\n"
						+ "							<a href=\"https://google.com\" class=\"text-white bg-dark\"><i\r\n"
						+ "								class=\"far fa-heart\"></i>"+ds.getLuotlike()+" </a>-- <a\r\n"
						+ "								href=\"https://google.com\" class=\"text-white bg-dark\"><i\r\n"
						+ "								class=\"far fa-comments\"></i> 2</a>-- <a href=\"https://google.com\"\r\n"
						+ "								class=\"text-white bg-dark\"><i class=\"far fa-bookmark\"></i> </a>\r\n"
						+ "						</p>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
