package dao;

import connectDB.ConnectDBByMySQL;
import entity.HoaDon;
import entity.NhanVien;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class NhanVien_dao {
    ArrayList<NhanVien> ds;

    public NhanVien_dao() {
        ds = new ArrayList<NhanVien>();
    }

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();

        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from NhanVien";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maNV = rs.getString("maNV");
                String ten = rs.getString("ten");
                int namSinh = rs.getInt("namSinh");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                String gioiTinh = rs.getString("gioiTinh");
                NhanVien nv = new NhanVien(maNV, ten, namSinh,email,sdt,gioiTinh.equals("Nam"));
              
                dsNV.add(nv);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dsNV;
    }

    public boolean themNhanVien(NhanVien hd) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO NhanVien values(?, ?, ?, ?,?,?)");
            preparedStatement.setString(1, hd.getMaNV());
            preparedStatement.setString(2, hd.getHoTen());
            preparedStatement.setInt(3, hd.getNamSinh());
            preparedStatement.setString(4, hd.geteMail());
            preparedStatement.setString(5, hd.getSdt());
            preparedStatement.setString(6, hd.isGioiTinh()?"Nam":"Nữ");
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public boolean updateNhanVien(NhanVien nv) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("UPDATE HoaDon SET ten = ?, namSinh = ?, eMail = ?, sdt = ?, gioiTinh = ? WHERE maNv = ?");
            preparedStatement.setString(6, nv.getMaNV());
            preparedStatement.setString(1, nv.getHoTen());
            preparedStatement.setInt(2, nv.getNamSinh());
            preparedStatement.setString(3, nv.geteMail());
            preparedStatement.setString(4, nv.getSdt());
            preparedStatement.setString(5, nv.geteMail());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public NhanVien findNhanVien(String ma) {
        NhanVien nv;
        PreparedStatement st = null;
    	try {
	        ConnectDBByMySQL.getInstance().connect();
	        Connection con = ConnectDBByMySQL.getConnection();
	        String sql = "Select * from NhanVien where maHD = ?";
            st = con.prepareStatement(sql);
            st.setString(1, ma);
            ResultSet rs = st.executeQuery();
            rs.next();
            String maNV = rs.getString("maNV");
            String ten = rs.getString("ten");
            int namSinh = rs.getInt("namSinh");
            String email = rs.getString("eMail");
            String sdt = rs.getString("sdt");
            String gioiTinh = rs.getString("gioiTinh");

            nv = new NhanVien(maNV, ten, namSinh,email,sdt,gioiTinh.equals("Nam"));
          
            } catch (SQLException e) {
             e.printStackTrace();
             return null;
         }finally {
        	 try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         }
    	return nv;
    }
}
