package bo;

import java.util.ArrayList;

import bean.User;
import dao.Userdao;

public class Userbo {
	Userdao dao = new Userdao();
	ArrayList<User> ds = new ArrayList<User>();
	
	public ArrayList<User> getDSUser() throws Exception{
		return dao.getDSUser();
	}
	public void DangKyUser(String hoten, String anh, String sodt, String email, String pass)  throws Exception{
		dao.DangKyUser(hoten, anh, sodt, email, pass);
	}
	public Boolean EmailDaTonTai(String email)  throws Exception{
		return dao.EmailDaTonTai(email);
	}
	public User KiemTraDangNhap(String email, String pass) throws Exception{
		return dao.KiemTraDangNhap(email, pass);
	}
	public User getUserTheoMaUser(Long mauser) throws Exception{
		return dao.getUserTheoMaUser(mauser);
	}
	public void UpdateUser(Long mauser, String tenuser, String anhuser, String sodienthoai) throws Exception{
		dao.UpdateUser(mauser, tenuser, anhuser, sodienthoai);
	}
	public void UpdateEmail(Long mauser, String newemail) throws Exception{
		dao.UpdateEmail(mauser, newemail);
	}
	public void UpdatePass(Long mauser, String pass) throws Exception{
		dao.UpdatePass(mauser, pass);
	}
	public void UpdateQuyenAdmin(Long mauser) throws Exception{
		dao.UpdateQuyenAdmin(mauser);
	}
	public void UpdateQuyeUser(Long mauser) throws Exception{
		dao.UpdateQuyenUser(mauser);
	}
	public void XoaUserTheoMauser(Long mauser) throws Exception{
		dao.XoaUserTheoMauser(mauser);
	}
}
