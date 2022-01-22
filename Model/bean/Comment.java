package bean;

import java.sql.Date;

public class Comment {
	private Long macomment;
	private Long maanh;
	private Long mauser;
	private String noidung;
	private Date ngaydang;
	public Comment(Long macomment, Long maanh, Long mauser, String noidung, Date ngaydang) {
		super();
		this.macomment = macomment;
		this.maanh = maanh;
		this.mauser = mauser;
		this.noidung = noidung;
		this.ngaydang = ngaydang;
	}
	public Comment() {
		super();
	}
	public Long getMacomment() {
		return macomment;
	}
	public void setMacomment(Long macomment) {
		this.macomment = macomment;
	}
	public Long getMaanh() {
		return maanh;
	}
	public void setMaanh(Long maanh) {
		this.maanh = maanh;
	}
	public Long getMauser() {
		return mauser;
	}
	public void setMauser(Long mauser) {
		this.mauser = mauser;
	}
	public String getNoidung() {
		return noidung;
	}
	public void setNoidung(String noidung) {
		this.noidung = noidung;
	}
	public Date getNgaydang() {
		return ngaydang;
	}
	public void setNgaydang(Date ngaydang) {
		this.ngaydang = ngaydang;
	}
}
