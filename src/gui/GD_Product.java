package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class GD_Product extends GD_CommonLayout{
	private static final long serialVersionUID = 1L;

	public GD_Product() {
		super("QUẢN LÝ SẢN PHẨM");
	}
	
	@Override
	public JPanel contentUI() {
		JPanel content = new JPanel(new BorderLayout());
		JPanel toolbar = new JPanel();
		JPanel productList = new JPanel(new GridLayout(2, 4, 90, 40));
		JPanel pagination = new JPanel();
		
		content.add(toolbar, BorderLayout.NORTH);
		content.add(productList, BorderLayout.CENTER);
		content.add(pagination, BorderLayout.SOUTH);
		
		content.setBackground(new Color(0, 0, 0, 0));
		productList.setBackground(new Color(0, 0, 0, 0));
		toolbar.setBackground(Color.decode("#F8E2E2"));
		
		for(int i = 0; i < 8; i++) {
			JPanel productCard = createProductCard();
			productList.add(productCard);
		}
		toolbar.setPreferredSize(new Dimension(getHeight(), 50));
		pagination.setPreferredSize(new Dimension(getHeight(), 80));
		productList.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		return content;
	}
	
	public JPanel createProductCard() {
		JPanel productCard = new JPanel();
		Box box = Box.createVerticalBox();
		Color backgroundColor = Color.decode("#F5E4DA");
		productCard.setBackground(backgroundColor);
		productCard.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		productCard.setBorder(BorderFactory.createRaisedBevelBorder());
		
//		 int bevelType = BevelBorder.LOWERED; // Chọn loại viền (RAISED hoặc LOWERED)
//        Color highlightOuter = Color.DARK_GRAY; // Màu viền bên ngoài sáng
//        Color highlightInner = Color.white; // Màu viền bên trong sáng
//        Color shadowOuter = Color.WHITE; // Màu viền bên ngoài tối
//        Color shadowInner = Color.WHITE; // Màu viền bên trong tối
//        int borderRadius = 20; // Độ bo tròn
//        Border bevelBorder = BorderFactory.createBevelBorder(bevelType, highlightOuter, highlightInner, shadowOuter, shadowInner);
//        LineBorder roundedBorder = new LineBorder(backgroundColor, borderRadius);
//        
//        // Kết hợp viền bevel và viền bo tròn
//        CompoundBorder compoundBorder = new CompoundBorder(bevelBorder, roundedBorder);
//
//        // Tạo EmptyBorder để tạo khoảng cách giữa viền và nội dung bên trong
//        int borderGap = 5; // Khoảng cách từ viền đến nội dung
//        EmptyBorder emptyBorder = new EmptyBorder(borderGap, borderGap, borderGap, borderGap);
//
//        // Kết hợp cả viền và EmptyBorder
//        Border finalBorder = new CompoundBorder(compoundBorder, emptyBorder);
//        productCard.setBorder(compoundBorder);
			
		return productCard;
	}
	public static void main(String[] args) {
		new GD_Product().setVisible(true);
	}
}
