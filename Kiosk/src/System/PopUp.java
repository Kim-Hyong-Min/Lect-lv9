package System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class PopUpPanel extends Util{
	
	private JButton[] drink = new JButton[4];
	private JButton[] ice = new JButton[3];
	private JButton[] sugar = new JButton[5];
	
	private JLabel[] drinkText = new JLabel[4];
	private JLabel[] iceText = new JLabel[3];
	private JLabel[] sugarText = new JLabel[5];
	
	
	private JLabel cntText = new JLabel();
	private JLabel cntNum = new JLabel();
	public int cnt;
	private JButton[] cntBtn = new JButton[2];
	
	public int[] onOff1 = new int[4];
	public boolean onCheck1;
	public int[] onOff2 = new int[3];
	public boolean onCheck2;
	public int[] onOff3 = new int[5];
	public boolean onCheck3;
	
	public JButton add = new JButton();
	public JButton delete = new JButton();
	
	public PopUpPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 950);
		setBackground(Color.white);
		
		setButton();
		setText();
		setCnt();
	}
	
	
	
	private void setCnt() {
		this.cntText.setBounds(210, 600, 100, 50);
		this.cntText.setText("수량");
		this.cntText.setFont(new Font("", Font.BOLD, 30));
		add(this.cntText);
		
		this.cntNum.setBounds(235, 650, 100, 50);
		this.cntNum.setFont(new Font("", Font.BOLD, 30));
		add(this.cntNum);
		
		int x = 135;
		int y = 650;
		for(int i=0; i<this.cntBtn.length; i++) {
			this.cntBtn[i] = new JButton();
			if(i==0) {
				this.cntBtn[i].setText("<");
			}
			else {
				this.cntBtn[i].setText(">");
			}
			this.cntBtn[i].setFont(new Font("", Font.BOLD, 30));
			this.cntBtn[i].setBounds(x, y, 70, 50);
			this.cntBtn[i].addActionListener(this);
			add(this.cntBtn[i]);
			x += 150;
		}
	}



	private void setText() {
		String[] text1 = {"COLD(매장)","COLD(포장)","HOT(매장)","HOT(포장)"};
		
		int x = 60;
		int y = 110;
		for(int i=0; i<this.drinkText.length; i++) {
			this.drinkText[i] = new JLabel();
			this.drinkText[i].setBounds(x, y, 80, 80);
			this.drinkText[i].setText(text1[i]);
			add(this.drinkText[i]);
			x += 100;
		}
		
		String[] text2 = {"ICE(FULL)","ICE(REGULAR)","ICE(LESS)"};
		
		x = 60;
		y = 300;
		for(int i=0; i<this.iceText.length; i++) {
			this.iceText[i] = new JLabel();
			this.iceText[i].setBounds(x, y, 80, 80);
			this.iceText[i].setText(text2[i]);
			add(this.iceText[i]);
			if(i==1)
				x += 160;
			else
				x += 140;
		}
		
		String[] text3 = {"당도(100%)","당도(70%)","당도(50%)","당도(30%)","당도(0%)"};
		
		x = 30;
		y = 500;
		for(int i=0; i<this.sugarText.length; i++) {
			this.sugarText[i] = new JLabel();
			this.sugarText[i].setBounds(x, y, 80, 80);
			this.sugarText[i].setText(text3[i]);
			add(this.sugarText[i]);
			x += 90;
		}
		
	}
	private void setButton() {
		int x = 50;
		int y = 60;
		for(int i=0; i<this.drink.length; i++) {
			this.drink[i] = new JButton();
			this.drink[i].setBounds(x, y, 80, 80);
			this.drink[i].addActionListener(this);
			Image image = new ImageIcon(String.format("image/Menu/%d.png",i)).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			ImageIcon im = new ImageIcon(image);
			this.drink[i].setIcon(im);
			add(this.drink[i]);
			x += 100;
		}
		
		x = 50;
		y = 250;
		for(int i=0; i<this.ice.length; i++) {
			this.ice[i] = new JButton();
			this.ice[i].setBounds(x, y, 80, 80);
			this.ice[i].addActionListener(this);
			Image image = new ImageIcon(String.format("image/Menu/%d.png",i+4)).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			ImageIcon im = new ImageIcon(image);
			this.ice[i].setIcon(im);
			add(this.ice[i]);
			x += 150;
		}
		
		x = 20;
		y = 450;
		for(int i=0; i<this.sugar.length; i++) {
			this.sugar[i] = new JButton();
			this.sugar[i].setBounds(x, y, 80, 80);
			this.sugar[i].addActionListener(this);
			Image image = new ImageIcon(String.format("image/Menu/%d.png",i+7)).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			ImageIcon im = new ImageIcon(image);
			this.sugar[i].setIcon(im);
			add(this.sugar[i]);
			x += 90;
		}
		
		this.delete.setBounds(100, 800, 100, 70);
		this.delete.setText("취소");
		this.delete.setFont(new Font("", Font.BOLD, 20));
//		this.delete.addActionListener(this);
		add(this.delete);
		
		this.add.setBounds(300, 800, 100, 70);
		this.add.setText("담기");
		this.add.setFont(new Font("", Font.BOLD, 20));
//		this.add.addActionListener(this);
		add(this.add);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<this.drink.length; i++) {
			if(e.getSource() == this.drink[i]) {
				if(this.onCheck1==true) {
					this.onOff1 = new int[4];
				}
				this.onOff1[i] = 1;
				this.onCheck1=true;
			}
		}
		
		for(int i=0; i<this.ice.length; i++) {
			if(e.getSource() == this.ice[i]) {
				if(this.onCheck2==true) {
					this.onOff2 = new int[3];
				}
				this.onOff2[i] = 1;
				this.onCheck2=true;
			}
		}
		
		for(int i=0; i<this.sugar.length; i++) {
			if(e.getSource() == this.sugar[i]) {
				if(this.onCheck3==true) {
					this.onOff3 = new int[5];
				}
				this.onOff3[i] = 1;
				this.onCheck3=true;
			}
		}
		
		for(int i=0; i<this.cntBtn.length; i++) {
			if(e.getSource() == this.cntBtn[i]) {
				if(i==0 && this.cnt>0) {
					this.cnt--;
				}
				else if(i==1){
					this.cnt++;
				}
			}
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.cntNum.setText(String.format("%d", this.cnt));
		int x = 75;
		int y = 20;
		for(int i=0; i<this.onOff1.length; i++) {
			if(this.onOff1[i] == 0) {
				Image image = new ImageIcon("image/Menu/OFF.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			else {
				Image image = new ImageIcon("image/Menu/ON.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			x+=100;
		}
		
		x = 75;
		y = 210;
		for(int i=0; i<this.onOff2.length; i++) {
			if(this.onOff2[i] == 0) {
				Image image = new ImageIcon("image/Menu/OFF.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			else {
				Image image = new ImageIcon("image/Menu/ON.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			x+=150;
		}
		
		x = 47;
		y = 410;
		for(int i=0; i<this.onOff3.length; i++) {
			if(this.onOff3[i] == 0) {
				Image image = new ImageIcon("image/Menu/OFF.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			else {
				Image image = new ImageIcon("image/Menu/ON.png").getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
				ImageIcon im = new ImageIcon(image);
				g.drawImage(image, x, y, null);
			}
			x+=90;
		}
		
		repaint();
	}
	
}

public class PopUp extends JFrame{
	PopUpPanel up = new PopUpPanel();
	
	public PopUp() {
		super("Option");
		setLayout(null);
		setBounds(Frame.W/2-500/2, Frame.H/2-950/2, 500, 950);
		
		add(up);
		
		setVisible(true);
		revalidate();
	}
}
