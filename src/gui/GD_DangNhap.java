package gui;

import javax.swing.*;
import java.awt.*;

public class GD_DangNhap extends JFrame {
    private JLabel lbTitle, lbTaiKhoan, lbMatKhau;
    private JTextField txtUsername;
    private JPasswordField txtPassword;

    public GD_DangNhap() {

        setTitle("Login Page");
        setSize(640, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#F5EFE0"));
        add(panel);

        JPanel pNorth = new JPanel();
        lbTitle = new JLabel("CỬA HÀNG THỜI TRANG BOBBI");

        lbTitle.setForeground(Color.decode("#CD2653"));

//        lbTitle.setBackground(Color.decode("#F5EFE0"));
        pNorth.add(lbTitle);
        pNorth.setOpaque(false);

        panel.add(pNorth, BorderLayout.NORTH);

        JPanel pCenter = new JPanel();
        pCenter.add(lbTaiKhoan = new JLabel("Tài Khoản: "));




    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
        panel.add(userLabel);

        txtUsername = new JTextField();
        panel.add(txtUsername);

        JLabel passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        txtPassword = new JPasswordField();
        panel.add(txtPassword);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

    }
}
