package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import entity.SanPham;
import entity.NhaCungCap;
import entity.KhuyenMai;
import connectDB.ConnectDBByMySQL;
public class SanPham_dao {
	public SanPham_dao() {
	}
	public static ArrayList<SanPham> getAllSanPham(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		
		try {
			ConnectDBByMySQL.getInstance().connect();
			Connection con = ConnectDBByMySQL.getConnection();
			String sql = "Select * from SanPham";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				String maSP = rs.getString("maSP");
				String ten = rs.getString("ten");
				String donViTinh = rs.getString("donViTinh");
				double giaNhap = rs.getDouble("giaNhap");
				double giaBan = rs.getDouble("giaBan");
				LocalDate ngayNhap = rs.getDate("ngayNhap").toLocalDate();
				int soLuongTon = rs.getInt("soLuongTon");
				String trangThai = rs.getString("trangThai");
				String mauSac = rs.getString("mauSac");
				String kichThuoc = rs.getString("kichThuoc");
				double thueVAT = rs.getDouble("thueVAT");
				String maNCC = rs.getString("maNCC");
				String maKM = rs.getString("maKM");
				String thuongHieu = rs.getString("thuongHieu");
				
				NhaCungCap nhaCungCap = new NhaCungCap(maNCC);
				KhuyenMai khuyenMai = new KhuyenMai();
				SanPham sp = new SanPham(maSP, ten, donViTinh, giaNhap, ngayNhap, soLuongTon, trangThai, mauSac, kichThuoc, thueVAT, nhaCungCap, khuyenMai, thuongHieu);
				dsSP.add(sp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSP;
	}
}
