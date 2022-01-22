package bean;

import java.sql.Date;

public class Anh {
	private Long maanh;
	private String tenanh;
	private Long luotlike;
	private Date ngaydang;
	private Long mauser;
	private String tieude;
	public Anh(Long maanh, String tenanh, Long luotlike, Date ngaydang, Long mauser, String tieude) {
		super();
		this.maanh = maanh;
		this.tenanh = tenanh;
		this.luotlike = luotlike;
		this.ngaydang = ngaydang;
		this.mauser = mauser;
		this.tieude = tieude;
	}
	public Anh() {
		super();
	}
	public Long getMaanh() {
		return maanh;
	}
	public void setMaanh(Long maanh) {
		this.maanh = maanh;
	}
	public String getTenanh() {
		return tenanh;
	}
	public void setTenanh(String tenanh) {
		this.tenanh = tenanh;
	}
	public Long getLuotlike() {
		return luotlike;
	}
	public void setLuotlike(Long luotlike) {
		this.luotlike = luotlike;
	}
	public Date getNgaydang() {
		return ngaydang;
	}
	public void setNgaydang(Date ngaydang) {
		this.ngaydang = ngaydang;
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public String getTieude() {
		return tieude;
	}
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	
}
