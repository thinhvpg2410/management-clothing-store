package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
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
		JPanel productInfo = new JPanel(new GridLayout(3, 2, 50, 30));
		JPanel right = new JPanel(new BorderLayout());
		Box buttonGroup = Box.createVerticalBox();
		JPanel billOut = new JPanel(new GridLayout(6, 2, 5, 10));
		bottom.setPreferredSize(new Dimension(getWidth(), 300));
		top.setPreferredSize(new Dimension(getWidth(), 80));
		buttonGroup.setPreferredSize(new Dimension(200, 300));
		billOut.setPreferredSize(new Dimension(350, 300));
		
		top.add(generateFormInput("Số Điện Thoại", 1, Color.white));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Tên Khách Hàng", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Số Lần Đã Mua", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Tổng Tiền Đã Mua", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(100));
		top.add(generateFormInput("Mã Nhân Viên", 1,  Color.decode("#F0CFCF")));
		top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		top.setBackground(new Color(0, 0, 0, 0));
		
		productInfo.add(generateFormInput("Mã Sản Phẩm", 1, Color.WHITE));
		productInfo.add(generateFormInput("Tên Sản Phẩm", 1, Color.WHITE));
		productInfo.add(generateFormInput("Đơn Giá", 1, Color.WHITE));
		productInfo.add(generateFormInput("Mã Giảm Giá", 1, Color.WHITE));
		productInfo.add(generateFormInput("Tồn Kho", 1, Color.WHITE));
		productInfo.add(generateFormInput("Số Lượng", 1, Color.WHITE));
		productInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 40));
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
	public Box generateFormInput(String label, int type, Color color) {
		Box form = Box.createVerticalBox();
        Box b = Box.createHorizontalBox();
		JLabel lbl = new JLabel(label);
		b.add(lbl);
		b.add(Box.createHorizontalGlue());
		JTextField input = new JTextField();
		input.setBackground(new Color(0, 0, 0, 0));
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
    	Border margin = new EmptyBorder(0, 7, 0, 0);
    	input.setBorder(new CompoundBorder(input.getBorder(), margin));
    	input.setForeground(Color.decode("#9A9A9A"));
    	if(color.equals(Color.decode("#F0CFCF"))) {
    		input.setForeground(Color.decode("#CEA1A1"));
    		input.setEditable(false);
    	}
		form.add(b);
		form.add(input);
		return form;
	}
	public static void main(String[] args) {
		new GD_BanHang().setVisible(true);
	}
}
