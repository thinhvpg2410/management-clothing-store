package dao;

import connectDB.ConnectDBByMySQL;
import entity.DiaChi;
import entity.KhuyenMai;
import entity.NhaCungCap;
import entity.SanPham;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class NhaCungCap_dao {
    ArrayList<NhaCungCap> ds;

    public NhaCungCap_dao() {
        ds = new ArrayList<NhaCungCap>();
    }

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        ArrayList<NhaCungCap> dsNCC = new ArrayList<NhaCungCap>();

        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String sql = "Select * from NhaCungCap";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maSP = rs.getString("maNCC");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");

                NhaCungCap ncc = new NhaCungCap(maSP, ten, sdt,email);
              
                dsNCC.add(ncc);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dsNCC;
    }

    public boolean themNhaCungCap(NhaCungCap ncc) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("INSERT INTO NhaCungCap values(?, ?, ?, ?)");
            preparedStatement.setString(1, ncc.getMaNCC());
            preparedStatement.setString(2, ncc.getTen());
            preparedStatement.setString(3, ncc.getSdt());
            preparedStatement.setString(4, ncc.getEmail());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public boolean updateNhaCungCap(NhaCungCap ncc) {
        Connection con = ConnectDBByMySQL.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        int n = 0;
        try {
            preparedStatement = con.prepareStatement("UPDATE NhaCungCap SET ten = ?, sdt = ?, email = ? WHERE maNCC = ?");
            preparedStatement.setString(4, ncc.getMaNCC());
            preparedStatement.setString(1, ncc.getTen());
            preparedStatement.setString(2, ncc.getSdt());
            preparedStatement.setString(3, ncc.getEmail());
            n = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n > 0;
    }
    public NhaCungCap findNhaCungCap(String ma) {
        NhaCungCap ncc;
        PreparedStatement st = null;
    	try {
	        ConnectDBByMySQL.getInstance().connect();
	        Connection con = ConnectDBByMySQL.getConnection();
	        String sql = "Select * from NhaCungCap where maNCC = ?";
            st = con.prepareStatement(sql);
            st.setString(1, ma);
            ResultSet rs = st.executeQuery();
            rs.next();
            String maNCC = rs.getString("maNCC");
            String ten = rs.getString("ten");
            String sdt = rs.getString("sdt");

            String email = rs.getString("email");

            ncc = new NhaCungCap(maNCC, ten, sdt, email);
          
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
    	return ncc;
    }
}
