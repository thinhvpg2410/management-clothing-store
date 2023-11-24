package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDBByMySQL;
import entity.KhachHang;

public class KhachHang_dao {
	ArrayList<KhachHang> ds;

    public KhachHang_dao() {
        ds = new ArrayList<KhachHang>();
    }

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();

        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from KhachHang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String ten = rs.getString("ten");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                KhachHang kh = new KhachHang(maKH, ten, email, sdt);
                dsKH.add(kh);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dsKH;
    }
    public KhachHang findKhachHang() {
    	KhachHang kh = null;
        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from KhachHang";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maKH = rs.getString("maKH");
                String ten = rs.getString("ten");
                String email = rs.getString("email");
                String sdt = rs.getString("sdt");
                kh = new KhachHang(maKH, ten, email, sdt);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return kh;
    }
}
