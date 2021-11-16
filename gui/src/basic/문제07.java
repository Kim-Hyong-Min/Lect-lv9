package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class NemoMove{
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
	public int getH() {
		return h;
	}
	public Color getC() {
		return c;
	}
	public void setC(Color c) {
		this.c = c;
	}
	
	private int x,y,w,h;
	private Color c;
	
	public NemoMove(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}
}

class NemoPanel extends JPanel implements MouseListener, MouseMotionListener{
	private NemoMove n;
	private final int SIZE = 800;
	private int Mx; // this.n.getX() ~ this.n.getX()+100
	private int My; // this.n.getY() ~ this.n.getY()+100
	
	private int Dx;
	private int Dy;
	
	public NemoPanel() {
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);
		
		setNemo();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private void setNemo() {
		this.n = new NemoMove(SIZE/2-100, SIZE/2-100, 100, 100, new Color (148, 218, 255));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.Mx = e.getX();
		this.My = e.getY();
		this.n.setC(new Color (185, 131, 255));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.n.setC(new Color (148, 218, 255));
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
	public void mouseDragged(MouseEvent e) {
		this.Dx = e.getX();
		this.Dy = e.getY();
		if(this.Mx>=this.n.getX() && this.Mx<=this.n.getX()+100 && this.My>=this.n.getY() && this.My<=this.n.getY()+100) {
			if(this.Mx<=this.Dx) { // x++;
				int x = this.Dx-this.Mx;
				this.Mx+=x;
				int n = this.n.getX();
				if(n+x<=SIZE-125) {
					this.n.setX(n+x);
				}
			}
			else if(this.Mx>this.Dx) { // x--;
				int x = this.Mx-this.Dx;
				this.Mx-=x;
				int n = this.n.getX();
				if(n-x>=0) {
					this.n.setX(n-x);
				}
			}
			
			if(this.My<=this.Dy) { // y++;
				int y = this.Dy-this.My;
				this.My+=y;
				int n = this.n.getY();
				if(n+y<=SIZE-125) {
					this.n.setY(n+y);
				}
			}
			else if(this.My>this.Dy) { // y--;
				int y = this.My-this.Dy;
				this.My-=y;
				int n = this.n.getY();
				if(n-y>=0) {
					this.n.setY(n-y);
				}
			}
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(this.n.getC());
		g.fillRect(this.n.getX(), this.n.getY(), this.n.getW(), this.n.getH());
		requestFocusInWindow();
		repaint();
	}
	
}

public class 巩力07 extends JFrame {
	private NemoPanel nemo = new NemoPanel();
	
	public 巩力07() {
		super("Nemo move");
		setLayout(null);
		setBounds(100, 100, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.nemo);
		
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		巩力07 nemoMove = new 巩力07();

	}

}
