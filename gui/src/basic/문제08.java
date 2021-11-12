package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

class paintPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	private final int SIZE = 800;
	private boolean isRun;
	private boolean check;
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
		addKeyListener(this);
	}

	private void setNemo() {
		this.nemo = new Object(0, 0, 0, 0, Color.white);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.isRun) {
			this.Dx = e.getX();
			this.Dy = e.getY();
			int w = Math.abs(this.Mx-this.Dx);
			int h = Math.abs(this.My-this.Dy);
			
			if(this.Mx>this.Dx) { // x --; 
				if(this.My>this.Dy) { // y --;
					if(!this.check) {
						int x =	this.Dx;
						int y =	this.Dy;
						this.nemo.setX(x);
						this.nemo.setY(y);
						this.nemo.setW(w);
						this.nemo.setH(h);
					}
					else {
						if(h>w) {
							int x =	this.Mx-h;
							int y =	this.My-h;
							this.nemo.setX(x);
							this.nemo.setY(y);
							this.nemo.setW(h);
							this.nemo.setH(h);

						}
						else {
							int x =	this.Mx-w;
							int y =	this.My-w;
							this.nemo.setX(x);
							this.nemo.setY(y);
							this.nemo.setW(w);
							this.nemo.setH(w);
						}
					}
					
				}
				else if(this.My<this.Dy) { // y ++;
					if(!this.check) {
						int x =	this.Dx;
						this.nemo.setX(x);
						this.nemo.setW(w);
						this.nemo.setH(h);
					}
					else {
						if(h>w) {
							int x = this.Mx-h;
							this.nemo.setX(x);
							this.nemo.setW(h);
							this.nemo.setH(h);
						}
						else {
							int x = this.Mx-w;
							this.nemo.setX(x);
							this.nemo.setW(w);
							this.nemo.setH(w);
						}
					}
				}
			}
			else if(this.Mx<this.Dx) { // x ++;
				if(this.My>this.Dy) { // y --;
					if(!this.check) {
						int y =	this.Dy;
						this.nemo.setY(y);
						this.nemo.setW(w);
						this.nemo.setH(h);
					}
					else {
						if(h>w) {
							int y =	this.My-h;
							this.nemo.setY(y);
							this.nemo.setW(h);
							this.nemo.setH(h);

						}
						else {
							int y =	this.My-w;
							this.nemo.setY(y);
							this.nemo.setW(w);
							this.nemo.setH(w);
						}
					}
				}
				else if(this.My<this.Dy) { // y ++;
					if(!this.check) {
						this.nemo.setW(w);
						this.nemo.setH(h);
					}
					else {
						if(h>w) {
							this.nemo.setW(h);
							this.nemo.setH(h);
						}
						else {
							this.nemo.setW(w);
							this.nemo.setH(w);
						}
					}
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
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isRun = false;
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.check = true;
			System.out.println(this.check);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == e.VK_SHIFT) {
			this.check = false;
			System.out.println(this.check);
		}	
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
