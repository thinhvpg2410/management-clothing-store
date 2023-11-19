package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

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
		JPanel event = eventUI();
		JPanel toolbar = new JPanel(new GridLayout(1, 2, 50, 20));
		JPanel tableContainer = new JPanel(new BorderLayout());
		JPanel table = new JPanel(new GridLayout(0, 1, 0, 10));
		JPanel toolLeft = toolLeftUI();
        JPanel toolRight = toolRightUI();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		toolbar.setBackground(Color.decode("#F8E2E2"));
		toolbar.setPreferredSize(new Dimension(getWidth(), 60));
        toolbar.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        table.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableContainer.add(headerTable(), BorderLayout.NORTH);
        table.add(rowTable());
        for(int i = 0; i < 15; i++) {
        	table.add(rowTable());
        }
        tableContainer.add(scrollPane);
        toolbar.add(toolLeft);
        toolbar.add(toolRight);
		main.add(toolbar, BorderLayout.NORTH);
		main.add(tableContainer);
		
		container.add(main);
		container.add(event, BorderLayout.EAST);
		container.setBackground(Color.decode("#F5EFE0"));
		table.setBackground(Color.decode("#F5EFE0"));
		tableContainer.setBackground(Color.decode("#F5EFE0"));
		return container;
	}
	public JPanel eventUI() {
		JPanel event = new JPanel(new BorderLayout());
		JPanel headerContainer = new JPanel();
		Box header = Box.createHorizontalBox();
		JPanel gridRow = new JPanel(new GridLayout(12, 1, 0, 15));
		JLabel lbl = new JLabel("SỰ KIỆN SẮP DIỄN RA");
		JPanel row = new JPanel();
		JLabel lbl1 = new JLabel("Ngày từ: ");
		JLabel lbl2 = new JLabel("Đến: ");
		JTextField txt1 = new JTextField(5);
		JTextField txt2 = new JTextField(5);
		lbl.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		header.add(Box.createHorizontalStrut(50));
		header.add(lbl1);
		header.add(txt1);
		header.add(Box.createHorizontalStrut(10));
		header.add(lbl2);
		header.add(txt2);
//		lbl.setForeground(Color.decode("#BFBFBF"));
		headerContainer.add(header);
		headerContainer.setPreferredSize(new Dimension(300, 60));
		headerContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
		headerContainer.setBackground(Color.decode("#F8E2E2"));
		gridRow.setBackground(Color.decode("#F5EFE0"));
		gridRow.setBorder(BorderFactory.createEmptyBorder(16, 10, 10, 10));
		row.setBackground(new Color(0, 0, 0, 0));

		row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.gray));
    	Border margin = new EmptyBorder(0, 7, 0, 0);
    	row.setBorder(new CompoundBorder(row.getBorder(), margin));
		lbl.setBackground(new Color(0, 0, 0, 0));
		row.add(lbl);
		gridRow.add(row);
		for(int i = 0; i < 9; i++) {
			Box col1 = Box.createVerticalBox();
			col1.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
			JLabel l1 = new JLabel("Ngày Nhà Giáo Việt Nam");
			JLabel l11 = new JLabel("20/11/2023 - Còn 3 ngày");
			l11.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
			col1.add(l11);
			col1.add(l1);
			gridRow.add(col1);
		}
		event.add(headerContainer, BorderLayout.NORTH);
		event.add(gridRow);
		event.setPreferredSize(new Dimension(300, getHeight()));
		return event;
	}
	public JPanel rowTable() {
		JPanel row = createPrettyPanel();
		Box header = Box.createHorizontalBox();
		Box col1 = Box.createVerticalBox();
		JLabel lbl1 = new JLabel("Chương trình khuyến mãi hoá đơn 1");
		JLabel lbl11 = new JLabel("05/08/2023 - liên tục");
		JLabel lbl2 = new JLabel("KM0001");
		JCheckBox lbl3 = new JCheckBox("Đang chạy");
		lbl3.setSelected(true);
		JLabel lbl4 = new JLabel("0 / 10");
		JLabel lbl5 = new JLabel("0 / 0");
		JPanel element1 = new JPanel(), element2 = new JPanel(), element3 = new JPanel(), element4 = new JPanel(), element5 = new JPanel();
		lbl11.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 11));
		col1.add(lbl1);
		col1.add(lbl11);
		element1.add(col1);
		element2.add(lbl2);
		element3.add(lbl3);
		element4.add(lbl4);
		element5.add(lbl5);
		
		element1.setBorder(BorderFactory.createEmptyBorder(5, 0, 20, 0));
		element2.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element3.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		element4.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element5.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
