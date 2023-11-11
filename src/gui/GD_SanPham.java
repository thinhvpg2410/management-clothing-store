package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class GD_Product extends GD_CommonLayout {
    private static final long serialVersionUID = 1L;

    public GD_Product() {
        super("QUẢN LÝ SẢN PHẨM");
    }

    @Override
    public JPanel contentUI() {
        JPanel content = new JPanel(new BorderLayout());
        JPanel toolbar = new JPanel();
        JPanel productList = new JPanel(new GridLayout(2, 4, 90, 40));
        JPanel pagination = new JPanel();

        content.add(toolbar, BorderLayout.NORTH);
        content.add(productList, BorderLayout.CENTER);
        content.add(pagination, BorderLayout.SOUTH);

        content.setBackground(new Color(0, 0, 0, 0));
        productList.setBackground(new Color(0, 0, 0, 0));
        toolbar.setBackground(Color.decode("#F8E2E2"));

        for (int i = 0; i < 8; i++) {
            JPanel productCard = createProductCard();
            productList.add(productCard);
        }
        toolbar.setPreferredSize(new Dimension(getHeight(), 50));
        pagination.setPreferredSize(new Dimension(getHeight(), 80));
        productList.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        return content;
    }

    public JPanel createProductCard() {
        JPanel productCard = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(40, 40);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded opaque panel with borders.
                graphics.setColor(Color.decode("#F5E4DA"));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.white);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
            }
        };
        Box boxCard = Box.createVerticalBox();
//		Color backgroundColor = Color.decode("#F5E4DA");
//		productCard.setBackground(backgroundColor);
        productCard.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
//		productCard.setBorder(BorderFactory.createRaisedBevelBorder());
        ImageIcon image = new ImageIcon(createImage("img/product/SP00001.png", 160, 160));
        JLabel productImage = new JLabel(image);
        productImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JLabel title = new JLabel("QUẦN TÂY - NÂU");
        JLabel price = new JLabel("260.000 VNĐ");
        price.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 10));
        price.setForeground(Color.decode("#9B9B9B"));
        JLabel textDelete = new JLabel("Xoá");
        textDelete.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
        textDelete.setForeground(new Color(0, 0, 0, 160));
        JPanel btnDelete = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(30, 40);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded opaque panel with borders.
                graphics.setColor(Color.decode("#F8A4BB"));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
            }
        };
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		btnDelete.addMouseListener(createHoverEffect(btnDelete));

        JPanel pDelete = new JPanel();
        ImageIcon trashIcon = new ImageIcon(createImage("img/icon/trash.png", 17, 17));
        JLabel trashlbl = new JLabel(trashIcon);
        trashlbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 2));
        textDelete.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 2));
        pDelete.setBackground(new Color(0, 0, 0, 0));
        btnDelete.setBackground(new Color(0, 0, 0, 0));
        btnDelete.setPreferredSize(new Dimension(100, 30));
        btnDelete.add(trashlbl);
        btnDelete.add(textDelete);

//		btnDelete.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 10));
        pDelete.add(btnDelete);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        productImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        boxCard.add(productImage);
        boxCard.add(Box.createVerticalStrut(14));
        boxCard.add(title);
        boxCard.add(price);
        boxCard.add(Box.createVerticalStrut(5));
        boxCard.add(pDelete);

        productCard.add(boxCard);
        return productCard;
    }

    public static void main(String[] args) {
        new GD_Product().setVisible(true);
    }

}
