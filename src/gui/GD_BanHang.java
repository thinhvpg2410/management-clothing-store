package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
		JPanel productInfo = new JPanel(new GridLayout(3, 2, 50, 40));
		JPanel right = new JPanel(new BorderLayout());
		JPanel buttonGroup = new JPanel(new GridLayout(5, 1, 10, 10));
		JPanel billOut = new JPanel(new GridLayout(6, 2, 0, 20));
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
		
		String[] lblBillOut = {"Tổng SL Hàng", "Tổng Tiền", "Tổng Tiền Giảm", "Tiền Phải Thu", "Tiền Khách Đưa", "Tiên Trả Khách"};
		for(int i = 0; i < lblBillOut.length; i++) {
			billOut.add(new JLabel(lblBillOut[i]));
			if(i != 4) billOut.add(generatePrettyTextField(1));
			else billOut.add(generatePrettyTextField(0));
		}
		String[] lblButton = {"LÊN", "TRA CỨU", "TẠO MỚI", "XOÁ", "TREO GD(0)", "XEM HOÁ ĐƠN", "THANH TOÁN"};
		for(int i = 0; i < lblButton.length; i++) {
			if(i < 4) {	
				JPanel groupChild = new JPanel(new GridLayout(1, 2, 5, 5));
				groupChild.add(generatePrettyButton(lblButton[i]));
				groupChild.add(generatePrettyButton(lblButton[++i]));
				buttonGroup.add(groupChild);
			}else {		
				buttonGroup.add(generatePrettyButton(lblButton[i]));
			}
			
		}
//		buttonGroup.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		buttonGroup.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		billOut.setBorder(BorderFactory.createEmptyBorder(20, 20, 40, 20));
		
		
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
		if(type != 1) form = Box.createHorizontalBox();
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
			input.setFocusable(false);
    	}
		form.add(b);
		form.add(input);
		return form;
	}
	public JTextField generatePrettyTextField(int type) {
		JTextField input = new JTextField();
		String c1 = "#9A9A9A", c2 = "#FFFFFF";
		if(type == 1) {
			c1 =  "#CEA1A1";
			c2 =  "#F0CFCF";
			input.setEditable(false);
			input.setFocusable(false);
		}
    	input.setForeground(Color.decode(c1));
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode(c2)));
		input.setBackground(new Color(0, 0, 0, 0));
    	Border margin = new EmptyBorder(0, 7, 0, 0);
    	input.setBorder(new CompoundBorder(input.getBorder(), margin));
		
		return input;
	}
	public JPanel generatePrettyButton(String label) {
		JPanel btn = new JPanel();
		JLabel lbl = new JLabel(label);
		btn.add(lbl);
		
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setBackground(Color.decode("#D9D9D9"));
		btn.setBorder(BorderFactory.createEtchedBorder());
		return btn;
	}
	public static void main(String[] args) {
		new GD_BanHang().setVisible(true);
	}
}
