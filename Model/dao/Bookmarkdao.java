package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AnhDuocLike;
import bean.Bookmark;
import bean.ConnectDB;

public class Bookmarkdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Bookmark KiemTraBookmark(Long mauser, Long maanh) throws Exception{
		Bookmark bm = null;
		String query = "select * from Bookmark where mauser = ? and maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long mabookmark = rs.getLong("mabookmark");
				Long mauser1 = rs.getLong("mauser");
				Long maanh1 = rs.getLong("maanh");
				
				bm = new Bookmark(mabookmark, mauser1, maanh1);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return bm;
	   }
	
	public void ThemBookmark(Long mauser, Long maanh) throws Exception{
		String query = "INSERT INTO Bookmark (mauser, maanh)\r\n"
				+ "VALUES (?, ?);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, maanh);
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}	
//		rs.close();
		conn.close();
	   }
	public void XoaBookmark(Long mauser, Long maanh) throws Exception{
		String query = "DELETE FROM Bookmark WHERE mauser = ? and maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, maanh);
			ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}	
//		rs.close();
		conn.close();
	   }
	
	public ArrayList<Bookmark> getDSBM(Long mauser) throws Exception{
		ArrayList<Bookmark> ds = new ArrayList<Bookmark>();
		String query = "select * from Bookmark where mauser = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long mabookmark = rs.getLong("mabookmark");
				Long mauser1 = rs.getLong("mauser");
				Long maanh1 = rs.getLong("maanh");
				
				ds.add(new Bookmark(mabookmark, mauser1, maanh1));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void XoaBMTheoMaanh(Long maanh) throws Exception{
		String query = "DELETE FROM Bookmark WHERE maanh = ?;";
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
	public void XoaBMTheoMauser(Long mauser) throws Exception{
		String query = "DELETE FROM Bookmark WHERE mauser = ?;";
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
