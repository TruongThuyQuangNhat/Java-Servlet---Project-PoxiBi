package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.ConnectDB;
import bean.Loai;
import bean.CategoriesAnh;

public class CategoriesAnhdao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public ArrayList<CategoriesAnh> getDSCategoriesAnh() throws Exception{
		ArrayList<CategoriesAnh> ds = new ArrayList<CategoriesAnh>();
		String query = "select * from CategoriesAnh";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new CategoriesAnh(
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
	public ArrayList<CategoriesAnh> getDSLoaiTheoMaAnh(Long maanh) throws Exception{
		ArrayList<CategoriesAnh> ds = new ArrayList<CategoriesAnh>();
		String query = "select * from CategoriesAnh where maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new CategoriesAnh(
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
	public ArrayList<Long> getDSLoaiTheoMaAnhKieuLong(Long maanh) throws Exception{
		ArrayList<Long> ds = new ArrayList<Long>();
		String query = "select maloai from CategoriesAnh where maanh = ?";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
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
	//select TOP(1) macategoriesanh, maanh, maloai from CategoriesAnh where maanh = 5;
	public CategoriesAnh get1CTGRATheoMaAnh(Long maanh) throws Exception{
		CategoriesAnh ct = null;
		String query = "select TOP(1) macategoriesanh, maanh, maloai from CategoriesAnh where maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long macategoriesanh = rs.getLong("macategoriesanh"); 
				Long maanh2 = rs.getLong("maanh"); 
				Long maloai = rs.getLong("maloai");
				
				ct = new CategoriesAnh(macategoriesanh, maanh2, maloai);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ct;
	   }
	
	//select TOP(5) macategoriesanh, maanh, maloai from CategoriesAnh where maanh != 5 and maloai = 4;
	public ArrayList<CategoriesAnh> get_5_CTGRA_TheoMaAnhVaMaLoai(Long maanh, Long maloai) throws Exception{
		ArrayList<CategoriesAnh> ds = new ArrayList<CategoriesAnh>();
		String query = "select TOP(5) macategoriesanh, maanh, maloai from CategoriesAnh where maanh != ? and maloai = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.setLong(2, maloai);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new CategoriesAnh(
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
	public ArrayList<CategoriesAnh> get_CTGRA_TheoMaLoai(Long maloai, int index) throws Exception{
		ArrayList<CategoriesAnh> ds = new ArrayList<CategoriesAnh>();
		String query = "select * from CategoriesAnh where maloai = ? order by maanh offset ? rows fetch next 9  rows only;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
			ps.setInt(2, index);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ds.add(new CategoriesAnh(
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
	public int getSL(Long maloai) throws Exception{
		String query = "select count(*) from CategoriesAnh where maloai = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
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
	public void XoaCTGRAnh(Long maanh) throws Exception{
		String query = "DELETE CategoriesAnh WHERE maanh = ?;";
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
	
	public CategoriesAnh KiemTraTonTai(Long maloai, Long maanh) throws Exception{
		CategoriesAnh ca = null;
		String query = "select * from CategoriesAnh where maloai = ? and maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
			ps.setLong(2, maanh);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Long macategoriesanh = rs.getLong("macategoriesanh");
				Long maanh2 = rs.getLong("maanh"); 
				Long maloai2 = rs.getLong("maloai");
				ca = new CategoriesAnh(macategoriesanh, maanh2, maloai2);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
		rs.close();
		conn.close();
		   return ca;
	   }
	public void Xoa(Long maloai, Long maanh) throws Exception{
		String query = "delete CategoriesAnh where maloai = ? and maanh = ?;";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maloai);
			ps.setLong(2, maanh);
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	
	//INSERT INTO Customers (CustomerName, ContactName, Address, City, PostalCode, Country)
	//VALUES ('Cardinal', 'Tom B. Erichsen', 'Skagen 21', 'Stavanger', '4006', 'Norway');
	public void Them(Long maloai, Long maanh) throws Exception{
		String query = "INSERT INTO CategoriesAnh (maanh, maloai) VALUES (?, ?);";
		try {
			conn = new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, maanh);
			ps.setLong(2, maloai);
			rs = ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		conn.close();
	   }
	public void XoaCTGRAnhTheoMaLoai(Long maloai) throws Exception{
		String query = "DELETE CategoriesAnh WHERE maloai = ?;";
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
