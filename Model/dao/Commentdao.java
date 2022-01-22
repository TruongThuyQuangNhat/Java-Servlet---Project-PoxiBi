package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.Comment;

public class Commentdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Comment> getDSComment(Long maanh) throws Exception{
		ArrayList<Comment> ds = new ArrayList<Comment>();
		String query = "select * from Comment where maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Comment(
						rs.getLong(1),
						rs.getLong(2),
						rs.getLong(3),
						rs.getString(4),
						rs.getDate(5)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public int getSLCommentTheoMaAnh(Long maanh) throws Exception{
		String query = "select count(*) from Comment where maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return 0;
	   }
	
	public void ThemComment(Long maanh, Long mauser, String noidung)  throws Exception{
		String query = "INSERT INTO Comment (maanh, mauser, noidung, ngaydang) VALUES (?, ?, ?, GETDATE());";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.setLong(2, mauser);
			ps.setString(3, noidung);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		rs.close();
		conn.close(); 
	}
	public void XoaComment(Long macomment)  throws Exception{
		String query = "DELETE FROM Comment WHERE macomment = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		rs.close();
		conn.close(); 
	}
	public void EditComment(Long macomment,  String comment)  throws Exception{
		String query = "UPDATE Comment\r\n"
				+ "SET noidung = ?, ngaydang= GETDATE()\r\n"
				+ "WHERE macomment = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setLong(2, macomment);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
//		rs.close();
		conn.close(); 
	}
	public int getThoiGianSECOND(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(SECOND, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public int getThoiGianMINUTE(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(MINUTE, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public int getThoiGianHOUR(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(HOUR, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public int getThoiGianDAY(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(DAY, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public int getThoiGianMONTH(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(MONTH, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public int getThoiGianYEAR(Long macomment) throws Exception{
		String query = "SELECT DATEDIFF(YEAR, (select ngaydang from Comment where macomment = ?) , GETDATE())";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, macomment);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return 0;
	}
	public ArrayList<Long> getDSCommentTheoMauser(Long mauser) throws Exception{
		ArrayList<Long> ds = new ArrayList<Long>();
		String query = "select maanh, mauser from Comment where mauser = ? group by mauser, maanh;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(rs.getLong(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void XoaCommentTheoMaanh(Long maanh) throws Exception{
		String query = "DELETE FROM Comment WHERE maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
	public void XoaCommentTheoMauser(Long mauser) throws Exception{
		String query = "DELETE FROM Comment WHERE mauser = ?;";
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
	public ArrayList<Long> getDSMaanhComment() throws Exception{
		ArrayList<Long> ds = new ArrayList<Long>();
		String query = "select maanh from Comment group by maanh";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(rs.getLong(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
}
