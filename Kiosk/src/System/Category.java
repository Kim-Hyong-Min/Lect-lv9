package System;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Category extends Util{
	
	private JButton[] menu = new JButton[9];
	private ImageIcon[] image = null;
	
	public Category() {
		setLayout(null);
		setBounds(0, 250, 600, 700);
		setButton();
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
			// 블랙 밀크티+펄
			// 타로 밀크티+펄
			// 피스타치오 밀크티+펄
			// 제주 그린 밀크티+펄
			// 망고 요구르트+화이트펄
			// 청포도 그린티+알로에
			setImage(6, "콤비네이션");
			menuButton(6);
		}
		else if(num == 1) { // 시즌 매뉴
			// 호지 밀크티+펄
			setImage(1, "시즌 메뉴");
			menuButton(1);
		}
		else if(num == 2) { // 밀크티
//			블랙 밀크티
//			얼그레이 밀크티
//			우롱 밀크티
//			자스민 그린 밀크티
//			제주 그린 밀크티
//			초콜렛 밀크티
//			타로 밀크티
//			피스타치오 밀크티
			setImage(8, "밀크티");
			menuButton(8);
		}
		else if(num == 3) { // 오리지널 티
//			블랙티
//			얼그레이티
//			우롱티
//			자스민 그린티
			setImage(4, "오리지널 티");
			menuButton(4);
		}
		else if(num == 4) { // 스무디
//			돌체 크러쉬 위드 샷
//			딸기 쿠키 스무디
//			망고 스무디
//			제주 그린티 스무디
//			청포도 스무디
//			초코 쿠앤크 스무디
//			초코바른 제주 그린 스무디
//			초코바른 초코 스무디
//			초코바른 피스타치오 스무디
			setImage(9, "스무디");
			menuButton(9);
		}
		else if(num == 5) { // 쥬얼리
			menuButton(5);
		}
		else if(num == 6) { // 과일믹스
			menuButton(6);
		}
		else if(num == 7) { // 커 피
			menuButton(6);
		}
		else if(num == 8) { // 베이커리
			menuButton(6);
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
//				add(new PopUp());
				System.out.println(i);
			}
		}
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
