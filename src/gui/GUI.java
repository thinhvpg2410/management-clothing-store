package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends GD_CommonLayout {
    public GUI() {
        super("CỬA HÀNG QUẦN ÁO BOBBI");
    }

    @Override
    public JPanel contentUI() {
        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(new Color(0, 0, 0, 0));
        BufferedImage bgDashBoard;
        try {
            bgDashBoard = ImageIO.read(new File("img/bgDashboard.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JLabel lbImg = new JLabel(new ImageIcon(bgDashBoard));
        content.add(lbImg);
        return content;
    }
}
