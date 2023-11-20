package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GD_KhachHang extends GD_CommonLayout {
    public GD_KhachHang() {
        super("QUẢN LÝ KHÁCH HÀNG");
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

        JLabel lbMaKH = new JLabel("<html><b style=' font-size: 14;'>" + "Mã khách hàng:" + "</b></html>");
        lbMaKH.setBounds(150, 10, 120, 35);
        lbMaKH.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaKH);
        JTextField txtMaKH = new JTextField();
        txtMaKH.setBounds(280, 12, 200, 25);
        txtMaKH.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaKH);

        JLabel lbHoTen = new JLabel("<html><b style=' font-size: 14;'>" + "Họ tên:" + "</b></html>");
        lbHoTen.setBounds(170, 40, 100, 25);
        lbHoTen.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbHoTen);
        JTextField txtHoTen = new JTextField();
        txtHoTen.setBounds(280, 42, 200, 25);
        txtHoTen.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtHoTen);

        JLabel lbSDT = new JLabel("<html><b style=' font-size: 14;'>" + "Số điện thoại:" + "</b></html>");
        lbSDT.setBounds(650, 10, 100, 25);
        lbSDT.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbSDT);
        JTextField txtSDT = new JTextField();
        txtSDT.setBounds(760, 12, 200, 25);
        txtSDT.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtSDT);

        JLabel lbEmail = new JLabel("<html><b style=' font-size: 14;'>" + "Email:" + "</b></html>");
        lbEmail.setBounds(650, 40, 100, 25);
        lbEmail.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(760, 42, 200, 25);
        txtEmail.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtEmail);


        JPanel pnBot = new JPanel();
        content.add(pnBot, BorderLayout.SOUTH);
        String[] colNames = {"Mã khách hàng", "Họ và tên", "Email", "SĐT"};
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
        new GD_KhachHang().setVisible(true);
    }
}
