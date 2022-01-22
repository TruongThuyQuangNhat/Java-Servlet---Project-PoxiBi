package MyServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import bean.Comment;
import bean.User;
import bo.Commentbo;
import bo.Userbo;

/**
 * Servlet implementation class HienThiComment
 */
@WebServlet("/HienThiComment")
public class HienThiComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HienThiComment() {
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
			HttpSession session=request.getSession();
			String ma = request.getParameter("maanh");
			
			Long maanh = Long.parseLong(ma);
			User us = (User) session.getAttribute("u");
			Long iduser = us.getMauser();
			
			Userbo ubo = new Userbo();
			
			Commentbo cmbo = new Commentbo();
			ArrayList<Comment> ds = cmbo.getDSComment(maanh);
			ArrayList<Comment> dscm = cmbo.DaoNguoc(ds);
			
			for(Comment cm: dscm) {
				User u = ubo.getUserTheoMaUser(cm.getMauser());
				int time = 0;
				String donvi = "thiếu thông tin.";
				if(cmbo.getThoiGianSECOND(cm.getMacomment()) > 60) {
					if(cmbo.getThoiGianMINUTE(cm.getMacomment()) > 60) {
						if(cmbo.getThoiGianHOUR(cm.getMacomment()) > 24) {
							if(cmbo.getThoiGianDAY(cm.getMacomment()) > 31) {
								if(cmbo.getThoiGianMONTH(cm.getMacomment()) > 12) {
									if(cmbo.getThoiGianYEAR(cm.getMacomment()) > 0) {
										time = cmbo.getThoiGianYEAR(cm.getMacomment());
										donvi = " năm trước.";
									}
								} else {
									time = cmbo.getThoiGianMONTH(cm.getMacomment());
									donvi = " tháng trước.";
								}
							} else {
								time = cmbo.getThoiGianDAY(cm.getMacomment());
								donvi = " ngày trước.";
							}
						} else {
							time = cmbo.getThoiGianHOUR(cm.getMacomment());
							donvi = " giờ trước.";
						}
					} else {
						time = cmbo.getThoiGianMINUTE(cm.getMacomment());
						donvi = " phút trước.";
					}
				} else {
					time = cmbo.getThoiGianSECOND(cm.getMacomment());
					donvi = " giây trước.";
				}
				if(u.getMauser() == iduser) {
				out.println("<hr> <table >\r\n"
						+ "    <tbody>\r\n"
						+ "      <tr>\r\n"
						+ "        <td><image class=\"rounded-circle\" style=\"height:50px; width:50px\" src=\""+u.getAnhuser()+"\"></td>\r\n"
						+ "        <td>&nbsp;&nbsp;"+u.getTenuser()+" | "+time+donvi+"</td>\r\n"
						+ "      </tr>\r\n"
						+ "      <tr>\r\n"
						+ "      	<td></td>\r\n"
						+ "        <td>&nbsp;&nbsp;"+cm.getNoidung()+"&nbsp;&nbsp; <a onclick=\"deletecm("+cm.getMacomment()+")\" type=\"button\" class=\"btn btn-danger\">Xóa</a>"
						+ "				<a type=\"button\" class=\"btn btn-info\" onclick=\"editcm("+cm.getMacomment()+")\">Edit</a></td>\r\n"
						+ "      </tr>\r\n"
						+ "    </tbody>\r\n"
						+ "  </table>\r\n"
						+ "<div class=\"container\">\r\n"
						+ "		<div class=\"modal fade\" id=\"myModalcm"+cm.getMacomment()+"\" role=\"dialog\">\r\n"
						+ "			<div class=\"modal-dialog\">\r\n"
						+ "				<!-- Modal content-->\r\n"
						+ "				<div class=\"modal-content\">\r\n"
						+ "					<div class=\"modal-header\">\r\n"
						+ "						<h4 class=\"modal-title\">Chỉnh sửa comment</h4>\r\n"
						+ "						<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
						+ "					</div>\r\n"
						+ "					<div class=\"modal-body\">\r\n"
						+ "							<div class=\"form-group\">\r\n"
						+ "								<label for=\"email\">Nội dung:</label> <textarea \r\n"
						+ "									class=\"form-control\" id=\"noidungcm_"+cm.getMacomment()+"\" name=\"noidungcm_"+cm.getMacomment()+"\">"+cm.getNoidung()+"</textarea>\r\n"
						+ "							</div>\r\n"
						+ "								<br>\r\n"
						+ "					</div>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>");
//				out.println("<image class=\"rounded-circle\" style=\"height:50px; width:50px\" src=\""+u.getAnhuser()+"\">\r\n"
//						+ "					<p>"+cm.getNoidung()+"</p>\r\n"
//						+ "					<a class=\"btn btn-danger\" type=\"button\" style=\"margin-left: 10px\">Xóa</a>");
				} else {
					out.println("<hr> <table >\r\n"
							+ "    <tbody>\r\n"
							+ "      <tr>\r\n"
							+ "        <td><image class=\"rounded-circle\" style=\"height:50px; width:50px\" src=\""+u.getAnhuser()+"\"></td>\r\n"
							+ "        <td>&nbsp;&nbsp;"+u.getTenuser()+" | "+time+donvi+"</td>\r\n"
							+ "      </tr>\r\n"
							+ "      <tr>\r\n"
							+ "      	<td></td>\r\n"
							+ "        <td>&nbsp;&nbsp;"+cm.getNoidung()+"</td>\r\n"
							+ "      </tr>\r\n"
							+ "    </tbody>\r\n"
							+ "  </table>");
				}
			}
			
		}catch (Exception e) {
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
