package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Panel extends Util{
	public static Vector<Vector<Cha>> list = new Vector<>();
	private JLabel text1 = new JLabel();
	private JLabel[] menuText = new JLabel[9];
	
	private int category;
	
	private int totalMoney;
	
	Vector<Cha> jang = new Vector<>();
	private ListJang listjang = null;
	private JButton[] menu = new JButton[9];
	private ImageIcon[] image = null;
	private PopUp pop = null;
	
	private int cateNum;
	private int menuNum;
	private JLabel[] Text = new JLabel[9];
	private Menu title = new Menu();
	
	private Payment pay = null;
	private int payMoney;
	
	private Login login = null;
	private String id = "qwer";
	private String pw = "1234";
	
	private Manager manager = null;
	
	public Panel() {
		setLayout(null);
		setBounds(0, 0, 700, 1000);
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		setText();
		
		setButton();
		setCateText();
	}
	
	private void setCateText() {
		int x = 60;
		int y = 440;
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
		int y = 260;
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
		int y = 260;
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
		
		if(this.listjang != null && e.getSource() == this.listjang.btn) {
					System.out.println("확인");
					this.listjang.dispose();
		}
				
		if(this.listjang != null && e.getSource() == this.listjang.deleteBtn) { // 주문 삭제
			if(this.jang.size()>0) {
				this.jang.remove(this.listjang.cnt);
				this.listjang.setTable();
				this.listjang.cnt = 0;
				this.payMoney = this.listjang.total;
				this.listjang.idx.setText(String.valueOf(this.listjang.cnt+1));
			}
		}
		
		if(this.listjang != null && e.getSource() == this.listjang.upDown[0] && this.listjang.cnt<this.jang.size()-1) {
			this.listjang.cnt++;
			this.listjang.idx.setText(String.valueOf(this.listjang.cnt+1));
		}
		
		if(this.listjang != null && e.getSource() == this.listjang.upDown[1] && this.listjang.cnt>0) {
			this.listjang.cnt--;
			this.listjang.idx.setText(String.valueOf(this.listjang.cnt+1));
		}
		
		if(this.pay != null && e.getSource() == this.pay.pay ) {
			JOptionPane.showMessageDialog(null, "결제 완료!");
			this.totalMoney += this.payMoney;
			this.payMoney = 0;
			list.add(jang);
			this.jang = new Vector<>();
			System.out.println(list.size());
			this.pay.dispose();
		}
		
		if(this.pay != null && e.getSource() == this.pay.cancel ) {
			this.pay.dispose();
		}
		
		
		if(this.pop != null && e.getSource() == this.pop.up.add) {
			if(this.pop.up.onCheck1 && this.pop.up.onCheck2 && this.pop.up.onCheck3 && this.pop.up.cnt>0) {
				addJang(menuNum);
				this.pop.dispose();

			}
			else {
				JOptionPane.showMessageDialog(null, "옵션과 수량을 확인해 주세요.");
			}
		}
		
		if(this.pop != null && e.getSource() == this.pop.up.delete) {
			this.pop.dispose();
		}
		
		if(this.login != null && this.login.in == e.getSource()) {
			if(this.login.id.getText().equals(id) && this.login.pw.getText().equals(pw)) {
				this.login.dispose();
				this.manager = new Manager(this.list);
				this.manager.exit.addActionListener(this);
			}
			else {
				JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호를 확인해 주세요.");
			}
		}
		
		if(this.login != null && this.login.reset == e.getSource()) {
			this.login.dispose();
		}
		
		if(this.manager != null && this.manager.exit == e.getSource()) {
			this.manager.dispose();
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
		this.payMoney += tempPrice[idx]*this.pop.up.cnt;
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
	}
	
	/////////////////////////////////////////////////////////////////////////

	private void setText() {
		
		String[] menu = {"콤비네이션","시즌 메뉴","밀크티","오리지널 티","스무디","쥬얼리","과일믹스","커 피","베이커리"};

		for(int i=0; i<9; i++) {
			this.menuText[i] = new JLabel();
			this.menuText[i].setText(menu[i]);
			if(i==0) 
				this.menuText[i].setBounds(60, 80, 150, 30);
			else if(i==1)
				this.menuText[i].setBounds(220, 80, 150, 30);
			else if(i==2)
				this.menuText[i].setBounds(390, 80, 150, 30);
			else if(i==3)
				this.menuText[i].setBounds(510, 80, 150, 30);
			else if(i==4)
				this.menuText[i].setBounds(90, 130, 150, 30);
			else if(i==5)
				this.menuText[i].setBounds(240, 130, 150, 30);
			else if(i==6)
				this.menuText[i].setBounds(375, 130, 150, 30);
			else if(i==7)
				this.menuText[i].setBounds(550, 130, 150, 30);
			else if(i==8)
				this.menuText[i].setBounds(75, 180, 150, 30);
			this.menuText[i].setFont(new Font("", Font.BOLD, 25));
			
			add(this.menuText[i]);
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		if(e.getX()>=50 && e.getX()<=200 && e.getY()>=80 && e.getY()<=110) {
			this.category = 0;
			this.setMenu(category);
		}
		else if(e.getX()>=200 && e.getX()<=350 && e.getY()>=80 && e.getY()<=110) {
			this.category = 1;
			this.setMenu(category);
		}
		else if(e.getX()>=350 && e.getX()<=500 && e.getY()>=80 && e.getY()<=110) {
			this.category = 2;
			this.setMenu(category);
		}
		else if(e.getX()>=500 && e.getX()<=650 && e.getY()>=80 && e.getY()<=110) {
			this.category = 3;
			this.setMenu(category);
		}
		else if(e.getX()>=50 && e.getX()<=200 && e.getY()>=130 && e.getY()<=160) {
			this.category = 4;
			this.setMenu(category);
		}
		else if(e.getX()>=200 && e.getX()<=350 && e.getY()>=130 && e.getY()<=160) {
			this.category = 5;
			this.setMenu(category);
		}
		else if(e.getX()>=350 && e.getX()<=500 && e.getY()>=130 && e.getY()<=160) {
			this.category = 6;
			this.setMenu(category);
		}
		else if(e.getX()>=500 && e.getX()<=650 && e.getY()>=130 && e.getY()<=160) {
			this.category = 7;
			this.setMenu(category);
		}
		else if(e.getX()>=50 && e.getX()<=200 && e.getY()>=180 && e.getY()<=210) {
			this.category = 8;
			this.setMenu(category);
		}
		else if(e.getX()>=600 && e.getX()<=680 && e.getY()>=210 && e.getY()<=290) {
			if(this.jang.size()>0) {
				this.listjang = new ListJang(this.jang);
				this.listjang.btn.addActionListener(this);
				this.listjang.deleteBtn.addActionListener(this);
				for(int i=0; i<this.listjang.upDown.length; i++) {
					this.listjang.upDown[i].addActionListener(this);
				}
			}
		}
		else if(e.getX()>=600 && e.getX()<=680 && e.getY()>=800 && e.getY()<=880) {
			if(this.jang.size()>0) {
				this.pay = new Payment(payMoney, this.jang);
				this.pay.pay.addActionListener(this);
				this.pay.cancel.addActionListener(this);
			}
		}
		else if(e.getX()>=470 && e.getX()<=600 && e.getY()>=10 && e.getY()<=50) {
			System.out.println("관리자 로그인");
			this.login = new Login();
			this.login.id.setFocusable(true);
			this.login.id.addKeyListener(this);
			this.login.pw.setFocusable(true);
			this.login.pw.addKeyListener(this);
			
			this.login.in.addActionListener(this);
			this.login.reset.addActionListener(this);
		}
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		
		g.setColor(Color.red);
		g.fillRect(600, 200, 80, 600);
		Image image = new ImageIcon("image/Menu/결제하기.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon im = new ImageIcon(image);
		g.drawImage(im.getImage(), 600, 800, null);
		
		image = new ImageIcon("image/Menu/상단바.png").getImage().getScaledInstance(540, 60, Image.SCALE_SMOOTH);
		im = new ImageIcon(image);
		g.drawImage(im.getImage(), 70, 0, null);
		
		image = new ImageIcon("image/Menu/장바구니.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		im = new ImageIcon(image);
		g.drawImage(im.getImage(), 600, 210, null);
		
		
//		int x = 50;
//		int y = 80;
//		for(int i=0; i<9; i++) {
//			g.setColor(Color.blue);
//			g.drawRect(x, y, 150, 30);
//				x += 150;
//			
//			if((i+1)%4==0) {
//				y += 50;
//				x = 50;
//			}
//		}
//		
//		g.setColor(Color.blue);
//		g.drawRect(470, 10, 130, 40);
		
		repaint();
	}

	
	
	
	
}
