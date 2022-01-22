package bo;

import java.util.ArrayList;

import bean.Follow;
import dao.Followdao;

public class Followbo {
	Followdao dao = new Followdao();
	ArrayList<Follow> ds = new ArrayList<Follow>();
	
	public ArrayList<Follow> getDSFollow() throws Exception{
		return dao.getDSFollow();
	}
	public void ThemFollow(Long mauser, Long mauserfollow) throws Exception{
		dao.ThemFollow(mauser, mauserfollow);
	}
	public void XoaFollow(Long mauser, Long mauserfollow) throws Exception{
		dao.XoaFollow(mauser, mauserfollow);
	}
	public int DemFollow(Long mauser) throws Exception{
		return dao.DemFollow(mauser);
	}
	public Follow KiemTraFollow(Long mauser, Long mauserfollow) throws Exception{
		return dao.KiemTraFollow(mauser, mauserfollow);
	}
	public void XoaFollowTheoMauser(Long mauser) throws Exception{
		dao.XoaFollowTheoMauser(mauser);
	}
}
