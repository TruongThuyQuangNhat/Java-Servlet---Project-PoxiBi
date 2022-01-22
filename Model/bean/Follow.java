package bean;

public class Follow {
	private Long mafollow;
	private Long mauser;
	private Long mauserfollow;
	public Follow(Long mafollow, Long mauser, Long mauserfollow) {
		super();
		this.mafollow = mafollow;
		this.mauser = mauser;
		this.mauserfollow = mauserfollow;
	}
	public Follow() {
		super();
	}
	public Long getMafollow() {
		return mafollow;
	}
	public void setMafollow(Long mafollow) {
		this.mafollow = mafollow;
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public Long getMauserfollow() {
		return mauserfollow;
	}
	public void setMauserfollow(Long mauserfollow) {
		this.mauserfollow = mauserfollow;
	}
	
}
