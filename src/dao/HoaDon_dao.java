package dao;

import connectDB.ConnectDBByMySQL;
import entity.DiaChi;
import entity.HoaDon;
import entity.NhaCungCap;
import entity.SanPham;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class HoaDon_dao {
    ArrayList<HoaDon> ds;

    public HoaDon_dao() {
        ds = new ArrayList<HoaDon>();
    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();

        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from HoaDon";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maHD = rs.getString("maHD");
                String maNV = rs.getString("maNV");
                String maKH = rs.getString("maKH");
                LocalDate ngayLapHD = rs.getDate("ngayLapHD").toLocalDate();

                HoaDon hd = new HoaDon(maHD, maNV, maKH, ngayLapHD);
              
                dsHD.add(hd);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dsHD;
    }

    public boolean themHoaDon(HoaDon hd) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO HoaDon values(?, ?, ?, ?)");
            preparedStatement.setString(1, hd.getMaHD());
            preparedStatement.setString(2, hd.getMaNV());
            preparedStatement.setString(3, hd.getMaKH());
            preparedStatement.setString(4, hd.getNgayLapHD().toString());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public boolean updateHoaDon(HoaDon hd) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("UPDATE HoaDon SET maNV = ?, maKH = ?, ngayLapHD = ? WHERE maHD = ?");
            preparedStatement.setString(4, hd.getMaHD());
            preparedStatement.setString(1, hd.getMaNV());
            preparedStatement.setString(2, hd.getMaKH());
            preparedStatement.setString(3, hd.getNgayLapHD().toString());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public HoaDon findHoaDon(String ma) {
        HoaDon hd;
        PreparedStatement st = null;
    	try {
	        ConnectDBByMySQL.getInstance().connect();
	        Connection con = ConnectDBByMySQL.getConnection();
	        String sql = "Select * from HoaDon where maHD = ?";
            st = con.prepareStatement(sql);
            st.setString(1, ma);
            ResultSet rs = st.executeQuery();
            rs.next();
            String maHD = rs.getString("maNCC");
            String maNV = rs.getString("maNV");
            String maKH = rs.getString("maKH");
            String ngayLapHD = rs.getString("ngayLapHD");

            hd = new HoaDon(maHD, maNV, maKH, LocalDate.parse(ngayLapHD));
          
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
    	return hd;
    }
}
