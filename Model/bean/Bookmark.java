package bean;

public class Bookmark {
	private Long mabookmark;
	private Long mauser;
	private Long maanh;
	public Bookmark(Long mabookmark, Long mauser, Long maanh) {
		super();
		this.mabookmark = mabookmark;
		this.mauser = mauser;
		this.maanh = maanh;
	}
	public Bookmark() {
		super();
	}
	public Long getMabookmark() {
		return mabookmark;
	}
	public void setMabookmark(Long mabookmark) {
		this.mabookmark = mabookmark;
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public Long getMaanh() {
		return maanh;
	}
	public void setMaanh(Long maanh) {
		this.maanh = maanh;
	}
	
}
