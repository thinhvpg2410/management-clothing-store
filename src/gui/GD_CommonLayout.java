package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		container.add(navigation, BorderLayout.NORTH);
		container.add(sideBar, BorderLayout.WEST);
		container.add(sideBar, BorderLayout.CENTER);
		Color backgroundColorContainer = Color.decode("#F5EFE0");
		container.setBackground(backgroundColorContainer);
		
		container.add(sideBar, BorderLayout.WEST);
		this.add(container);
	}
	private JPanel navigationUI() {
		JPanel nav = new JPanel();
		nav.setPreferredSize(new Dimension(WIDTH - WIDTH/5, 100));
		nav.setBackground(new Color(0, 0, 0, 0));
		return nav;
	}
	private JPanel sideBarUI() {
		JPanel sideBar = new JPanel(new BorderLayout());
		sideBar.setPreferredSize(new Dimension(WIDTH/5, HEIGHT));
		Color backgroundColorSideBar = Color.decode("#CD2653");
		sideBar.setBackground(backgroundColorSideBar);
		return sideBar;
	}
	private JPanel contentUI() {
		JPanel content = new JPanel(new BorderLayout());
		content.setPreferredSize(new Dimension(WIDTH/5, HEIGHT));
		content.setBackground(new Color(0, 0, 0, 0));
		return content;
	}
	private JPanel createMenuLabel(ImageIcon icon, String title) {
		JPanel menuLabel = new JPanel();
		JLabel iconLabel = new JLabel(icon);
		JLabel titleLabel = new JLabel(title);
		
		menuLabel.setBackground(new Color(0, 0, 0, 0));
		menuLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));

		menuLabel.add(iconLabel);
		menuLabel.add(titleLabel);
		return menuLabel;
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
