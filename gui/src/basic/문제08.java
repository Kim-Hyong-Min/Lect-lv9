package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


class Object{
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	private int x, y, w, h;
	private Color c;
	
	public Object(int x,int y,int w,int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
	
	public void reset() {
		this.x = 0;
		this.y = 0;
		this.w = 0;
		this.h = 0;
		this.c = Color.black;
	}
}

class paintPanel extends JPanel implements MouseListener, MouseMotionListener{
	private final int SIZE = 800;
	private boolean isRun;
	private Object nemo = null;
	private int Mx;
	private int My;
	
	private int Dx;
	private int Dy;
	
	public paintPanel() {
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);

		setNemo();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void setNemo() {
		this.nemo = new Object(0, 0, 0, 0, Color.white);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.isRun) {
			this.Dx = e.getX();
			this.Dy = e.getY();
			
			if(this.Mx>this.Dx) { // x --; 
				if(this.My>this.Dy) { // y --;
					System.out.println("하상");
					int x =	this.Dx;
					int y =	this.Dy;
					int w = this.Mx-this.Dx;
					int h = this.My-this.Dy;
					this.nemo.setX(x);
					this.nemo.setY(y);
					this.nemo.setW(w);
					this.nemo.setH(h);
					
				}
				else if(this.My<this.Dy) { // y ++;
					System.out.println("하하");
					int x =	this.Dx;
					int w = this.Mx-this.Dx;
					int h = this.Dy-this.My;
					this.nemo.setX(x);
					this.nemo.setW(w);
					this.nemo.setH(h);
				}
			}
			else if(this.Mx<this.Dx) { // x ++;
				if(this.My>this.Dy) { // y --;
					System.out.println("상상");
					int y =	this.Dy;
					int w = this.Dx-this.Mx;
					int h = this.My-this.Dy;
					this.nemo.setY(y);
					this.nemo.setW(w);
					this.nemo.setH(h);

				}
				else if(this.My<this.Dy) { // y ++;
					System.out.println("상하");
					int w = this.Dx-this.Mx;
					int h = this.Dy-this.My;
					this.nemo.setW(w);
					this.nemo.setH(h);
				}
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.nemo.reset();
		this.isRun = true;
		this.Mx = e.getX();
		this.My = e.getY();
		this.nemo.setX(Mx);
		this.nemo.setY(My);
		System.out.printf("%d : %d\n",Mx, My);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isRun = false;
		System.out.printf("%d : %d\n",Dx, Dy);
		this.nemo.setC(Color.blue);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(this.nemo.getC());
		g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getW(), this.nemo.getH());
		
		requestFocusInWindow();
		repaint();
	}
}

public class 문제08 extends JFrame{
	private static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = d.width;
	public static int h = d.height;
	private paintPanel paint = new paintPanel();
	
	public 문제08() {
		super("그림판");
		setLayout(null);
		setBounds(w/2-800/2, h/2-800/2, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(paint);
		
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		// 그림판
		문제08 painter = new 문제08();
	}

}
