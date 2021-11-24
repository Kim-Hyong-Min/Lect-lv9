package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Category extends Util{
	public static Category instance = new Category();
	Vector<Cha> jang = new Vector<>();
	private ListJang list = null;
	private JButton[] menu = new JButton[9];
	private ImageIcon[] image = null;
	private PopUp pop = null;
	
	public boolean jangCheck;
	private int cateNum;
	private int menuNum;
	private JLabel[] Text = new JLabel[9];
	private Menu title = new Menu();
	
	public Category() {
		setLayout(null);
		setBounds(0, 250, 600, 700);
		setBackground(Color.white);
		setButton();
		setText();
	}
	
	private void setText() {
		int x = 60;
		int y = 190;
		for(int i=0; i<this.Text.length; i++) {
			this.Text[i] = new JLabel();
			this.Text[i].setBounds(x, y, 200, 30);
			this.Text[i].setFont(new Font("", Font.PLAIN, 15));
			this.Text[i].setText("");
			add(this.Text[i]);
			x += 37*4+20;
			if((i+1)%3==0) {
				y += 44*4+30;
				x = 60;
			}
		}
	}
	
	private void setButton() {
		int x = 50;
		int y = 10;
		for(int i=0; i<this.menu.length; i++) {
			this.menu[i] = new JButton();
			this.menu[i].setBounds(x, y, 0, 0);
			this.menu[i].addActionListener(this);
			add(this.menu[i]);
			x += 37*4+20;
			if((i+1)%3==0) {
				y += 44*4+30;
				x = 50;
			}
		}
	}

	private void resetButton() {
		int x = 50;
		int y = 10;
		for(int i=0; i<this.menu.length; i++) {
			this.menu[i].setBounds(x, y, 0, 0);
			x += 37*4+20;
			if((i+1)%3==0) {
				y += 44*4+30;
				x = 50;
			}
		}
	}

	public void setMenu(int num) {
		
		if(num == 0) { // 콤비네이션
			setImage(6, "콤비네이션");
			menuButton(6);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 1) { // 시즌 매뉴
			// 호지 밀크티+펄
			setImage(1, "시즌 메뉴");
			menuButton(1);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 2) { // 밀크티
			setImage(8, "밀크티");
			menuButton(8);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 3) { // 오리지널 티
			setImage(4, "오리지널 티");
			menuButton(4);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 4) { // 스무디
			setImage(9, "스무디");
			menuButton(9);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 5) { // 쥬얼리
			setImage(5, "쥬얼리");
			menuButton(5);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 6) { // 과일믹스
			setImage(6, "과일믹스");
			menuButton(6);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 7) { // 커 피
			setImage(6, "커피");
			menuButton(6);
			menuText(num);
			this.cateNum = num;
		}
		else if(num == 8) { // 베이커리
			setImage(6, "베이커리");
			menuButton(6);
			menuText(num);
			this.cateNum = num;
		}
	}
	
	private void menuText(int idx) {
		for(int i=0; i<this.Text.length; i++) {
			this.Text[i].setText("");
		}
		String[] temp = null;
		if(idx==0)
			temp = this.title.getList1();
		else if(idx==1)
			temp = this.title.getList2();
		else if(idx==2)
			temp = this.title.getList3();
		else if(idx==3)
			temp = this.title.getList4();
		else if(idx==4)
			temp = this.title.getList5();
		else if(idx==5)
			temp = this.title.getList6();
		else if(idx==6)
			temp = this.title.getList7();
		else if(idx==7)
			temp = this.title.getList8();
		else if(idx==8)
			temp = this.title.getList9();
		
		for(int i=0; i<temp.length; i++) {
			this.Text[i].setText(temp[i]);
		}
	}

	private void menuButton(int num) {
		resetButton();
		int x = 50;
		int y = 10;
		for(int i=0; i<num; i++) {
			this.menu[i].setBounds(x, y, 37*4, 44*4);
			this.menu[i].setIcon(this.image[i]);
			x += 37*4+20;
			if((i+1)%3==0) {
				y += 44*4+30;
				x = 50;
			}
		}
	}

	private void setImage(int num, String text) {
		this.image = new ImageIcon[num];
		for(int i=0; i<num; i++) {
			Image image = new ImageIcon(String.format("image/%s/%d.png", text, i)).getImage().getScaledInstance(37*4, 44*4, Image.SCALE_SMOOTH);
			ImageIcon im = new ImageIcon(image);
			this.image[i] = im;;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0; i<this.menu.length; i++) {
			if(e.getSource() == this.menu[i]) {
				this.menuNum = i;
				this.pop = new PopUp();
				this.pop.up.add.addActionListener(this);
				this.pop.up.delete.addActionListener(this);
			}
		}
		
		if(this.jangCheck) {
			if(this.jang.size()>0) {
				this.list = new ListJang(this.jang);
				this.list.btn.addActionListener(this);
				this.list.deleteBtn.addActionListener(this);
				for(int i=0; i<this.list.upDown.length; i++) {
					this.list.upDown[i].addActionListener(this);
				}
			}
			if(e.getSource() == this.list.btn) {
				
			}
			
			if(e.getSource() == this.list.deleteBtn) {
				this.list.dispose();
				this.jangCheck = false;
			}
		}
		
		
		if(e.getSource() == this.pop.up.add) {
			if(this.pop.up.onCheck1 && this.pop.up.onCheck2 && this.pop.up.onCheck3 && this.pop.up.cnt>0) {
				addJang(menuNum);
				this.pop.dispose();

			}
			else {
				JOptionPane.showMessageDialog(null, "옵션과 수량을 확인해 주세요.");
			}
		}
		
		if(e.getSource() == this.pop.up.delete) {
			this.pop.dispose();
		}
	}
	
	private void addJang(int idx){
		String[]temp = null;
		int[]tempPrice = null;
		
		if(cateNum==0) {
			temp = this.title.getList1();
		tempPrice = this.title.getPrice1();
		}
		else if(cateNum==1) {
			temp = this.title.getList2();
		tempPrice = this.title.getPrice2();
		}
		else if(cateNum==2) {
			temp = this.title.getList3();
		tempPrice = this.title.getPrice3();
		}
		else if(cateNum==3) {
			temp = this.title.getList4();
		tempPrice = this.title.getPrice4();
		}
		else if(cateNum==4) {
			temp = this.title.getList5();
		tempPrice = this.title.getPrice5();
		}
		else if(cateNum==5) {
			temp = this.title.getList6();
		tempPrice = this.title.getPrice6();
		}
		else if(cateNum==6) {
			temp = this.title.getList7();
		tempPrice = this.title.getPrice7();
		}
		else if(cateNum==7) {
			temp = this.title.getList8();
		tempPrice = this.title.getPrice8();
		}
		else if(cateNum==8) {
			temp = this.title.getList9();
		tempPrice = this.title.getPrice9();
		}
		
		Cha t = new Cha();
		t.setName(temp[idx]);
		t.setPrice(tempPrice[idx]*this.pop.up.cnt);
		int check = 0;
		for(int i=0; i<this.pop.up.onOff1.length; i++) {
			if(this.pop.up.onOff1[i] != 0) {
				check = i;
			}
		}
		t.setOption1(check);
		check = 0;
		for(int i=0; i<this.pop.up.onOff2.length; i++) {
			if(this.pop.up.onOff2[i] != 0) {
				check = i;
			}
		}
		t.setOption2(check);
		check = 0;
		for(int i=0; i<this.pop.up.onOff3.length; i++) {
			if(this.pop.up.onOff3[i] != 0) {
				check = i;
			}
		}
		t.setOption3(check);
		t.setNum(this.pop.up.cnt);
		this.jang.add(t);
		System.out.println(this.jang.size());
	}

}
