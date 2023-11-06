package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GD_CommonLayout extends JFrame {
	private final int WIDTH = 1400;
	private final int HEIGHT = 1000;
	public GD_CommonLayout() {
		//setup screan
		super("Basis Layout");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//create layout
		JPanel container = new JPanel(new BorderLayout());
		JPanel navigation = navigationUI();
		JPanel sideBar = sideBarUI();
		JPanel content = contentUI();
		
		content.add(navigation, BorderLayout.NORTH);
		container.add(sideBar, BorderLayout.WEST);
		container.add(content, BorderLayout.CENTER);
		
		Color backgroundColorContainer = Color.decode("#F5EFE0");
		container.setBackground(backgroundColorContainer);
		
		container.add(sideBar, BorderLayout.WEST);
		this.add(container);
	}
	
	private JPanel navigationUI() {
		JPanel nav = new JPanel();
		nav.setPreferredSize(new Dimension(WIDTH - WIDTH/7, 70));
		nav.setBackground(new Color(0, 0, 0, 0));
		return nav;
	}
	
	private JPanel sideBarUI() {
		JPanel sideBar = new JPanel(new BorderLayout());
		JPanel top = new JPanel();
		JPanel center = new JPanel(new GridLayout(8, 1, 0, 10));
		JPanel bottom = new JPanel();
		JPanel user = new JPanel();
		sideBar.add(top, BorderLayout.NORTH);
		sideBar.add(center, BorderLayout.CENTER);
		sideBar.add(bottom, BorderLayout.SOUTH);
		
		top.setPreferredSize(new Dimension(WIDTH/6, 100));
		bottom.setPreferredSize(new Dimension(WIDTH/6, 50));
		sideBar.setPreferredSize(new Dimension(WIDTH/6, HEIGHT));
		user.setPreferredSize(new Dimension(200, 80));
		
		Color backgroundColorSideBar = Color.decode("#CD2653");
		Color backgroundColorUser = Color.decode("#F8A4BB");
		sideBar.setBackground(backgroundColorSideBar);
		top.setBackground(backgroundColorSideBar);
		bottom.setBackground(backgroundColorSideBar);
		center.setBackground(backgroundColorSideBar);
		user.setBackground(backgroundColorUser);
		
		String[] title = {"BÁN HÀNG (F1)", "KHÁCH HÀNG (F2)", "NHÂN VIÊN (F3)", "QUẦN ÁO (F4)"
				,"NHÀ CUNG CẤP (F5)", "THỐNG KÊ (F6)", "HOÁ ĐƠN (F7)", "HƯỚNG DẪN SỬ DỤNG (F8)"};
		String rootPath = "img/icon/";
		String fileExplorer = ".png";
		String[] fileName = {"shopping-cart", "customer", "staff", "clothers", "supplier", "statistics", "bill", "help"};
		for (int i = 0; i < title.length; i++) {
			String filePath = rootPath + fileName[i] + fileExplorer;
			ImageIcon icon = new ImageIcon(createImage(filePath, 30, 30));
			Box menuPanel = createMenuPanel(icon, title[i]);
			center.add(menuPanel);
		}
		top.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		top.add(user);
		return sideBar;
	}
	
	private JPanel contentUI() {
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(new Color(0, 0, 0, 0));
		return content;
	}
	
	//Additional Function
	private Box createMenuPanel(ImageIcon icon, String title) {
		Box box = Box.createHorizontalBox();
		Box titleBox = Box.createVerticalBox();
		JLabel iconLabel = new JLabel(icon);
		JLabel titleLabel = new JLabel("<html><b style='color: #ffffff; font-size: 12'>" + title + "</b></html>");
		
		
		box.setBackground(new Color(0, 0, 0, 0));
		box.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		box.add(Box.createHorizontalStrut(10));
		box.add(iconLabel);
		box.add(Box.createHorizontalStrut(5));
		titleBox.add(Box.createVerticalStrut(17));
		titleBox.add(titleLabel);
		box.add(titleBox);
		return box;
	}
	private Image createImage(String imagePath, int width, int height) {
		 try {
			BufferedImage originalImage = ImageIO.read(new FileInputStream(imagePath));
	        BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	        Graphics2D g2 = resizedImg.createGraphics();
	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	        g2.drawImage(originalImage, 0, 0, width, height, null);
	        g2.dispose();
	        return resizedImg;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	public static void main(String[] args) {
		new GD_CommonLayout().setVisible(true);
	}
}
