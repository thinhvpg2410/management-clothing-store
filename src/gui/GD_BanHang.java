package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GD_BanHang extends GD_CommonLayout{

	public GD_BanHang() {
		super("QUẢN LÝ BÁN HÀNG");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public JPanel contentUI() {
		String[] column = {"STT", "MÀ HÀNG", "TÊN HÀNG", "SỐ LƯỢNG", "ĐƠN GIÁ", "% GIẢM GIÁ", "THÀNH TIỀN", "TỒN KHO"};
		JPanel container = new JPanel(new BorderLayout());
		Box top = Box.createHorizontalBox();
		DefaultTableModel billTableModel = new DefaultTableModel(column, 0);
		JTable billTable = new JTable(billTableModel);
		JPanel bottom = new JPanel(new BorderLayout());
		JPanel productInfo = new JPanel(new GridLayout(3, 2, 10, 10));
		JPanel right = new JPanel(new BorderLayout());
		Box buttonGroup = Box.createVerticalBox();
		JPanel billOut = new JPanel(new GridLayout(6, 2, 5, 10));
		
		bottom.setPreferredSize(new Dimension(getWidth(), 300));
		top.setPreferredSize(new Dimension(getWidth(), 80));
		buttonGroup.setPreferredSize(new Dimension(200, 300));
		billOut.setPreferredSize(new Dimension(350, 300));
		
		top.setBorder(BorderFactory.createLineBorder(Color.black));
		productInfo.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonGroup.setBorder(BorderFactory.createLineBorder(Color.black));
		billOut.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		right.add(buttonGroup, BorderLayout.WEST);
		right.add(billOut);
		bottom.add(productInfo);
		bottom.add(right, BorderLayout.EAST);
		container.add(top, BorderLayout.NORTH);
		container.add(new JScrollPane(billTable));
		container.add(bottom, BorderLayout.SOUTH);
		return container;
	}
	public static void main(String[] args) {
		new GD_BanHang().setVisible(true);
	}
}
