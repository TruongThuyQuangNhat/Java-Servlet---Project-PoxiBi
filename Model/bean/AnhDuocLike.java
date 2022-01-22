package bean;

public class AnhDuocLike {
	private Long maanhlike;
	private Long mauser;
	private Long maanh;
	public AnhDuocLike(Long maanhlike, Long mauser, Long maanh) {
		super();
		this.maanhlike = maanhlike;
		this.mauser = mauser;
		this.maanh = maanh;
	}
	public AnhDuocLike() {
		super();
	}
	public Long getMaanhlike() {
		return maanhlike;
	}
	public void setMaanhlike(Long maanhlike) {
		this.maanhlike = maanhlike;
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
