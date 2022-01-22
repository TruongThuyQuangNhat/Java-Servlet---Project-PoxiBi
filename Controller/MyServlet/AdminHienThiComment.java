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
import bean.Comment;
import bean.User;
import bo.Anhbo;
import bo.Commentbo;
import bo.Userbo;

/**
 * Servlet implementation class AdminHienThiComment
 */
@WebServlet("/AdminHienThiComment")
public class AdminHienThiComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHienThiComment() {
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
			
			
			Anhbo abo = new Anhbo();
			ArrayList<Anh> ds = abo.getDSAnh();
			ArrayList<Anh> ds2 = new ArrayList<Anh>();
			
			Commentbo cmbo = new Commentbo();
			ArrayList<Long> dsmaanh = cmbo.getDSMaanhComment();
			
			for(Anh a: ds) {
				for(Long ma: dsmaanh) {
					if(ma == a.getMaanh()) {
						ds2.add(a);
					}
				}
			}
			
			Userbo ubo = new Userbo();
			
			for(Anh a: ds2) {
				ArrayList<Comment> dscm = cmbo.getDSComment(a.getMaanh());
				out.println("<div class=\"card\">\r\n"
						+ "    <img src=\""+a.getTenanh()+"\" class=\"card-img-top\" alt=\"image\">\r\n"
						+ "    <div class=\"card-body\">\r\n"
						+ "      <a href=\"XemThongTinAnh?maanh="+a.getMaanh()+"\"><h5 class=\"card-title\">"+a.getTieude()+"</h5></a>\r\n"
						+ "    </div>\r\n");
						for(Comment cm : dscm) {
							User tam = ubo.getUserTheoMaUser(cm.getMauser());
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
							out.println("  <div class=\"card-footer\">\r\n"
									+ "<table >\r\n"
									+ "    <tbody>\r\n"
									+ "      <tr>\r\n"
									+ "        <td><image class=\"rounded-circle\" style=\"height:50px; width:50px\" src=\""+tam.getAnhuser()+"\"></td>\r\n"
									+ "        <td>&nbsp;&nbsp;"+tam.getTenuser()+" | "+time+donvi+"</td>\r\n"
									+ "      </tr>\r\n"
									+ "      <tr>\r\n"
									+ "      	<td></td>\r\n"
									+ "        <td>&nbsp;&nbsp;"+cm.getNoidung()+"&nbsp;&nbsp;| <a onclick=\"XoaComment("+cm.getMacomment()+")\" type=\"button\" class=\"btn btn-danger\">Xóa</a>\r\n"
									
									+ "      </tr>\r\n"
									+ "    </tbody>\r\n"
									+ "  </table>\r\n"
									
									+ "    </div>\r\n");
						}
						out.println("  </div><br><br><br>");
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
