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
		
		if(num == 0) { // �޺���̼�
			// �� ��ũƼ+��
			// Ÿ�� ��ũƼ+��
			// �ǽ�Ÿġ�� ��ũƼ+��
			// ���� �׸� ��ũƼ+��
			// ���� �䱸��Ʈ+ȭ��Ʈ��
			// û���� �׸�Ƽ+�˷ο�
			setImage(6, "�޺���̼�");
			menuButton(6);
		}
		else if(num == 1) { // ���� �Ŵ�
			// ȣ�� ��ũƼ+��
			setImage(1, "���� �޴�");
			menuButton(1);
		}
		else if(num == 2) { // ��ũƼ
//			�� ��ũƼ
//			��׷��� ��ũƼ
//			��� ��ũƼ
//			�ڽ��� �׸� ��ũƼ
//			���� �׸� ��ũƼ
//			���ݷ� ��ũƼ
//			Ÿ�� ��ũƼ
//			�ǽ�Ÿġ�� ��ũƼ
			setImage(8, "��ũƼ");
			menuButton(8);
		}
		else if(num == 3) { // �������� Ƽ
//			��Ƽ
//			��׷���Ƽ
//			���Ƽ
//			�ڽ��� �׸�Ƽ
			setImage(4, "�������� Ƽ");
			menuButton(4);
		}
		else if(num == 4) { // ������
//			��ü ũ���� ���� ��
//			���� ��Ű ������
//			���� ������
//			���� �׸�Ƽ ������
//			û���� ������
//			���� ���ũ ������
//			���ڹٸ� ���� �׸� ������
//			���ڹٸ� ���� ������
//			���ڹٸ� �ǽ�Ÿġ�� ������
			setImage(9, "������");
			menuButton(9);
		}
		else if(num == 5) { // ���
			menuButton(5);
		}
		else if(num == 6) { // ���Ϲͽ�
			menuButton(6);
		}
		else if(num == 7) { // Ŀ ��
			menuButton(6);
		}
		else if(num == 8) { // ����Ŀ��
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
