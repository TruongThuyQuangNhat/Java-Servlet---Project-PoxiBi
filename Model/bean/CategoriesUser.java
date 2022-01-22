package bean;

public class CategoriesUser {
	private Long macategoriesuser;
	private Long mauser;
	private Long maloai;
	public CategoriesUser(Long macategoriesuser, Long mauser, Long maloai) {
		super();
		this.macategoriesuser = macategoriesuser;
		this.mauser = mauser;
		this.maloai = maloai;
	}
	public CategoriesUser() {
		super();
	}
	public Long getMacategoriesuser() {
		return macategoriesuser;
	}
	public void setMacategoriesuser(Long macategoriesuser) {
		this.macategoriesuser = macategoriesuser;
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public Long getMaloai() {
		return maloai;
	}
	public void setMaloai(Long maloai) {
		this.maloai = maloai;
	}
	
}
