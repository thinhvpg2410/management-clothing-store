package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class GD_Product extends GD_CommonLayout{
	private static final long serialVersionUID = 1L;

	public GD_Product() {
		super("QUẢN LÝ SẢN PHẨM");
	}
	
	@Override
	public JPanel contentUI() {
		JPanel content = new JPanel(new BorderLayout());
		content.setBackground(new Color(0, 0, 0, 0));
		return content;
	}
	
	public static void main(String[] args) {
		new GD_Product().setVisible(true);
	}
}
