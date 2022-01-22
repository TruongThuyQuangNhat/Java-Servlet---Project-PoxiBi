package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.CategoriesUser;

public class CategoriesUserdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<CategoriesUser> getDSCategoriesUser() throws Exception{
		ArrayList<CategoriesUser> ds = new ArrayList<CategoriesUser>();
		String query = "select * from CategoriesUser";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new CategoriesUser(
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
	public void XoaCategoriesUser(Long mauser) throws Exception{
		String query = "DELETE FROM CategoriesUser WHERE mauser = ?;";
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
	public void XoaCategoriesUserTheoMaLoai(Long maloai) throws Exception{
		String query = "DELETE FROM CategoriesUser WHERE maloai = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
}
