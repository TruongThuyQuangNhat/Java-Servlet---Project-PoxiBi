package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.Follow;

public class Followdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Follow> getDSFollow() throws Exception{
		ArrayList<Follow> ds = new ArrayList<Follow>();
		String query = "select * from Follow";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Follow(
						rs.getLong(1),
						rs.getLong(2),
						rs.getLong(3)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void ThemFollow(Long mauser, Long mauserfollow) throws Exception{
		String query = "INSERT INTO Follow (mauser, mauserfollow)\r\n"
				+ "VALUES (?, ?);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, mauserfollow);
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}	
//		rs.close();
		conn.close();
	   }
	public void XoaFollow(Long mauser, Long mauserfollow) throws Exception{
		String query = "DELETE FROM Follow WHERE mauser = ? and mauserfollow = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, mauserfollow);
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}	
//		rs.close();
		conn.close();
	   }
	public int DemFollow(Long mauser) throws Exception{
		String query = "select count(*) from Follow where mauser = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
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
	public Follow KiemTraFollow(Long mauser, Long mauserfollow) throws Exception{
		Follow  fl = null;
		String query = "select * from Follow where mauser = ? and mauserfollow = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, mauserfollow);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long mafollow = rs.getLong("mafollow");
				Long mauser2 = rs.getLong("mauser");
				Long mauserfollow2 = rs.getLong("mauserfollow");
				fl = new Follow(mafollow, mauser2, mauserfollow2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		return fl;
	}
	public void XoaFollowTheoMauser(Long mauser) throws Exception{
		String query = "DELETE FROM Follow WHERE mauser = ? or mauserfollow = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, mauser);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
}
