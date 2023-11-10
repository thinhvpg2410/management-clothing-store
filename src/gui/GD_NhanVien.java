package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GD_NhanVien extends GD_CommonLayout {
    public GD_NhanVien() {
        super("QUẢN LÝ NHÂN VIÊN");
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

        JLabel lbMaNV = new JLabel("<html><b style=' font-size: 14;'>" + "Mã nhân viên:" + "</b></html>");
        lbMaNV.setBounds(10, 10, 100, 25);
        lbMaNV.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaNV);
        JTextField txtMaNV = new JTextField();
        txtMaNV.setBounds(120, 12, 200, 25);
        txtMaNV.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaNV);

        JLabel lbHoTen = new JLabel("<html><b style=' font-size: 14;'>" + "Họ tên:" + "</b></html>");
        lbHoTen.setBounds(10, 40, 100, 25);
        lbHoTen.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbHoTen);
        JTextField txtHoTen = new JTextField();
        txtHoTen.setBounds(120, 42, 200, 25);
        txtHoTen.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtHoTen);

        JLabel lbSDT = new JLabel("<html><b style=' font-size: 14;'>" + "Số điện thoại:" + "</b></html>");
        lbSDT.setBounds(350, 10, 100, 25);
        lbSDT.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbSDT);
        JTextField txtSDT = new JTextField();
        txtSDT.setBounds(460, 12, 200, 25);
        txtSDT.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtSDT);

        JLabel lbEmail = new JLabel("<html><b style=' font-size: 14;'>" + "Email:" + "</b></html>");
        lbEmail.setBounds(350, 40, 100, 25);
        lbEmail.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(460, 42, 200, 25);
        txtEmail.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtEmail);

        JLabel lbNamSinh = new JLabel("<html><b style=' font-size: 14;'>" + "Năm sinh:" + "</b></html>");
        lbNamSinh.setBounds(690, 10, 100, 25);
        lbNamSinh.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbNamSinh);
        JTextField txtNamSinh = new JTextField();
        txtNamSinh.setBounds(800, 12, 200, 25);
        txtNamSinh.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtNamSinh);

        JLabel lbGioiTinh = new JLabel("<html><b style=' font-size: 14;'>" + "Giới tính:" + "</b></html>");
        lbGioiTinh.setBounds(690, 40, 100, 25);
        lbGioiTinh.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbGioiTinh);
        JRadioButton radNam = new JRadioButton("Nam");
        radNam.setBounds(800, 42, 50, 25);
//        radNam.setBackground(new Color(0, 0, 0, 0));
        pnInputField.add(radNam);
        JRadioButton radNu = new JRadioButton("Nữ");
        radNu.setBounds(860, 42, 50, 25);
//        radNu.setBackground(new Color(0, 0, 0, 0));
        pnInputField.add(radNu);

        ButtonGroup gender = new ButtonGroup();
        gender.add(radNam);
        gender.add(radNu);


        JPanel pnBot = new JPanel();
        content.add(pnBot, BorderLayout.SOUTH);
        String[] colNames = {"Mã nhân viên", "Họ và tên", "Email", "Năm sinh", "SĐT", "Giới tính"};
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
        new GD_NhanVien().setVisible(true);
    }
}
