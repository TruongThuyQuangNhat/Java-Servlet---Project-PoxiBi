package bo;

import java.util.ArrayList;

import bean.AnhDuocLike;
import dao.AnhDuocLikedao;

public class AnhDuocLikebo {
	AnhDuocLikedao dao = new AnhDuocLikedao();
	
	public AnhDuocLike KiemTraAnhDuocLike(Long mauser, Long maanh) throws Exception{
		return dao.KiemTraAnhDuocLike(mauser, maanh);
	}
	public void ThemAnhDuocLike(Long mauser, Long maanh) throws Exception{
		dao.ThemAnhDuocLike(mauser, maanh);
	}
	public void XoaAnhDuocLike(Long mauser, Long maanh) throws Exception{
		dao.XoaAnhDuocLike(mauser, maanh);
	}
	public ArrayList<AnhDuocLike> getDSADL(Long mauser) throws Exception{
		return dao.getDSADL(mauser);
	}
	public void XoaAnhDuocLikeTheoMaanh(Long maanh) throws Exception{
		dao.XoaAnhDuocLikeTheoMaanh(maanh);
	}
	public void XoaAnhDuocLikeTheoMauser(Long mauser) throws Exception{
		dao.XoaAnhDuocLikeTheoMauser(mauser);
	}
}
