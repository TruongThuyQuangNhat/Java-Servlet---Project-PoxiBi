package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bo.Userbo;

/**
 * Servlet implementation class AdminHienThiUser
 */
@WebServlet("/AdminHienThiUser")
public class AdminHienThiUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHienThiUser() {
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
			
			Userbo ubo = new Userbo();
			ArrayList<User> ds = ubo.getDSUser();
			for(User u: ds) {
				if(u.getQuyen()) {
					if(u.getMauser() == 1 && u.getTenuser().equals("admin")) {
						out.println("<div class=\"col mb-4\">\r\n"
								+ "    		<div class=\"card-body\">\r\n"
								+ "      		<table>\r\n"
								+ "      			<tr>\r\n"
								+ "					<td rowspan=\"2\">\r\n"
								+ "						<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">\r\n"
								+ "							<image class=\"rounded-circle\" style=\"height:70px; width:70px\" \r\n"
								+ "								src=\""+u.getAnhuser()+"\">\r\n"
								+ "						</a>\r\n"
								+ "					</td>\r\n"
								+ "					<td><h5>&nbsp;&nbsp;<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">"+u.getTenuser()+"</a></h5></td>\r\n"
								+ "				</tr>\r\n"
								+ "				<tr>\r\n"
								+ "					<td>\r\n"
								+ "						&nbsp;&nbsp;<button disabled class=\"btn btn-danger\">Xóa</button>&nbsp;\r\n"
								+ "						<button  disabled class=\"btn btn-success\">Là Admin</button>\r\n"
								+ "					</td>\r\n"
								+ "				</tr>\r\n"
								+ "      		</table>\r\n"
								+ "    		</div>\r\n"
								+ "  		</div>");
					} else {
			out.println("<div class=\"col mb-4\">\r\n"
					+ "    		<div class=\"card-body\">\r\n"
					+ "      		<table>\r\n"
					+ "      			<tr>\r\n"
					+ "					<td rowspan=\"2\">\r\n"
					+ "						<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">\r\n"
					+ "							<image class=\"rounded-circle\" style=\"height:70px; width:70px\" \r\n"
					+ "								src=\""+u.getAnhuser()+"\">\r\n"
					+ "						</a>\r\n"
					+ "					</td>\r\n"
					+ "					<td><h5>&nbsp;&nbsp;<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">"+u.getTenuser()+"</a></h5></td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr>\r\n"
					+ "					<td>\r\n"
					+ "						&nbsp;&nbsp;<a onclick=\"XoaUser("+u.getMauser()+")\" type=\"button\" class=\"btn btn-danger\">Xóa</a>\r\n"
					+ "						<a href=\"#\" onclick=\"changeadmin(this,"+u.getMauser()+")\" type=\"button\" class=\"btn btn-success\">Là Admin</a>\r\n"
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "      		</table>\r\n"
					+ "    		</div>\r\n"
					+ "  		</div>");
					}
				} else {
					out.println("<div class=\"col mb-4\">\r\n"
							+ "    		<div class=\"card-body\">\r\n"
							+ "      		<table>\r\n"
							+ "      			<tr>\r\n"
							+ "					<td rowspan=\"2\">\r\n"
							+ "						<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">\r\n"
							+ "							<image class=\"rounded-circle\" style=\"height:70px; width:70px\" \r\n"
							+ "								src=\""+u.getAnhuser()+"\">\r\n"
							+ "						</a>\r\n"
							+ "					</td>\r\n"
							+ "					<td><h5>&nbsp;&nbsp;<a href=\"TrangCaNhan?mauser="+u.getMauser()+"&tab=dang\">"+u.getTenuser()+"</a></h5></td>\r\n"
							+ "				</tr>\r\n"
							+ "				<tr>\r\n"
							+ "					<td>\r\n"
							+ "						&nbsp;&nbsp;<a onclick=\"XoaUser("+u.getMauser()+")\" type=\"button\" class=\"btn btn-danger\">Xóa</a>\r\n"
							+ "						<a href=\"#\" onclick=\"changeadmin(this,"+u.getMauser()+")\" type=\"button\" class=\"btn btn-success\">Không Là Admin</a>\r\n"
							+ "					</td>\r\n"
							+ "				</tr>\r\n"
							+ "      		</table>\r\n"
							+ "    		</div>\r\n"
							+ "  		</div>");
				}
			}
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
