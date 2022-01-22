package MyServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Anh;
import bean.AnhDuocLike;
import bean.User;
import bo.AnhDuocLikebo;
import bo.Anhbo;
import bo.Bookmarkbo;
import bo.CategoriesAnhbo;
import bo.CategoriesUserbo;
import bo.Commentbo;
import bo.Followbo;
import bo.Userbo;

/**
 * Servlet implementation class AdminXoaUser
 */
@WebServlet("/AdminXoaUser")
public class AdminXoaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminXoaUser() {
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
			
			String mu = request.getParameter("mauser");
			Long mauser = Long.parseLong(mu);
			
			CategoriesUserbo caubo = new CategoriesUserbo();
			caubo.XoaCategoriesUser(mauser);
			
			Bookmarkbo bmbo = new Bookmarkbo();
			bmbo.XoaBMTheoMauser(mauser);
			
			AnhDuocLikebo adlbo = new AnhDuocLikebo();
			ArrayList<AnhDuocLike> dsadl = adlbo.getDSADL(mauser);
			Anhbo abo = new Anhbo();
			ArrayList<Anh> dsa = abo.getDSAnh(); 
			for(AnhDuocLike a: dsadl) {
				for(Anh b: dsa) {
					if(a.getMaanh() == b.getMaanh()) {
						abo.UpdateGiamLuotlike(b.getMaanh());
					}
				}
			}
			adlbo.XoaAnhDuocLikeTheoMauser(mauser);
			
			Followbo flbo = new Followbo();
			flbo.XoaFollowTheoMauser(mauser);
			
			Commentbo cmbo = new Commentbo();
			cmbo.XoaCommentTheoMauser(mauser);
			
			ArrayList<Anh> dsa2 = abo.getDSAnhTheoMauser(mauser);
			for(Anh anh: dsa2) {
				// xoa file anh
				String dirUrl = request.getServletContext().getRealPath("") + File.separator + anh.getTenanh();
				File myObj = new File(dirUrl);
				if (myObj.delete()) {
					System.out.println("Deleted image the file: " + myObj.getName());
				} else {
					System.out.println("Failed to delete the file.");
				}
				cmbo.XoaCommentTheoMaanh(anh.getMaanh());

				CategoriesAnhbo ca = new CategoriesAnhbo();
				ca.XoaCTGRAnh(anh.getMaanh());

				bmbo.XoaBMTheoMaanh(anh.getMaanh());

				adlbo.XoaAnhDuocLikeTheoMaanh(anh.getMaanh());
				
				abo.XoaAnh(anh.getMaanh());
			}
			
			Userbo ubo = new Userbo();
			//Xóa ảnh avatar
			User u = ubo.getUserTheoMaUser(mauser);
			if(u.getAnhuser().equals("image_user\\user.jpg")) {
				// no thing
			} else {
				String dirUrl = request.getServletContext().getRealPath("") + File.separator + u.getAnhuser();
				File myObj = new File(dirUrl);
				if (myObj.delete()) {
					System.out.println("Deleted user the file: " + myObj.getName());
				} else {
					System.out.println("Failed to delete the file.");
				}
			}
			//Chốt
			ubo.XoaUserTheoMauser(mauser);
			
			//làm để có data trả về, data này ko quan trọng
			out.println(u);
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
