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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class GD_SanPham extends GD_CommonLayout {
    private static final long serialVersionUID = 1L;

    public GD_SanPham() {
        super("QUẢN LÝ SẢN PHẨM");
    }

    @Override
    public JPanel contentUI() {
        JPanel content = new JPanel(new BorderLayout());
        JPanel toolbar = new JPanel(new GridLayout(1, 2, 50, 20));
        JPanel productList = new JPanel(new GridLayout(2, 4, 90, 40));
        JPanel paginationContainer = new JPanel();

        content.add(toolbar, BorderLayout.NORTH);
        content.add(productList, BorderLayout.CENTER);
        content.add(paginationContainer, BorderLayout.SOUTH);

        content.setBackground(new Color(0, 0, 0, 0));
        productList.setBackground(new Color(0, 0, 0, 0));
        paginationContainer.setBackground(new Color(0, 0, 0, 0));
        toolbar.setBackground(Color.decode("#F8E2E2"));

        for (int i = 0; i < 8; i++) {
            JPanel productCard = createProductCard();
            productList.add(productCard);
        }
        
        JPanel pag = paginationUI();
        JPanel toolLeft = toolLeftUI();
        JPanel toolRight = toolRightUI();
        paginationContainer.add(pag);
        paginationContainer.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        toolbar.setPreferredSize(new Dimension(getWidth(), 60));
        toolbar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        toolbar.add(toolLeft);
        toolbar.add(toolRight);
        paginationContainer.setPreferredSize(new Dimension(getHeight(), 80));
        productList.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        return content;
    }
    public JPanel toolLeftUI() {
    	JPanel leftTool = new JPanel(new GridLayout(1, 3, 40, 20));
    	String[] filter = {"LỌC", "Size", "Ngừng Bán"};
    	String[] sorted = {"SẮP XẾP", "Tên", "Giá"};
    	JComboBox<String> CBfilter = new JComboBox<String>(filter);
    	JComboBox<String> CBsorted = new JComboBox<String>(sorted);
//    	setComboBoxIcon(CBfilter, "img/icon/filter.png");
//        setComboBoxIcon(CBsorted, "img/icon/sorted.png");
    	leftTool.add(CBfilter);
    	leftTool.add(CBsorted);
    	leftTool.add(Box.createHorizontalStrut(10));
    	leftTool.setBackground(Color.decode("#F8E2E2"));
    	return leftTool;
    }
//    public void setComboBoxIcon(JComboBox<String> comboBox, String iconPath) {
//        ImageIcon icon = new ImageIcon(createImage(iconPath, 20, 20));
//        comboBox.setRenderer(new DefaultListCellRenderer() {
//        	 @Override
//             public Component getListCellRendererComponent(JList<?> list, Object value, int index,
//                                                           boolean isSelected, boolean cellHasFocus) {
//                 JPanel panel = new JPanel(new BorderLayout());
//                 JLabel label = new JLabel(value.toString());
//                 label.setIcon(icon);
//                 panel.add(label, BorderLayout.CENTER);
//                 return panel;
//             }
//        });
//    }
    public JPanel toolRightUI() {
    	JPanel rightTool = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(40, 40);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded opaque panel with borders.
                graphics.setColor(Color.white);
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
            }
        };
        Box box = Box.createHorizontalBox();
    	JTextField searchInput = new JTextField(33);
    	JPanel btn = new JPanel();
    	JLabel text = new JLabel("TÌM KIẾM");
    	ImageIcon searchIcon = new ImageIcon(createImage("img/icon/search.png", 20, 20));
    	JLabel icon = new JLabel(searchIcon);
    	box.add(searchInput);
    	box.add(btn);
    	btn.add(text);
    	btn.add(icon);
    	btn.setBackground(new Color(0, 0, 0, 0));
    	btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	btn.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.decode("#EDEDED")));
    	rightTool.setBackground(new Color(0, 0, 0, 0));
    	rightTool.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    	searchInput.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
    	rightTool.add(box);
    	return rightTool;
    			
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
    public JPanel paginationUI() {
    	JPanel pagCenter = new JPanel(new GridLayout(1, 6, 20, 0));
    	Box boxPag = Box.createHorizontalBox();
    	ImageIcon prev = new ImageIcon(createImage("img/icon/pag-prev.png", 15, 15));
    	ImageIcon next = new ImageIcon(createImage("img/icon/pag-next.png", 15, 15));
    	JPanel pag = new JPanel() {
    		@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension arcs = new Dimension(52, 52);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded opaque panel with borders.
                graphics.setColor(Color.decode("#F8E2E2"));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
//                graphics.setColor(Color.white);
//                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
            }
    	};
    	pag.setBorder(BorderFactory.createEmptyBorder(2, 25, 2, 25));
    	for(int i = 1; i <= 6; i++) {
    		pagCenter.add(createNodePag(new JLabel(""+i)));
    	}
    	pagCenter.setBackground(new Color(0, 0, 0, 0));
    	boxPag.add(createNodePag(new JLabel(prev)));
    	boxPag.add(Box.createHorizontalStrut(30));
    	boxPag.add(pagCenter);
    	boxPag.add(Box.createHorizontalStrut(30));
    	boxPag.add(createNodePag(new JLabel(next)));
    	
    	pag.add(boxPag);
    	return pag;
    }
    public JPanel createNodePag(JLabel lbl) {
    	lbl.setFont(new Font(Font.MONOSPACED, 1, 13));
    	try{
    		lbl.setForeground(Color.decode("#6D6D6D"));
    	}catch (Exception e){
    		
    	}
    	JPanel node = new JPanel() {
    		 @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 Dimension arcs = new Dimension(35, 38);
                 int width = getWidth();
                 int height = getHeight();
                 Graphics2D graphics = (Graphics2D) g;
                 graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                 //Draws the rounded opaque panel with borders.
                 graphics.setColor(Color.white);
                 graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
             }
    	};

    	node.setBackground(new Color(0, 0, 0, 0));
    	node.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	node.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	node.paintComponents(getGraphics());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                try{
            		lbl.setForeground(Color.decode("#6D6D6D"));
            	}catch (Exception e2){
            		
            	}
            }
        });

    	node.setPreferredSize(new Dimension(35, 35));
    	node.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
    	node.add(lbl);
    	return node;
    }
    
    public static void main(String[] args) {
        new GD_SanPham().setVisible(true);
    }

}
