package bean;

public class User {
	private Long mauser;
	private String tenuser;
	private String anhuser;
	private String sodienthoai;
	private String email;
	private String pass;
	private Boolean quyen;
	public User(Long mauser, String tenuser, String anhuser, String sodienthoai, String email, String pass,
			Boolean quyen) {
		super();
		this.mauser = mauser;
		this.tenuser = tenuser;
		this.anhuser = anhuser;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.pass = pass;
		this.quyen = quyen;
	}
	public User() {
		super();
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public String getTenuser() {
		return tenuser;
	}
	public void setTenuser(String tenuser) {
		this.tenuser = tenuser;
	}
	public String getAnhuser() {
		return anhuser;
	}
	public void setAnhuser(String anhuser) {
		this.anhuser = anhuser;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Boolean getQuyen() {
		return quyen;
	}
	public void setQuyen(Boolean quyen) {
		this.quyen = quyen;
	}
}
