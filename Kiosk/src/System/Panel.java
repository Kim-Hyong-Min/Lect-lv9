package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Panel extends Util{
	private JLabel text1 = new JLabel();
	private JLabel[] menuText = new JLabel[9];
	
	private int category;
	private Category cate = new Category();
	
	public Panel() {
		setLayout(null);
		setBounds(0, 0, 700, 1000);
		add(this.cate);
		addMouseListener(this);
		addMouseMotionListener(this);
		setText();
	}
	
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
			System.out.println(0);
			this.category = 0;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=200 && e.getX()<=350 && e.getY()>=80 && e.getY()<=110) {
			System.out.println(1);
			this.category = 1;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=350 && e.getX()<=500 && e.getY()>=80 && e.getY()<=110) {
			System.out.println(2);
			this.category = 2;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=500 && e.getX()<=650 && e.getY()>=80 && e.getY()<=110) {
			System.out.println(3);
			this.category = 3;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=50 && e.getX()<=200 && e.getY()>=130 && e.getY()<=160) {
			System.out.println(4);
			this.category = 4;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=200 && e.getX()<=350 && e.getY()>=130 && e.getY()<=160) {
			System.out.println(5);
			this.category = 5;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=350 && e.getX()<=500 && e.getY()>=130 && e.getY()<=160) {
			System.out.println(6);
			this.category = 6;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=500 && e.getX()<=650 && e.getY()>=130 && e.getY()<=160) {
			System.out.println(7);
			this.category = 7;
			this.cate.setMenu(category);
		}
		else if(e.getX()>=50 && e.getX()<=200 && e.getY()>=180 && e.getY()<=210) {
			System.out.println(8);
			this.category = 8;
			this.cate.setMenu(category);
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
		
		int x = 50;
		int y = 80;
		for(int i=0; i<9; i++) {
			g.setColor(Color.blue);
			g.drawRect(x, y, 150, 30);
				x += 150;
			
			if((i+1)%4==0) {
				y += 50;
				x = 50;
			}
		}
		
		repaint();
	}

	
	
	
	
}
