package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GD_KhuyenMai extends GD_CommonLayout{
	 private static final long serialVersionUID = 1L;
	public GD_KhuyenMai() {
		super("QUÁN LÝ CHƯƠNG TRÌNH KHUYẾN MÃI");
	}
	 public static void main(String[] args) {
		new GD_KhuyenMai().setVisible(true);
	}
	@Override
	public JPanel contentUI() {
		JPanel container = new JPanel(new BorderLayout());
		JPanel main = new JPanel(new BorderLayout());
		JPanel event = new JPanel();
		JPanel toolbar = new JPanel(new GridLayout(1, 2, 50, 20));
		JPanel table = new JPanel(new GridLayout(8, 1, 0, 10));
		JPanel toolLeft = toolLeftUI();
        JPanel toolRight = toolRightUI();
		event.setPreferredSize(new Dimension(300, getHeight()));
		toolbar.setBackground(Color.decode("#F8E2E2"));
		toolbar.setPreferredSize(new Dimension(getWidth(), 60));
        toolbar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        for(int i = 0; i < 8; i++) {
	        Box row = Box.createHorizontalBox();
	        row.setBorder(BorderFactory.createLineBorder(Color.black));
        	table.add(row);	
        }
        toolbar.add(toolLeft);
        toolbar.add(toolRight);
		main.add(toolbar, BorderLayout.NORTH);
		main.add(table);
		
		container.add(main);
		container.add(event, BorderLayout.EAST);
		return container;
	}
	public JPanel headerUI() {
		JPanel header = new JPanel();
		Box element = Box.createHorizontalBox();
		
		return header;
	}
	public JPanel toolLeftUI() {
    	JPanel leftTool = new JPanel(new GridLayout(1, 3, 20, 20));
    	String[] filter = {"LỌC", "Size", "Ngừng Bán"};
    	String[] sorted = {"SẮP XẾP", "Tên", "Giá"};
    	JComboBox<String> CBfilter = new JComboBox<String>(filter);
    	JComboBox<String> CBsorted = new JComboBox<String>(sorted);
    	leftTool.add(CBfilter);
    	leftTool.add(CBsorted);
    	leftTool.setBackground(Color.decode("#F8E2E2"));
    	return leftTool;
    }
    public JPanel toolRightUI() {
    	JPanel rightTool = new JPanel() {
            private static final long serialVersionUID = 1L;

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
    	JTextField searchInput = new JTextField(20);
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
}
