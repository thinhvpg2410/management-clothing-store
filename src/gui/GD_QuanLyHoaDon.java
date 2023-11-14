package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GD_QuanLyHoaDon extends GD_CommonLayout {
    public GD_QuanLyHoaDon() {
        super("QUẢN LÝ HOÁ ĐƠN");
    }

    @Override
    public JPanel contentUI() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(new Color(0, 0, 0, 0));
        JPanel pnContent = new JPanel();
        pnContent.setBackground(new Color(0, 0, 0, 0));
        content.add(pnContent, BorderLayout.CENTER);
        JPanel pnInputField = new JPanel();
        pnContent.add(pnInputField, BorderLayout.NORTH);
        pnInputField.setLayout(null);
        pnInputField.setBackground(new Color(0, 0, 0, 0));
        pnInputField.setPreferredSize(new Dimension(super.getWidth() * 5 / 6, 100));

        JLabel lbMaHD = new JLabel("<html><b style=' font-size: 14;'>" + "Mã hoá đơn:" + "</b></html>");
        lbMaHD.setBounds(10, 10, 100, 35);
        lbMaHD.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaHD);
        JTextField txtMaHD = new JTextField();
        txtMaHD.setBounds(140, 12, 200, 25);
        txtMaHD.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaHD);

        JLabel lbMaKH = new JLabel("<html><b style=' font-size: 14;'>" + "Mã khách hàng:" + "</b></html>");
        lbMaKH.setBounds(10, 40, 120, 35);
        lbMaKH.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaKH);
        JTextField txtMaKH = new JTextField();
        txtMaKH.setBounds(140, 42, 200, 25);
        txtMaKH.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaKH);

        JLabel lbMaNV = new JLabel("<html><b style=' font-size: 14;'>" + "Mã nhân viên:" + "</b></html>");
        lbMaNV.setBounds(350, 10, 100, 25);
        lbMaNV.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaNV);
        JTextField txtMaNV = new JTextField();
        txtMaNV.setBounds(460, 12, 200, 25);
        txtMaNV.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaNV);

        JLabel lbNgayLapHD = new JLabel("<html><b style=' font-size: 14;'>" + "Ngày lập HĐ:" + "</b></html>");
        lbNgayLapHD.setBounds(350, 40, 100, 25);
        lbNgayLapHD.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbNgayLapHD);
        JTextField txtNgayLapHD = new JTextField();
        txtNgayLapHD.setBounds(460, 42, 200, 25);
        txtNgayLapHD.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtNgayLapHD);

        JLabel lbNamSinh = new JLabel("<html><b style=' font-size: 14;'>" + "Thành Tiền:" + "</b></html>");
        lbNamSinh.setBounds(690, 10, 100, 25);
        lbNamSinh.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbNamSinh);
        JTextField txtThanhTien = new JTextField();
        txtThanhTien.setBounds(800, 12, 200, 25);
        txtThanhTien.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtThanhTien);

        JPanel pnBot = new JPanel();
        content.add(pnBot, BorderLayout.SOUTH);
        String[] colNames = {"Mã hoá đơn", "Mã nhân viên", "Mã khách hàng", "Ngày lập HĐ", "Thành Tiền"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(super.getWidth() * 5/6, 600));
        pnBot.setPreferredSize(new Dimension(super.getWidth() * 5 / 6, 600));
        pnBot.setBackground(new Color(0, 0, 0, 0));
        pnBot.add(scrollPane);

        return content;
    }

    public static void main(String[] args) {
        new GD_QuanLyHoaDon().setVisible(true);
    }
}
