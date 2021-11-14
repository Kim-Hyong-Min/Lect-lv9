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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Object {
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

	private int x, y, w, h;
	private Color c;

	public Object(int x, int y, int w, int h, Color c) {
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

class paintPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	private final int SIZE = 800;
	private boolean isRun;
	private boolean check;
	private ArrayList<Object> nemos = new ArrayList<>();
	private int cnt;
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
		Object temp = new Object(0, 0, 0, 0, Color.white);
		this.nemos.add(temp);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.isRun) {
			this.Dx = e.getX();
			this.Dy = e.getY();
			
			int w = Math.abs(this.Mx - this.Dx);
			int h = Math.abs(this.My - this.Dy);
			
			if(this.check)// shift
				w = h;
			
			int rX = this.Mx;
			int rY = this.My;
			
			if(this.Dx < this.Mx) {
				rX = this.Mx - w;
			}
			
			if(this.Dy < this.My) {
				rY = this.My - h;
			}
			Object temp = new Object(rX, rY, w, h, Color.black);
			this.nemos.set(this.cnt, temp);
			
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
		this.isRun = true;
		this.Mx = e.getX();
		this.My = e.getY();
		this.nemos.get(this.cnt).setX(Mx);
		this.nemos.get(this.cnt).setY(My);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isRun = false;
		this.nemos.get(this.cnt).setC(Color.blue);
		Object temp = new Object(0, 0, 0, 0, Color.white);
		this.nemos.add(temp);
		System.out.println(this.nemos.size());
		this.cnt++;
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
		g.setColor(this.nemos.get(this.cnt).getC());
		g.drawRect(this.nemos.get(this.cnt).getX(), this.nemos.get(this.cnt).getY(), this.nemos.get(this.cnt).getW(), this.nemos.get(this.cnt).getH());
		
		if(this.nemos.size()>0) {
			for(int i=0; i<this.nemos.size(); i++) {
				Object t = this.nemos.get(i);
				g.setColor(t.getC());
				g.drawRect(t.getX(), t.getY(), t.getW(), t.getH());
			}
		}
		requestFocusInWindow();
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			this.check = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			this.check = false;
		}
	}
}

public class 문제08 extends JFrame {
	private static Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	public static int w = d.width;
	public static int h = d.height;
	private paintPanel paint = new paintPanel();

	public 문제08() {
		super("그림판");
		setLayout(null);
		setBounds(w / 2 - 800 / 2, h / 2 - 800 / 2, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(paint);

		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		// 그림판
		문제08 painter = new 문제08();
		
		// 숙제
		// 그림판에 여러개의 내모 그리기
	}

}
