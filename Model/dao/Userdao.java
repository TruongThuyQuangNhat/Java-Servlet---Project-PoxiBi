package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Anh;
import bean.ConnectDB;
import bean.User;

public class Userdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<User> getDSUser() throws Exception{
		ArrayList<User> ds = new ArrayList<User>();
		String query = "select * from [User]";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new User(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getBoolean(7)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void DangKyUser(String hoten, String anh, String sodt, String email, String pass)  throws Exception{
		String query = "INSERT INTO [User] (tenuser, anhuser, sodienthoai, email, pass, quyen)\n"
				+ "VALUES (?, ?, ?, ?, ?, 0);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, hoten);
			ps.setString(2, anh);
			ps.setString(3, sodt);
			ps.setString(4, email);
			ps.setString(5, pass);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		rs.close();
		conn.close(); 
	}
	public boolean EmailDaTonTai(String email) throws Exception{
		String query = "select * from [User] where email = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return false;
	   }
	public User KiemTraDangNhap(String email, String pass) throws Exception{
		String query = "select * from [User] where email = ? and pass = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(
						rs.getLong(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getBoolean(7)
						);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return null;
	   }
	public User getUserTheoMaUser(Long mauser) throws Exception{
		User u = null;
		String query = "select * from [User] where mauser = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long mauser2 = rs.getLong("mauser");
				String tenuser = rs.getString("tenuser"); 
				String anhuser = rs.getString("anhuser"); 
				String sodienthoai = rs.getString("sodienthoai"); 
				String email = rs.getString("email"); 
				String pass = rs.getString("pass");
				Boolean quyen = rs.getBoolean("quyen");
				u = new User(mauser2, tenuser, anhuser, sodienthoai, email, pass, quyen);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return u;
	   }
	
	//UPDATE [User]
	//SET tenuser = 'aloalo', anhuser = 'aloalo', sodienthoai = 'aloalo'
	//		WHERE mauser = 57;
	public void UpdateUser(Long mauser, String tenuser, String anhuser, String sodienthoai) throws Exception{
		String query = "UPDATE [User]\r\n"
				+ "	SET tenuser = ?, anhuser = ?, sodienthoai = ?\r\n"
				+ "	WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tenuser);
			ps.setString(2, anhuser);
			ps.setString(3, sodienthoai);
			ps.setLong(4, mauser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	//
	public void UpdateEmail(Long mauser, String newemail) throws Exception{
		String query = "UPDATE [User] SET email = ? WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newemail);
			ps.setLong(2, mauser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	
	public void UpdatePass(Long mauser, String pass) throws Exception{
		String query = "UPDATE [User] SET pass = ? WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, pass);
			ps.setLong(2, mauser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void UpdateQuyenAdmin(Long mauser) throws Exception{
		String query = "UPDATE [User] SET quyen = 'True' WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void UpdateQuyenUser(Long mauser) throws Exception{
		String query = "UPDATE [User] SET quyen = 'False' WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void XoaUserTheoMauser(Long mauser) throws Exception{
		String query = "DELETE FROM [User] WHERE mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
}
