package MyServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.AnhDuocLike;
import bean.Bookmark;
import bean.Comment;
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
 * Servlet implementation class TrangCaNhan
 */
@WebServlet("/TrangCaNhan")
public class TrangCaNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrangCaNhan() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mu = request.getParameter("mauser");
			String tab = request.getParameter("tab");
			Long mauser = Long.parseLong(mu);
			
			Userbo ubo = new Userbo();
			User boss = ubo.getUserTheoMaUser(mauser);
			request.setAttribute("boss", boss);
			
			Anhbo abo = new Anhbo();
			
			AnhDuocLikebo adlbo = new AnhDuocLikebo();
	        request.setAttribute("adlbo", adlbo);
	        
	        Bookmarkbo bmbo = new Bookmarkbo();
	        request.setAttribute("bmbo", bmbo);
	        
	        CategoriesAnhbo cabo = new CategoriesAnhbo();
	        request.setAttribute("cabo", cabo);
	        
	        Loaibo lbo = new Loaibo();
	        request.setAttribute("lbo", lbo);
	        
	        Commentbo cmbo = new Commentbo();
	        request.setAttribute("cmbo", cmbo);
	        
	        Followbo flbo = new Followbo();
	        request.setAttribute("flbo", flbo);
	        
	        ArrayList<Anh> dsa = abo.getDSAnh();
	        ArrayList<Anh> dsanew;
	        
	        if(tab.equals("dang")) {
	        	dsanew = abo.getDSAnhTheoMauser(mauser);
	        } else if(tab.equals("luu")) {
	        	ArrayList<Bookmark> ds = bmbo.getDSBM(mauser);
		        dsanew = new ArrayList<Anh>();
		        for(Bookmark b: ds) {
		        	for(Anh a: dsa) {
		        		if(b.getMaanh() == a.getMaanh()) {
		        			dsanew.add(a);
		        		}
		        	}
		        }
	        }  else if(tab.equals("like")) {
	        	ArrayList<AnhDuocLike> dslike = adlbo.getDSADL(mauser);
		        dsanew = new ArrayList<Anh>();
		        for(AnhDuocLike b: dslike) {
		        	for(Anh a: dsa) {
		        		if(b.getMaanh() == a.getMaanh()) {
		        			dsanew.add(a);
		        		}
		        	}
		        }
	        } else if(tab.equals("comment")) {
	        	ArrayList<Long> dscm = cmbo.getDSCommentTheoMauser(mauser);
		        dsanew = new ArrayList<Anh>();
		        for(Long b: dscm) {
		        	for(Anh a: dsa) {
		        		if(b == a.getMaanh()) {
		        			dsanew.add(a);
		        		}
		        	}
		        }
	        } else {
	        	dsanew = null;
	        }
	        request.setAttribute("tab", tab);
			request.setAttribute("dsanew", dsanew);
	        
	    
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("TrangCaNhan.jsp");
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
