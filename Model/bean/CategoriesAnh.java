package bean;

public class CategoriesAnh {
	private Long macategoriesanh;
	private Long maanh;
	private Long maloai;
	public CategoriesAnh(Long macategoriesanh, Long maanh, Long maloai) {
		super();
		this.macategoriesanh = macategoriesanh;
		this.maanh = maanh;
		this.maloai = maloai;
	}
	public CategoriesAnh() {
		super();
	}
	public Long getMacategoriesanh() {
		return macategoriesanh;
	}
	public void setMacategoriesanh(Long macategoriesanh) {
		this.macategoriesanh = macategoriesanh;
	}
	public Long getMaanh() {
		return maanh;
	}
	public void setMaanh(Long maanh) {
		this.maanh = maanh;
	}
	public Long getMaloai() {
		return maloai;
	}
	public void setMaloai(Long maloai) {
		this.maloai = maloai;
	}
	
}
