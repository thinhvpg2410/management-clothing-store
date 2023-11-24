package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDBByMySQL;
import dao.KhachHang_dao;
import dao.SanPham_dao;
import entity.KhachHang;
import entity.SanPham;

import javax.swing.ImageIcon;
public class GD_BanHang extends GD_CommonLayout{
	private SanPham_dao sp_dao;
	private KhachHang_dao kh_dao;
	private SanPham sp;
	private KhachHang kh;
	private JPanel productInfo;
	private DefaultTableModel billTableModel;
	private JTable billTable;
	private int stt;
	private JSpinner input;
	private double subPrice;
	private double totalPrice = 0;
	private double payPrice;
	private Box top;
	private JPanel billOut;
	public GD_BanHang() {
		super("QUẢN LÝ BÁN HÀNG");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public JPanel contentUI() {
		try {
			ConnectDBByMySQL.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	sp_dao = new SanPham_dao();
    	kh_dao = new KhachHang_dao();
		String[] column = {"STT", "TÊN HÀNG", "SỐ LƯỢNG", "ĐƠN GIÁ", "% GIẢM GIÁ", "THÀNH TIỀN"};
		JPanel container = new JPanel(new BorderLayout());
		top = Box.createHorizontalBox();
		billTableModel = new DefaultTableModel(column, 0);
		billTable = new JTable(billTableModel);
		JPanel bottom = new JPanel(new BorderLayout());
		productInfo = new JPanel(new GridLayout(3, 2, 50, 40));
		JPanel right = new JPanel(new BorderLayout());
		JPanel buttonGroup = new JPanel(new GridLayout(5, 1, 10, 10));
		billOut = new JPanel(new GridLayout(6, 2, 0, 20));
		bottom.setPreferredSize(new Dimension(getWidth(), 300));
		top.setPreferredSize(new Dimension(getWidth(), 80));
		buttonGroup.setPreferredSize(new Dimension(200, 300));
		billOut.setPreferredSize(new Dimension(350, 300));
		
		top.add(generateSearchInput("Số Điện Thoại", 1, Color.white));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Tên Khách Hàng", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Số Lần Đã Mua", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(20));
		top.add(generateFormInput("Tổng Tiền Đã Mua", 1,  Color.decode("#F0CFCF")));
		top.add(Box.createHorizontalStrut(100));
		top.add(generateFormInput("Mã Nhân Viên", 1,  Color.decode("#F0CFCF")));
		top.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
//		top.setBackground(new Color(0, 0, 0, 0));
		
		productInfo.add(generateSearchInput("Mã Sản Phẩm", 1, Color.WHITE));
		productInfo.add(generateFormInput("Tên Sản Phẩm", 1, Color.WHITE));
		productInfo.add(generateFormInput("Đơn Giá", 1, Color.WHITE));
		productInfo.add(generateFormInput("Mã Giảm Giá", 1, Color.WHITE));
		productInfo.add(generateFormInput("Tồn Kho", 1, Color.WHITE));
		productInfo.add(generateQuantityInput("Số Lượng", 1, Color.WHITE));
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
		container.setBackground(Color.decode("#F5EFE0"));
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
	public Box generateQuantityInput(String label, int type, Color color) {
		Box form = Box.createVerticalBox();
		if(type != 1) form = Box.createHorizontalBox();
        Box b = Box.createHorizontalBox();
		JLabel lbl = new JLabel(label);
		b.add(lbl);
		b.add(Box.createHorizontalGlue());
		input = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));;
        ((JSpinner.DefaultEditor) input.getEditor()).getTextField().setHorizontalAlignment(JTextField.LEFT);
        ((JSpinner.DefaultEditor) input.getEditor()).getTextField().setBackground(new Color(0, 0, 0, 0));
        ((JSpinner.DefaultEditor) input.getEditor()).getTextField().setBorder(BorderFactory.createEmptyBorder());
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
    	Border margin = new EmptyBorder(0, 7, 0, 0);
    	input.setBorder(new CompoundBorder(input.getBorder(), margin));
    	input.setForeground(Color.decode("#9A9A9A"));
		form.add(b);
		form.add(input);
		return form;
	}
	public Box generateSearchInput(String label, int type, Color color) {
		Box form = Box.createVerticalBox();
		if(type != 1) form = Box.createHorizontalBox();
        Box b = Box.createHorizontalBox();
		JLabel lbl = new JLabel(label);
		b.add(lbl);
		b.add(Box.createHorizontalGlue());
		JPanel input = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(createImage("img/icon/search.png", 20, 20));
		JLabel lblicon = new JLabel(icon);
		JTextField txt = new JTextField();
		stt = 0;
		txt.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
//		input.setBackground(new Color(0, 0, 0, 0));
		input.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color));
    	Border margin = new EmptyBorder(0, 10, 0, 0);
    	txt.setBorder(new CompoundBorder(txt.getBorder(), margin));
    	txt.setForeground(Color.decode("#9A9A9A"));
    	txt.setBackground(new Color(0, 0, 0, 0));
    	if(label.equalsIgnoreCase("mã sản phẩm")) {
	    	txt.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sp = sp_dao.findSanPham(txt.getText());
					String[] info = {"", sp.getTenSP(), sp.getGiaBan()+"", "", sp.getSoLuongTon()+""};
					for(int i = 1; i <= 4; i++) {
						Box b = (Box) productInfo.getComponent(i);
						JTextField t = (JTextField) b.getComponent(1);
						t.setText(info[i]);
					}
				}
			});
    	}
    	if(label.equalsIgnoreCase("Số điện thoại")) {
    		input.setBackground(Color.decode("#F5EFE0"));
	    	txt.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					kh = kh_dao.findKhachHang();
					Box b = (Box) top.getComponent(2);
					JTextField t = (JTextField) b.getComponent(1);
					t.setText(kh.getHoTen());
				}
			});
    	}
    	input.add(txt);
    	input.add(lblicon, BorderLayout.WEST);
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
		if(label.equalsIgnoreCase("Lên")) {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					stt += 1;
					subPrice = 0;
					int quantity = Integer.parseInt(input.getValue()+"");
					subPrice = quantity*sp.getGiaBan();
					billTableModel.addRow(new Object[]{
						stt,
						sp.getTenSP(),
						quantity,
						sp.getGiaBan(),
						"",
						subPrice,
					});
					totalPrice += subPrice;
					JTextField t = (JTextField) billOut.getComponent(3);
					t.setText(totalPrice+"");
				}
			});
		}
		if(label.equalsIgnoreCase("Tạo mới")) {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					billTableModel.getDataVector().removeAllElements();
				}
			});
		}
		if(label.equalsIgnoreCase("Xoá")) {
			btn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					billTableModel.removeRow(billTable.getSelectedRow());
				}
			});
		}
		return btn;
	}
	public static void main(String[] args) {
		new GD_BanHang().setVisible(true);
	}
}
