package dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import entity.SanPham;
import entity.NhaCungCap;
import entity.KhuyenMai;
import connectDB.ConnectDBByMySQL;

public class SanPham_dao {
    ArrayList<SanPham> ds;

    public SanPham_dao() {
        ds = new ArrayList<SanPham>();
    }

    public ArrayList<SanPham> getAllSanPham() {
        ArrayList<SanPham> dsSP = new ArrayList<SanPham>();

        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from SanPham";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
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
                String hinhAnh = rs.getString("hinhAnh");
                NhaCungCap nhaCungCap = new NhaCungCap(maNCC);
                KhuyenMai khuyenMai = new KhuyenMai(maKM);
                SanPham sp = new SanPham(maSP, ten, donViTinh, giaNhap, giaBan, ngayNhap, soLuongTon, trangThai, mauSac, kichThuoc, thueVAT, nhaCungCap, khuyenMai, thuongHieu, hinhAnh);
              
                dsSP.add(sp);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dsSP;
    }

    public boolean themSanPham(SanPham sp) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO SanPham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, sp.getMaSP());
            preparedStatement.setString(2, sp.getTenSP());
            preparedStatement.setString(3, sp.getDonViTinh());
            preparedStatement.setDouble(4, sp.getGiaNhap());
            preparedStatement.setDouble(5, sp.getGiaBan());
            preparedStatement.setDate(6, Date.valueOf(sp.getNgayNhap()));
            preparedStatement.setInt(7, sp.getSoLuongTon());
            preparedStatement.setString(8, sp.isTrangThai());
            preparedStatement.setString(9, sp.getMauSac());
            preparedStatement.setString(10, sp.getKichThuoc());
            preparedStatement.setDouble(11, sp.getThueVAT());
            preparedStatement.setString(12, sp.getMaNCC().getMaNCC());
            preparedStatement.setString(13, sp.getMaKM().getMaKM());
            preparedStatement.setString(14, sp.getThuongHieu());
            preparedStatement.setString(15, sp.getHinhAnh());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public boolean updateSanPham(SanPham sp) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("UPDATE SanPham SET ten = ?, donViTinh = ?, giaNhap = ?, giaBan = ?, ngayNhap = ?, soLuongTon = ?, trangThai = ?, mauSac = ?, kichThuoc = ?, thueVAT = ?, maNCC = ?,  maKM = ?, thuongHieu = ?, WHERE maSP = ?");
            preparedStatement.setString(13, sp.getMaSP());
            preparedStatement.setString(1, sp.getTenSP());
            preparedStatement.setString(2, sp.getDonViTinh());
            preparedStatement.setDouble(3, sp.getGiaNhap());
            preparedStatement.setDouble(4, sp.getGiaBan());
            preparedStatement.setInt(5, sp.getSoLuongTon());
            preparedStatement.setString(6, sp.isTrangThai());
            preparedStatement.setString(7, sp.getMauSac());
            preparedStatement.setString(8, sp.getKichThuoc());
            preparedStatement.setDouble(9, sp.getThueVAT());
            preparedStatement.setString(10, sp.getMaNCC().toString());
            preparedStatement.setString(11, sp.getMaKM().toString());
            preparedStatement.setString(12, sp.getThuongHieu());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public SanPham findSanPham(String ma) throws SQLException {
        ConnectDBByMySQL.getInstance().connect();
        Connection con = ConnectDBByMySQL.getConnection();
        String sql = "Select * from SanPham where maSP = ?";
        PreparedStatement st = null;
        SanPham sp;
    	try {
            st = con.prepareStatement(sql);
            st.setString(1, ma);
            ResultSet rs = st.executeQuery();
            rs.next();
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
            String hinhAnh = rs.getString("hinhAnh");
            NhaCungCap nhaCungCap = new NhaCungCap(maNCC);
            KhuyenMai khuyenMai = new KhuyenMai(maKM);
            sp = new SanPham(maSP, ten, donViTinh, giaNhap, giaBan, ngayNhap, soLuongTon, trangThai, mauSac, kichThuoc, thueVAT, nhaCungCap, khuyenMai, thuongHieu, hinhAnh);
          
            } catch (SQLException e) {
             e.printStackTrace();
             return null;
         }finally {
        	 st.close();
         }
    	return sp;
    }
}
