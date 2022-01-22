package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.Anh;

public class Anhdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<Anh> getDSAnh() throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	//select * from Anh order by maanh offset 18 rows fetch next 9  rows only;
	public ArrayList<Anh> getDSAnhPage(int index) throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh order by maanh offset ? rows fetch next 9  rows only;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, (index-1)*9);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	
	public ArrayList<Anh> getDSAnhPageTimKiem(int index, String key) throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh where tieude like ? order by maanh offset ? rows fetch next 9  rows only;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+ key +"%");
			ps.setInt(2, (index-1)*9);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public ArrayList<Anh> getDSAnhTimKiem(String key) throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh where tieude like ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+ key +"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public int getSLAnhTimKiem(String key) throws Exception{
		String query = "select count(*) from Anh where tieude like ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1,"%"+ key +"%");
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
	
	
	public ArrayList<Anh> getDSAnhNext9(Long maanh) throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh order by maanh OFFSET CAST(? AS int) ROWS FETCH NEXT 9 ROWS ONLY";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	
	//select top 9 * from Anh
	public ArrayList<Anh> getDSAnhTop9() throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select top 9 * from Anh";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	//select count(*) from Anh
	public int getSLAnh() throws Exception{
		String query = "select count(*) from Anh";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
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
	
	//UPDATE Anh SET luotlike = luotlike+1 WHERE maanh = 6;
	public void UpdateTangLuotlike(Long maanh) throws Exception{
		String query = "UPDATE Anh SET luotlike = luotlike+1 WHERE maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
//		rs.close();
		conn.close();
	   }
	public void UpdateGiamLuotlike(Long maanh) throws Exception{
		String query = "UPDATE Anh SET luotlike = luotlike-1 WHERE maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
//		rs.close();
		conn.close();
	   }
	public Anh getAnhTheoMaAnh(Long maanh) throws Exception{
		Anh anh = null;
		String query = "select * from Anh where maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long maanh2 = rs.getLong("maanh");
				String tenanh = rs.getString("tenanh"); 
				Long luotlike = rs.getLong("luotlike");
				Date ngaydang = rs.getDate("ngaydang"); 
				Long mauser = rs.getLong("mauser"); 
				String tieude = rs.getString("tieude");
				anh = new Anh(maanh2, tenanh, luotlike, ngaydang, mauser, tieude);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return anh;
	   }
	
	//select count(*) from Anh where mauser = 5;
	public int getSoLuongAnhTheoMaUser(Long mauser) throws Exception{
		String query = "select count(*) from Anh where mauser = ?;";
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
	public ArrayList<Anh> getDSAnhTheoMauser(Long mauser) throws Exception{
		ArrayList<Anh> ds = new ArrayList<Anh>();
		String query = "select * from Anh where mauser = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, mauser);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new Anh(
						rs.getLong(1),
						rs.getString(2),
						rs.getLong(3),
						rs.getDate(4),
						rs.getLong(5),
						rs.getString(6)
						));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ds;
	   }
	public void EditName(Long maanh, String name) throws Exception{
		String query = "UPDATE Anh SET tieude = ? WHERE maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setLong(2, maanh);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
	//DELETE FROM table_name WHERE condition;
	public void XoaAnh(Long maanh) throws Exception{
		String query = "DELETE FROM Anh WHERE maanh = ?;";
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
	public void ThemAnhMoi(String anh, Long mauser, String tieude) throws Exception{
		String query = "INSERT INTO Anh (tenanh, luotlike, ngaydang, mauser, tieude)\r\n"
				+ "VALUES (?, 0, getdate(), ?, ?);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, anh);
			ps.setLong(2, mauser);
			ps.setString(3, tieude);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		conn.close();
	   }
	
	
	public Anh getAnhTheoTenAnh(String tenanh) throws Exception{
		Anh anh = null;
		String query = "select * from Anh where tenanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tenanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long maanh = rs.getLong("maanh");
				String tenanh2 = rs.getString("tenanh"); 
				Long luotlike = rs.getLong("luotlike");
				Date ngaydang = rs.getDate("ngaydang"); 
				Long mauser = rs.getLong("mauser"); 
				String tieude = rs.getString("tieude");
				anh = new Anh(maanh, tenanh2, luotlike, ngaydang, mauser, tieude);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return anh;
	   }
}
