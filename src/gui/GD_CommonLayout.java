package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
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
		JPanel sideBar = new JPanel(new BorderLayout());
		sideBar.setPreferredSize(new Dimension(WIDTH/5, HEIGHT));
		
		Color backgroundColorContainer = Color.decode("#F5EFE0");
		container.setBackground(backgroundColorContainer);
		Color backgroundColorSideBar = Color.decode("#CD2653");
		sideBar.setBackground(backgroundColorSideBar);
		
		container.add(sideBar, BorderLayout.WEST);
		this.add(container);
	}
	public static void main(String[] args) {
		new GD_CommonLayout().setVisible(true);
	}
}
