package System;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Manager  extends JFrame{
	private Vector<Vector<Cha>> temp = new Vector<>();

	Vector<Vector<String>> jang = null;
	Vector<String>option = null;
	private int totalMoney;
	private JLabel total = new JLabel();
	JTable table = null;
	
	public JButton exit = new JButton();
	
	public Manager(Vector<Vector<Cha>> temp) {
		super("�Ǹ� ��Ȳ");
		setLayout(null);
		setBounds(Frame.W/2-500/2, Frame.H/2-950/2, 500, 950);
		setBackground(Color.white);
		for(int i=0; i<temp.size(); i++) {
			this.temp.add(temp.get(i));
		}
		setText();
		setButton();
		setTable();
		setVisible(true);
		revalidate();
	}
	
	private void setButton() {
		this.exit.setBounds(200, 800, 100, 60);
		this.exit.setText("Ȯ�οϷ�");
		this.exit.setFont(new Font("", Font.PLAIN, 15));
		add(this.exit);
	}

	private void setText() {
		this.total.setBounds(100, 700, 300, 50);
		this.total.setFont(new Font("", Font.BOLD, 30));
		add(this.total);
	}

	public void setTable() {
		this.totalMoney = 0;
		this.jang = new Vector();
		for(int j=0; j<this.temp.size(); j++) {
			Vector<Cha> list = this.temp.get(j);
			this.option = new Vector();
			option.add("ǰ��");
			option.add("�ɼ�1");
			option.add("�ɼ�2");
			option.add("�ɼ�3");
			option.add("����");
			option.add("����");
			
			for(int i=0; i<list.size(); i++) {
				Vector<String>temp = new Vector();
				temp.add(list.get(i).getName());
				
				if(list.get(i).getOption1()==0)
					temp.add("COLD(����)");
				else if(list.get(i).getOption1()==1)
					temp.add("COLD(����)");
				else if(list.get(i).getOption1()==2)
					temp.add("HOT(����)");
				else if(list.get(i).getOption1()==3)
					temp.add("HOT(����)");
				
				if(list.get(i).getOption2()==0)
					temp.add("ICE(FULL)");
				else if(list.get(i).getOption2()==1)
					temp.add("ICE(REGULAR)");
				else if(list.get(i).getOption2()==2)
					temp.add("ICE(LESS)");
				
				if(list.get(i).getOption3()==0)
					temp.add("�絵(100%)");
				else if(list.get(i).getOption3()==1)
					temp.add("�絵(70%)");
				else if(list.get(i).getOption3()==2)
					temp.add("�絵(50%)");
				else if(list.get(i).getOption3()==3)
					temp.add("�絵(30%)");
				else if(list.get(i).getOption3()==4)
					temp.add("�絵(0%)");
				
				temp.add(String.valueOf(list.get(i).getNum())+"��");
				temp.add(String.valueOf(list.get(i).getPrice())+"��");
				this.totalMoney += list.get(i).getPrice();
				this.jang.add(temp);
			}
			
		}
		
		table = new JTable(jang, option);
		table.setGridColor(Color.black);
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 400, 600);
		js.setAutoscrolls(true);
		
		add(js);
		this.total.setText(String.format("�� ����� : %d��", this.totalMoney));
	}
	
}
