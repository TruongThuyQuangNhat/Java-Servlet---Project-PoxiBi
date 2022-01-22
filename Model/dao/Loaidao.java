package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.Loai;

public class Loaidao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Loai> getDSLoai() throws Exception{
		ArrayList<Loai> ds = new ArrayList<Loai>();
		String query = "select * from Loai";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Loai(
						rs.getLong(1),
						rs.getString(2)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public ArrayList<Long> getAllMaLoai() throws Exception{
		ArrayList<Long> ds = new ArrayList<Long>();
		String query = "select maloai from Loai";
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
	//INSERT INTO Loai (tenloai) VALUES (N'java');
	public void ThemLoai(String name) throws Exception{
		String query = "INSERT INTO Loai (tenloai) VALUES (?);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void EditLoai(String name, Long maloai) throws Exception{
		String query = "UPDATE Loai SET tenloai = ? WHERE maloai = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setLong(2, maloai);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void XoaLoai(Long maloai) throws Exception{
		String query = "DELETE FROM Loai WHERE maloai = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
}
