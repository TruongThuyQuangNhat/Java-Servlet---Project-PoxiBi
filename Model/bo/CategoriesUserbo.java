package bo;

import java.util.ArrayList;

import bean.CategoriesUser;
import dao.CategoriesUserdao;

public class CategoriesUserbo {
	CategoriesUserdao dao = new CategoriesUserdao();
	ArrayList<CategoriesUser> ds = new ArrayList<CategoriesUser>();
	
	public ArrayList<CategoriesUser> getDSCategoriesUser() throws Exception{
		return dao.getDSCategoriesUser();
	}
	public void XoaCategoriesUser(Long mauser) throws Exception{
		dao.XoaCategoriesUser(mauser);
	}
	public void XoaCategoriesUserTheoMaLoai(Long maloai) throws Exception{
		dao.XoaCategoriesUserTheoMaLoai(maloai);
	}
}
