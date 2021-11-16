package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

class sam {
	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public int getNum() {
		return num;
	}
	
	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	int[] x = new int[3];
	int[] y = new int[3];
	int num = 3;
	private Color c = Color.black;
	
	public sam() {
	}
}

class paintPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener, ActionListener {
	private final int SIZE = 800;
	private boolean isRun;
	private boolean check;
	private ArrayList<Object> nemos = new ArrayList<>();
	private ArrayList<Object> circles = new ArrayList<>();
	private ArrayList<sam> triangle = new ArrayList<>();
	private ArrayList <ArrayList<Object>> lines = new ArrayList<>();
	private ArrayList<Object> line;
	private int shape;
	private final int Rect = 0;
	private final int Cir = 1;
	private final int Tri = 2;
	
	private int Mx;
	private int My;

	private int Dx;
	private int Dy;
	
	String[] btnText = {"□","○","△","/"};
	JButton[] btn = new JButton[4];

	public paintPanel() {
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);
		
		setButton();

		setNemo();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
	}

	private void setButton() {
		int x = 0;
		int y = 0;
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setText(this.btnText[i]);
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].addActionListener(this);
			add(this.btn[i]);
			x+=50;
		}
		
	}

	private void setNemo() {
		Object temp = new Object(0, 0, 0, 0, Color.white);
		this.nemos.add(temp);
		this.circles.add(temp);
		sam t = new sam();
		this.triangle.add(t);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (this.isRun) {
			this.Dx = e.getX();
			this.Dy = e.getY();
			
			int w = this.shape == Tri ? this.Mx - this.Dx : Math.abs(this.Mx - this.Dx);
			int h = this.shape == Tri ? this.My - this.Dy : Math.abs(this.My - this.Dy);
			
			if(this.check)// shift
				w = h;
			
			int rX = this.Mx;
			int rY = this.My;
			
			if(this.shape != Tri) {
				if(this.Dx < this.Mx) {
					rX = this.Mx - w;
				}
				
				if(this.Dy < this.My) {
					rY = this.My - h;
				}
			}

			if(this.shape==Rect) {
				Object temp = new Object(rX, rY, w, h, Color.black);
				this.nemos.set(this.nemos.size()-1, temp);
			}
			else if(this.shape==Cir) {
				Object temp = new Object(rX, rY, w, h, Color.black);
				this.circles.set(this.circles.size()-1, temp);
			}
			else if(this.shape==Tri) {
				int[] xx = new int[3];
				int[] yy = new int[3];
				xx[0] = rX;
				yy[0] = rY;
				xx[1] = rX-w/2;
				yy[1] = rY+h;
				xx[2] = rX+w/2;
				yy[2] = rY+h;
				sam temp = new sam();
				temp.setX(xx);
				temp.setY(yy);
				this.triangle.set(this.triangle.size()-1, temp);
			}
			else {
				
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
		this.isRun = true;
		this.Mx = e.getX();
		this.My = e.getY();
		this.line = new ArrayList<>();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isRun = false;
		
		if(this.shape==Rect) {
			this.nemos.get(this.nemos.size()-1).setC(Color.blue);
			Object temp = new Object(0, 0, 0, 0, Color.white);
			this.nemos.add(temp);
		}
		else if(this.shape==Cir) {
			this.circles.get(this.circles.size()-1).setC(Color.red);
			Object temp = new Object(0, 0, 0, 0, Color.white);
			this.circles.add(temp);
		}
		else if(this.shape==Tri) {
			this.triangle.get(this.triangle.size()-1).setC(Color.green);
			sam temp = new sam();
			this.triangle.add(temp);
		}
		else {
			
		}

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
		g.setColor(Color.black);
		
		if(this.shape==Rect) {
			Object t = this.nemos.get(this.nemos.size()-1);
			g.setColor(t.getC());
			g.drawRect(t.getX(), t.getY(), t.getW(), t.getH());		
		}
		else if(this.shape==Cir) {
			Object t = this.circles.get(this.circles.size()-1);
			g.setColor(t.getC());
			g.drawRoundRect(t.getX(), t.getY(), t.getW(), t.getH(), t.getW(), t.getH());
		}
		else if(this.shape==Tri) {
			sam t = this.triangle.get(this.triangle.size()-1);
			g.setColor(t.getC());
			g.drawPolygon(t.getX(), t.getY(), t.getNum());
		}
		
		if(this.nemos.size()>0) {
			for(int i=0; i<this.nemos.size(); i++) {
				Object t = this.nemos.get(i);
				g.setColor(t.getC());
				g.drawRect(t.getX(), t.getY(), t.getW(), t.getH());
			}
		}
		
		if(this.circles.size()>0) {
			for(int i=0; i<this.circles.size(); i++) {
				Object t = this.circles.get(i);
				g.setColor(t.getC());
				g.drawRoundRect(t.getX(), t.getY(), t.getW(), t.getH(), t.getW(), t.getH());
			}
		}
		
		if(this.triangle.size()>0) {
			for(int i=0; i<this.triangle.size(); i++) {
				sam t = this.triangle.get(i);
				g.setColor(t.getC());
				g.drawPolygon(t.getX(), t.getY(), t.getNum());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			for(int i=0; i<this.btn.length; i++) {
				if(this.btn[i]==target) {
					this.shape = i;
				}
			}
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
