package System;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Payment extends JFrame{
	
	JTable table = null;
	Vector<Cha> list = null;
	Vector<Vector<String>> jang = null;
	Vector<String>option = null;
	
	
	public JButton pay = new JButton();
	public JButton cancel = new JButton();
	public JLabel text = new JLabel();
	
	public Payment(int total, Vector<Cha> list) {
		super("결제하기");
		setLayout(null);
		setBounds(Frame.W/2-400/2, Frame.H/2-600/2, 400, 500);
		setBackground(Color.white);
		this.list = list;
		setTable();
		setButton();
		setText(total);
		setVisible(true);
		revalidate();
	}
	
	public void setTable() {
		
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
			this.jang.add(temp);
		}
		
		table = new JTable(jang, option);
		table.setGridColor(Color.black);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 300, 200);
		js.setAutoscrolls(true);
		
		add(js);
	}

	private void setText(int total) {
		this.text.setBounds(60, 280, 300, 50);
		this.text.setText(String.format("결제금액 : %d원", total));
		this.text.setFont(new Font("",Font.BOLD,30));
		add(this.text);
	}

	private void setButton() {
		this.pay.setBounds(50, 350, 80, 50);
		this.pay.setText("결제");
		this.pay.setFont(new Font("",Font.PLAIN,20));
		add(this.pay);
		
		this.cancel.setBounds(250, 350, 80, 50);
		this.cancel.setText("취소");
		this.cancel.setFont(new Font("",Font.PLAIN,20));
		add(this.cancel);
	}
}
