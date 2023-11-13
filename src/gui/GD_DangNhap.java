package gui;

import connectDB.ConnectDBByMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GD_DangNhap extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel lbTitle, lbTaiKhoan, lbMatKhau, lbQuenMatKhau;
    private JTextField txtTaiKhoan;
    private JPasswordField txtMatKhau;
    private JButton btnLogin, btnShowHide;

    public GD_DangNhap() {
        JPanel panel = new JPanel();
        add(panel);
        panel.setBackground(Color.decode("#F5EFE0"));
        JPanel pNorth = new JPanel();
        lbTitle = new JLabel("CỬA HÀNG THỜI TRANG BOBBI");
        lbTitle.setForeground(Color.decode("#CD2653"));
        pNorth.add(lbTitle);
        pNorth.setOpaque(false);
        panel.add(pNorth, BorderLayout.NORTH);

        JPanel pCenter = new JPanel();
        pCenter.setLayout(null);
        pCenter.setBackground(new Color(0, 0, 0, 0));
        pCenter.setPreferredSize(new Dimension(640, 180));
        pCenter.add(lbTaiKhoan = new JLabel("Tài Khoản: "));
        lbTaiKhoan.setBounds(150, 10, 80, 25);
        pCenter.add(txtTaiKhoan = new JTextField());

        /**
         * Add Placeholder to JTextField
         * Code by: ThinhVPG
         */
        txtTaiKhoan.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtTaiKhoan.getText().trim().equals("Tên đăng nhập")) {
                    txtTaiKhoan.setText("");
                }
                txtTaiKhoan.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtTaiKhoan.getText().trim().equals("")) {
                    txtTaiKhoan.setText("Tên đăng nhập");
                    txtTaiKhoan.setForeground(Color.LIGHT_GRAY);

                }
            }
        });
        txtTaiKhoan.setBounds(240, 10, 250, 25);
        pCenter.add(lbMatKhau = new JLabel("Mật khẩu: "));
        lbMatKhau.setBounds(150, 40, 80, 25);
        pCenter.add(txtMatKhau = new JPasswordField());
        /**
         * Add Placeholder to JPasswordField
         * Code by: ThinhVPG
         */

        txtMatKhau.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                char[] password = txtMatKhau.getPassword();
                if (new String(password).equals(txtMatKhau)) {
                    txtMatKhau.setText("");
                    txtMatKhau.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                char[] password = txtMatKhau.getPassword();
                if (new String(password).isEmpty()) {
                    txtMatKhau.setText("Nhập mật Khẩu");
                    txtMatKhau.setEchoChar((char) 0);
                    txtMatKhau.setForeground(Color.LIGHT_GRAY);

                }
            }
        });
        txtMatKhau.setBounds(240, 40, 250, 25);
        pCenter.add(lbQuenMatKhau = new JLabel("Quên Mật khẩu?"));
        lbQuenMatKhau.setBounds(400, 70, 100, 25);
        pCenter.add(btnLogin = new JButton("Đăng nhập"));
        btnLogin.setBounds(150, 100, 120, 25);
        btnLogin.setBackground(Color.decode("#CD2653"));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBorder(null);
        btnLogin.setFocusPainted(false);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtTaiKhoan.getText();
                char[] passwordChars = txtMatKhau.getPassword();
                String password = new String(passwordChars);
                String role = authenticateUser(username, password);

                if (role != null) {
                    System.out.println(role);
                    if ("admin".equals(role)) {
                        // Perform admin-specific actions
                    } else if ("user".equals(role)) {
                        // Perform user-specific actions
                    }
                } else {
                    System.out.println("Invalid");                }

            }
        });

        Icon showPassIcon = new ImageIcon("img/icon/Show.png");
        Icon hidePassIcon = new ImageIcon("img/icon/hide.png");
        pCenter.add(btnShowHide = new JButton(showPassIcon));
        btnShowHide.setBounds(350, 39, 27, 27);

        btnShowHide.setOpaque(false);
        btnShowHide.setBorder(null);
        btnShowHide.setFocusPainted(false);

        /**
         * Password visible button
         * Code by: ThinhVPG
         */
        btnShowHide.addActionListener(new ActionListener() {
            boolean passwordVisible = false;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordVisible) {
                    txtMatKhau.setEchoChar('•');
                    btnShowHide.setIcon(showPassIcon);
                } else {
                    txtMatKhau.setEchoChar((char) 0);
                    btnShowHide.setIcon(hidePassIcon);
                }
                passwordVisible = !passwordVisible;
            }
        });

        panel.add(pCenter, BorderLayout.CENTER);

        setTitle("Login Page");
        setIconImage(new ImageIcon("img/Logo.png").getImage());
        setSize(640, 360);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private String authenticateUser(String username, String password) {
        try {
            ConnectDBByMySQL.getInstance().connect();
            Connection con = ConnectDBByMySQL.getConnection();
            String query = "SELECT * FROM users WHERE taiKhoan=? AND matKhau=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("loaiTaiKhoan");
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        new GD_DangNhap();
    }

}
