package bo;

import java.util.ArrayList;

import bean.Anh;
import dao.Anhdao;

public class Anhbo {
	Anhdao dao = new Anhdao();
	ArrayList<Anh> ds = new ArrayList<Anh>();
	
	public ArrayList<Anh> getDSAnh() throws Exception{
		return dao.getDSAnh();
	}
	public ArrayList<Anh> getDSAnhPage(int index) throws Exception{
		return dao.getDSAnhPage(index);
	}
	public ArrayList<Anh> getDSAnhPageTimKiem(int index, String key) throws Exception{
		return dao.getDSAnhPageTimKiem(index, key);
	}
	public ArrayList<Anh> getDSAnhTimKiem(String key) throws Exception{
		return dao.getDSAnhTimKiem(key);
	}
	public int getSLAnhTimKiem(String key) throws Exception{
		return dao.getSLAnhTimKiem(key);
	}
	public ArrayList<Anh> getDSAnhNext9(Long maanh) throws Exception{
		return dao.getDSAnhNext9(maanh);
	}
	public ArrayList<Anh> getDSAnhTop9() throws Exception{
		return dao.getDSAnhTop9();
	}
	public int getSLAnh() throws Exception{
		return dao.getSLAnh();
	}
	public void UpdateTangLuotlike(Long maanh) throws Exception{
		dao.UpdateTangLuotlike(maanh);
	}
	public void UpdateGiamLuotlike(Long maanh) throws Exception{
		dao.UpdateGiamLuotlike(maanh);
	}
	public Anh getAnhTheoMaAnh(Long maanh) throws Exception{
		return dao.getAnhTheoMaAnh(maanh);
	}
	public int getSoLuongAnhTheoMaUser(Long mauser) throws Exception{
		return dao.getSoLuongAnhTheoMaUser(mauser);
	}
	public ArrayList<Anh> getDSAnhTheoMauser(Long mauser) throws Exception{
		return dao.getDSAnhTheoMauser(mauser);
	}
	public void EditName(Long maanh, String name) throws Exception{
		dao.EditName(maanh, name);
	}
	public void XoaAnh(Long maanh) throws Exception{
		dao.XoaAnh(maanh);
	}
	public void ThemAnhMoi(String anh, Long mauser, String tieude) throws Exception{
		dao.ThemAnhMoi(anh, mauser, tieude);
	}
	public Anh getAnhTheoTenAnh(String tenanh) throws Exception{
		return dao.getAnhTheoTenAnh(tenanh);
	}
}
