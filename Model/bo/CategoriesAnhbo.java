package bo;

import java.util.ArrayList;

import bean.CategoriesAnh;
import bean.ConnectDB;
import dao.CategoriesAnhdao;

public class CategoriesAnhbo {
	CategoriesAnhdao dao = new CategoriesAnhdao();
	ArrayList<CategoriesAnh> ds = new ArrayList<CategoriesAnh>();
	
	public ArrayList<CategoriesAnh> getDSCategoriesAnh() throws Exception{
		return dao.getDSCategoriesAnh();
	}
	public ArrayList<CategoriesAnh> getDSLoaiTheoMaAnh(Long maanh) throws Exception{
		return dao.getDSLoaiTheoMaAnh(maanh);
	}public ArrayList<Long> getDSLoaiTheoMaAnhKieuLong(Long maanh) throws Exception{
		return dao.getDSLoaiTheoMaAnhKieuLong(maanh);
	}
	public CategoriesAnh get1CTGRATheoMaAnh(Long maanh) throws Exception{
		return dao.get1CTGRATheoMaAnh(maanh);
	}
	public ArrayList<CategoriesAnh> get_5_CTGRA_TheoMaAnhVaMaLoai(Long maanh, Long maloai) throws Exception{
		return dao.get_5_CTGRA_TheoMaAnhVaMaLoai(maanh, maloai);
	}
	public ArrayList<CategoriesAnh> get_CTGRA_TheoMaLoai(Long maloai, int index) throws Exception{
		return dao.get_CTGRA_TheoMaLoai(maloai, index);
	}
	public int getSL(Long maloai) throws Exception{
		return dao.getSL(maloai);
	}
	public void XoaCTGRAnh(Long maanh) throws Exception{
		dao.XoaCTGRAnh(maanh);
	}
	public CategoriesAnh KiemTraTonTai(Long maloai, Long maanh) throws Exception{
		return dao.KiemTraTonTai(maloai, maanh);
	}
	public void Xoa(Long maloai, Long maanh) throws Exception{
		dao.Xoa(maloai, maanh);
	}
	public void Them(Long maloai, Long maanh) throws Exception{
		dao.Them(maloai, maanh);
	}
	public void XoaCTGRAnhTheoMaLoai(Long maloai) throws Exception{
		dao.XoaCTGRAnhTheoMaLoai(maloai);
	}
}
