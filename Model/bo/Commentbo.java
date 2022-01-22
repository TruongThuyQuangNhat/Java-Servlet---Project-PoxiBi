package bo;

import java.util.ArrayList;

import bean.Comment;
import dao.Commentdao;

public class Commentbo {
	Commentdao dao = new Commentdao();
	ArrayList<Comment> ds = new ArrayList<Comment>();
	
	public ArrayList<Comment> getDSComment(Long maanh) throws Exception{
		return dao.getDSComment(maanh);
	}
	public int getSLCommentTheoMaAnh(Long maanh) throws Exception{
		return dao.getSLCommentTheoMaAnh(maanh);
	}
	public void ThemComment(Long maanh, Long mauser, String noidung)  throws Exception{
		dao.ThemComment(maanh, mauser, noidung);
	}
	public ArrayList<Comment> DaoNguoc(ArrayList<Comment> list) {

		   for (int i = 0; i < list.size() / 2; i++) {
			   Comment temp = list.get(i);
		     list.set(i, list.get(list.size() - i - 1));
		     list.set(list.size() - i - 1, temp);
		   }

		   return list;
		 }
	public void XoaComment(Long macomment)  throws Exception{
		dao.XoaComment(macomment);
	}
	public void EditComment(Long macomment,  String comment)  throws Exception{
		dao.EditComment(macomment, comment);
	}
	public int getThoiGianSECOND(Long macomment) throws Exception{
		return dao.getThoiGianSECOND(macomment);
	}
	public int getThoiGianMINUTE(Long macomment) throws Exception{
		return dao.getThoiGianMINUTE(macomment);
	}
	public int getThoiGianHOUR(Long macomment) throws Exception{
		return dao.getThoiGianHOUR(macomment);
	}
	public int getThoiGianDAY(Long macomment) throws Exception{
		return dao.getThoiGianDAY(macomment);
	}
	public int getThoiGianMONTH(Long macomment) throws Exception{
		return dao.getThoiGianMONTH(macomment);
	}
	public int getThoiGianYEAR(Long macomment) throws Exception{
		return dao.getThoiGianYEAR(macomment);
	}
	public ArrayList<Long> getDSCommentTheoMauser(Long mauser) throws Exception{
		return dao.getDSCommentTheoMauser(mauser);
	}
	public void XoaCommentTheoMaanh(Long maanh) throws Exception{
		dao.XoaCommentTheoMaanh(maanh);
	}
	public void XoaCommentTheoMauser(Long mauser) throws Exception{
		dao.XoaCommentTheoMauser(mauser);
	}
	public ArrayList<Long> getDSMaanhComment() throws Exception{
		return dao.getDSMaanhComment();
	}
}
