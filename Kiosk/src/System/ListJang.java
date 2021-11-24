package System;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;


public class ListJang extends JFrame{
	
	Vector<Cha> list = null;
	Vector<Vector<String>> jang = null;
	Vector<String>option = null;
	JTable table = null;
	public int total; // 금액
	public int cnt; // 주문 순서
	
	public JLabel totalPrice = new JLabel();
	public JLabel idx = new JLabel();
	
	
	public JButton btn = new JButton();
	public JButton deleteBtn = new JButton();
	public JButton[] upDown = new JButton[2];
	
	public ListJang(Vector<Cha> list) {
		super("장바구니");
		this.list = list;
		setLayout(null);
		setBounds(Frame.W/2-500/2, Frame.H/2-950/2, 500, 950);
		setBackground(Color.white);
		
		setTable();
		setButton();
		setText();
		setVisible(true);
		revalidate();
	}
	
	private void setText() {
		this.totalPrice.setBounds(50, 700, 200, 50);
		this.totalPrice.setFont(new Font("", Font.BOLD, 20));
		add(this.totalPrice);
		
		this.idx.setText(String.valueOf(cnt+1));
		this.idx.setBounds(350, 700, 100, 50);
		this.idx.setFont(new Font("", Font.BOLD, 30));
		add(this.idx);
		
	}

	public void setTable() {
		this.total = 0;
		
		this.option = new Vector();
		option.add("품명");
		option.add("옵션1");
		option.add("옵션2");
		option.add("옵션3");
		option.add("수량");
		option.add("가격");
		
		this.jang = new Vector();
		
		for(int i=0; i<list.size(); i++) {
			Vector<String>temp = new Vector();
			temp.add(this.list.get(i).getName());
			
			if(this.list.get(i).getOption1()==0)
				temp.add("COLD(매장)");
			else if(this.list.get(i).getOption1()==1)
				temp.add("COLD(포장)");
			else if(this.list.get(i).getOption1()==2)
				temp.add("HOT(매장)");
			else if(this.list.get(i).getOption1()==3)
				temp.add("HOT(포장)");
			
			if(this.list.get(i).getOption2()==0)
				temp.add("ICE(FULL)");
			else if(this.list.get(i).getOption2()==1)
				temp.add("ICE(REGULAR)");
			else if(this.list.get(i).getOption2()==2)
				temp.add("ICE(LESS)");
			
			if(this.list.get(i).getOption3()==0)
				temp.add("당도(100%)");
			else if(this.list.get(i).getOption3()==1)
				temp.add("당도(70%)");
			else if(this.list.get(i).getOption3()==2)
				temp.add("당도(50%)");
			else if(this.list.get(i).getOption3()==3)
				temp.add("당도(30%)");
			else if(this.list.get(i).getOption3()==4)
				temp.add("당도(0%)");
			
			temp.add(String.valueOf(this.list.get(i).getNum())+"개");
			temp.add(String.valueOf(this.list.get(i).getPrice())+"원");
			this.total += this.list.get(i).getPrice();
			this.jang.add(temp);
		}
		
		table = new JTable(jang, option);
		table.setGridColor(Color.black);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 400, 600);
		js.setAutoscrolls(true);
		
		add(js);
		this.totalPrice.setText(String.format("총 금액 : %d원", this.total));
	}

	private void setButton() {
		this.btn.setBounds(100, 800, 80, 50);
		this.btn.setText("확인");
		this.btn.setFont(new Font("", Font.BOLD, 20));
		add(this.btn);
		
		this.deleteBtn.setBounds(300, 800, 80, 50);
		this.deleteBtn.setText("삭제");
		this.deleteBtn.setFont(new Font("", Font.BOLD, 20));
		add(this.deleteBtn);
		
		int x = 0;
		int y = 0;
		for(int i=0; i<this.upDown.length; i++) {
			this.upDown[i] = new JButton();
			if(i==0) {
				this.upDown[i].setBounds(270, 700, 50, 50);
				this.upDown[i].setText("▲");
			}
			else {
				this.upDown[i].setBounds(400, 700, 50, 50);
				this.upDown[i].setText("▼");
			}
			this.upDown[i].setFont(new Font("", Font.PLAIN, 15));
			add(this.upDown[i]);
		}
	}
}

