package bo;

import java.util.ArrayList;

import bean.Loai;
import dao.Loaidao;

public class Loaibo {
	Loaidao dao = new Loaidao();
	ArrayList<Loai> ds = new ArrayList<Loai>();
	
	public ArrayList<Loai> getDSLoai() throws Exception{
		return dao.getDSLoai();
	}
	public String getTenLoaiTheoMaLoai(Long maloai) throws Exception{
		for(Loai l: this.getDSLoai()) {
			if(l.getMaloai() == maloai) {
				return l.getTenloai();
			}
		}
		return null;
	}
	public ArrayList<Long> getAllMaLoai() throws Exception{
		return dao.getAllMaLoai();
	}
	public void ThemLoai(String name) throws Exception{
		dao.ThemLoai(name);
	}
	public void EditLoai(String name, Long maloai) throws Exception{
		dao.EditLoai(name, maloai);
	}
	public void XoaLoai(Long maloai) throws Exception{
		dao.XoaLoai(maloai);
	}
}
