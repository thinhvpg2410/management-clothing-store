package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class GD_NhaCungCap extends GD_CommonLayout {
    public GD_NhaCungCap() {
        super("NHÀ CUNG CẤP");
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

        JLabel lbMaNCC = new JLabel("<html><b style=' font-size: 14;'>" + "Mã nhà cung cấp:" + "</b></html>");
        lbMaNCC.setBounds(110, 10, 160, 25);
        lbMaNCC.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbMaNCC);
        JTextField txtMaNCC = new JTextField();
        txtMaNCC.setBounds(280, 12, 200, 25);
        txtMaNCC.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtMaNCC);

        JLabel lbTenNCC = new JLabel("<html><b style=' font-size: 14;'>" + "Tên nhà cung cấp:" + "</b></html>");
        lbTenNCC.setBounds(110, 40, 160, 25);
        lbTenNCC.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbTenNCC);
        JTextField txtTenNCC = new JTextField();
        txtTenNCC.setBounds(280, 42, 200, 25);
        txtTenNCC.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtTenNCC);

        JLabel lbSDT = new JLabel("<html><b style=' font-size: 14;'>" + "Số điện thoại:" + "</b></html>");
        lbSDT.setBounds(550, 10, 160, 25);
        lbSDT.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbSDT);
        JTextField txtSDT = new JTextField();
        txtSDT.setBounds(720, 12, 200, 25);
        txtSDT.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtSDT);

        JLabel lbEmail = new JLabel("<html><b style=' font-size: 14;'>" + "Email:" + "</b></html>");
        lbEmail.setBounds(550, 40, 160, 25);
        lbEmail.setHorizontalAlignment(JLabel.RIGHT);
        pnInputField.add(lbEmail);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(720, 42, 200, 25);
        txtEmail.setBackground((Color.decode("#F8A4BB")));
        pnInputField.add(txtEmail);

        JPanel pnButton = new JPanel();
        content.add(pnButton,BorderLayout.CENTER);
        JButton btnThem = new JButton("Thêm");
        JButton btnCapNhat = new JButton("Cập nhật");
        JButton btnXoa = new JButton("Xóa");
        JButton btnLamMoi = new JButton("Làm mới");
        JButton btnTimKiem = new JButton("Tìm kiếm");

        JPanel pnBot = new JPanel();
        content.add(pnBot, BorderLayout.SOUTH);
        String[] colNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Email", "SĐT"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(super.getWidth() * 5 / 6, 600));
        pnBot.setPreferredSize(new Dimension(super.getWidth() * 5 / 6, 600));
        pnBot.setBackground(new Color(0, 0, 0, 0));
        pnBot.add(scrollPane);

        return content;
    }

    public static void main(String[] args) {
        new GD_NhaCungCap().setVisible(true);
    }
}
