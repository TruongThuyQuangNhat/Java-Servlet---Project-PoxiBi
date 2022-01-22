package bo;

import java.util.ArrayList;

import bean.Bookmark;
import dao.Bookmarkdao;

public class Bookmarkbo {
	Bookmarkdao dao = new Bookmarkdao();
	public void ThemBookmark(Long mauser, Long maanh) throws Exception{
		dao.ThemBookmark(mauser, maanh);
	}
	public void XoaBookmark(Long mauser, Long maanh) throws Exception{
		dao.XoaBookmark(mauser, maanh);
	}
	public Bookmark KiemTraBookmark(Long mauser, Long maanh) throws Exception{
		return dao.KiemTraBookmark(mauser, maanh);
	}
	public ArrayList<Bookmark> getDSBM(Long mauser) throws Exception{
		return dao.getDSBM(mauser);
	}
	public void XoaBMTheoMaanh(Long maanh) throws Exception{
		dao.XoaBMTheoMaanh(maanh);
	}
	public void XoaBMTheoMauser(Long mauser) throws Exception{
		dao.XoaBMTheoMauser(mauser);
	}
}
