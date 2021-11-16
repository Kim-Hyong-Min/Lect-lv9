package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



class GrimPann extends MyUtil{
	private Rect rect = null;
	private ArrayList<Rect> rects = new ArrayList<>();
	private int startX, startY;
	private boolean shift;
	
	private final int RECTANGLE = 0;
	private final int CIRCLE = 1;
	private final int TRIANGLE = 2;
	
	String[] btnText = {"□","○","△"};
	JButton[] btn = new JButton[3];
	private int type;
	
	public GrimPann() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		
		setButton();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	private void setButton() {
		int x = 30;
		int y = 50;
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setText(this.btnText[i]);
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].addActionListener(this);
			add(this.btn[i]);
			x+=50;
		}
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// sample triangle
		// g.drawPolygon(int[], int[], int)
		// 1. x좌표의 배열
		// 2. y좌표의 배열
		// 3. 꼭지점 개수
		int[] xx = new int[3];
		int[] yy = new int[3];
		xx[0] = 100;
		yy[0] = 100;
		xx[1] = 150;
		yy[1] = 200;
		xx[2] = 50;
		yy[2] = 200;
		g.setColor(Color.pink);
		g.drawPolygon(xx, yy, 3);
		
		//this.rect : 임시 객체 -> 
		if(this.rect != null) {
			g.setColor(this.rect.getC());
			
			if(this.type == RECTANGLE) {
				g.drawRect(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH());	
			}
			else if(this.type == CIRCLE) {
				g.drawRoundRect(this.rect.getX(), this.rect.getY(), this.rect.getW(), this.rect.getH(), this.rect.getW(), this.rect.getH());
			}
			else if(this.type == TRIANGLE) {
				// this.rect 기준으로 -> 삼각형을 그릴 좌표배열 만들기
				xx = new int[3];
				yy = new int[3];
				xx[0] = this.rect.getX();
				yy[0] = this.rect.getY();
				xx[1] = this.rect.getX() - this.rect.getW()/2;
				yy[1] = this.rect.getY() + this.rect.getH();
				xx[2] = this.rect.getX() + this.rect.getW()/2;
				yy[2] = this.rect.getY() + this.rect.getH();
				
				g.drawPolygon(xx, yy, 3);
			}
		}
		
		for(int i=0; i<this.rects.size(); i++) {
			Rect r = this.rects.get(i);
			g.setColor(r.getC());
			
		}
		
		requestFocusInWindow();
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = true;
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.shift = false;
		}
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.startX = e.getX();
		this.startY = e.getY();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.rect.setC(Color.blue);
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		int w = this.type == TRIANGLE ? x - startX : Math.abs(x - startX);
		int h = this.type == TRIANGLE ? y - startY : Math.abs(y - startY);
		
		if(shift)
			w = h;
		
		int rX = startX;
		int rY = startY;
		
		if(this.type != TRIANGLE) {
			if(x < startX)
				rX = startX - w;
			if(y < startY)
				rY = startY - h;
		}
		
		this.rect = new Rect(rX, rY, w, h, Color.red);			
	 }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btn[RECTANGLE]){
			this.type = RECTANGLE;
		}
		else if(e.getSource() == this.btn[CIRCLE]){
			this.type = CIRCLE;
		}
		else if(e.getSource() == this.btn[TRIANGLE]){
			this.type = TRIANGLE;
		}

}

public static class 문제08풀이 extends JFrame{
	
	public 문제08풀이() {
		setLayout(null);
		setBounds(100, 100, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new GrimPann());
		
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		문제08풀이 puri = new 문제08풀이();
		
	}

}