//		element1.setBorder(BorderFactory.createLineBorder(Color.black));
//		element2.setBorder(BorderFactory.createLineBorder(Color.black));
//		element3.setBorder(BorderFactory.createLineBorder(Color.black));
//		element4.setBorder(BorderFactory.createLineBorder(Color.black));
//		element5.setBorder(BorderFactory.createLineBorder(Color.black));

		element1.setPreferredSize(new Dimension(190, 60));
		element2.setPreferredSize(new Dimension(40, 60));
		element3.setPreferredSize(new Dimension(50, 60));
		element4.setPreferredSize(new Dimension(50, 60));
		element5.setPreferredSize(new Dimension(50, 60));
		header.setPreferredSize(new Dimension(getWidth() - getWidth()/6 - 350-10, 60));
		element1.setBackground(new Color(0, 0, 0, 0));
		element2.setBackground(new Color(0, 0, 0, 0));
		element4.setBackground(new Color(0, 0, 0, 0));
		element5.setBackground(new Color(0, 0, 0, 0));
		header.add(element1);
		header.add(element2);
		header.add(element3);
		header.add(element4);
		header.add(element5);
		
		row.add(header);
		return row;
	}
	public Box headerTable() {
		
		Box header = Box.createHorizontalBox();
		JLabel lbl1 = new JLabel("Chương Trình Khuyến Mãi");
		JLabel lbl2 = new JLabel("Mã");
		JLabel lbl3 = new JLabel("Trạng Thái");
		JLabel lbl4 = new JLabel("Đơn Hàng Còn Lại");
		JLabel lbl5 = new JLabel("Tiền KM / Tiền Hàng");
		JPanel element1 = new JPanel(), element2 = new JPanel(), element3 = new JPanel(), element4 = new JPanel(), element5 = new JPanel();
		element1.add(lbl1);
		element2.add(lbl2);
		element3.add(lbl3);
		element4.add(lbl4);
		element5.add(lbl5);

		element1.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element2.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element3.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element4.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
		element5.setBorder(BorderFactory.createEmptyBorder(15, 0, 20, 0));
//		element1.setBorder(BorderFactory.createLineBorder(Color.black));
//		element2.setBorder(BorderFactory.createLineBorder(Color.black));
//		element3.setBorder(BorderFactory.createLineBorder(Color.black));
//		element4.setBorder(BorderFactory.createLineBorder(Color.black));
//		element5.setBorder(BorderFactory.createLineBorder(Color.black));
		element1.setPreferredSize(new Dimension(230, 60));
		element2.setPreferredSize(new Dimension(50, 60));
		element3.setPreferredSize(new Dimension(70, 60));
		element4.setPreferredSize(new Dimension(70, 60));
		element5.setPreferredSize(new Dimension(90, 60));

		element1.setBackground(new Color(0, 0, 0, 0));
		element2.setBackground(new Color(0, 0, 0, 0));
		element3.setBackground(new Color(0, 0, 0, 0));
		element4.setBackground(new Color(0, 0, 0, 0));
		element5.setBackground(new Color(0, 0, 0, 0));
		header.add(element1);
		header.add(element2);
		header.add(element3);
		header.add(element4);
		header.add(element5);
		header.add(Box.createHorizontalStrut(15));
		return header;
	}
	public JPanel createPrettyPanel() {
		JPanel element = new JPanel() {
            private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
				super.paintComponent(g);
                Dimension arcs = new Dimension(100, 100);
                int width = getWidth();
                int height = getHeight();
                Graphics2D graphics = (Graphics2D) g;
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


                //Draws the rounded opaque panel with borders.
                graphics.setColor(Color.decode("#F5E4DA"));
                graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint background
                graphics.setColor(Color.white);
                graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);//paint border
            }
        };
        element.setBackground(new Color(0, 0, 0, 0));
        return element;
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
