package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.AnhDuocLike;
import bean.ConnectDB;

public class AnhDuocLikedao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public AnhDuocLike KiemTraAnhDuocLike(Long mauser, Long maanh) throws Exception{
		AnhDuocLike adl = null;
		String query = "select * from AnhDuocLike where mauser = ? and maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			ps.setLong(2, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long maanhlike = rs.getLong("maanhlike");
				Long mauser1 = rs.getLong("mauser");
				Long maanh1 = rs.getLong("maanh");
				
				adl = new AnhDuocLike(maanhlike, mauser1, maanh1);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return adl;
	   }
	public void ThemAnhDuocLike(Long mauser, Long maanh) throws Exception{
		String query = "INSERT INTO AnhDuocLike (mauser, maanh)\r\n"
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
	public void XoaAnhDuocLike(Long mauser, Long maanh) throws Exception{
		String query = "DELETE FROM AnhDuocLike WHERE mauser = ? and maanh = ?;";
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
	public ArrayList<AnhDuocLike> getDSADL(Long mauser) throws Exception{
		ArrayList<AnhDuocLike> ds = new ArrayList<AnhDuocLike>();
		String query = "select * from AnhDuocLike where mauser = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long maanhlike = rs.getLong("maanhlike");
				Long mauser1 = rs.getLong("mauser");
				Long maanh1 = rs.getLong("maanh");
				
				ds.add(new AnhDuocLike(maanhlike, mauser1, maanh1));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void XoaAnhDuocLikeTheoMaanh(Long maanh) throws Exception{
		String query = "DELETE FROM AnhDuocLike WHERE maanh = ?;";
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
	public void XoaAnhDuocLikeTheoMauser(Long mauser) throws Exception{
		String query = "DELETE FROM AnhDuocLike WHERE mauser = ?;";
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
