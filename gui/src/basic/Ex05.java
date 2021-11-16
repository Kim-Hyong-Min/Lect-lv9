package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

// MouseMotionListener 를 활용해서 ->
// 사각형 객체를 클릭->드래그 하는 동안
// 사각형이 마우스를 따라서 -> 무빙

// printComponent() 메소드를 활용한 사각형 그리기
class Nemo{
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	private int x, y, width, height;
	private Color c;
	
	public Nemo(int x, int y, int width, int height, Color color) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.c = color;
	}
	
	
}

class MMyPanel extends JPanel implements MouseListener, MouseMotionListener{
	
	private boolean isMoving;
	private Nemo nemo = null;
	private int gapW, gapH;
	
	private Nemo[][] map = new Nemo[3][3];
	
	public MMyPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 400);
		setBackground(Color.orange);
		
//		Nemo.x = 100;
//		Nemo.y = 100;
//		Nemo.width = 100;
//		Nemo.height = 100;
//		Nemo.c = Color.blue;
		
		setNemo();
		
		// 패널에 혹은 특정하는 컴포넌트에 -> 마우스 리스너 달수있다
		addMouseListener(this); // this : MMyPanel;
		
		addMouseMotionListener(this);
		
	}
	
	private void setNemo() {
		Random rn = new Random();
		int rX = rn.nextInt(500);
		int rY = rn.nextInt(400);
		
		this.nemo = new Nemo(rX, rY, 50, 50, Color.blue);
	}

	private void setMap() {
		int x = 50;
		int y = 50;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				this.map[i][j] = new Nemo(x, y, 50, 50, Color.red);
				x += 50;
			}
			x = 50;
			y += 50;
		}
		
	}

	// paintComponent() 메소드 오버라이딩(JComponent)
	@Override
	protected void paintComponent(Graphics g) { // 스레드
		super.paintComponent(g); // 그래픽을 지움 
		
//		g.setColor(Color.red);
//		g.drawRect(100, 100, 100, 100);
//		g.fillRect(100, 100, 100, 100);
		
		g.setColor(this.nemo.getC());
		g.fillRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
		
		// draw Map
//		for(int i=0; i<3; i++) {
//			for(int j=0; j<3; j++) {
//				Nemo temp = this.map[i][j];
//				g.setColor(temp.getC());
//				g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(), temp.getHeight());
//			}
//		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("클릭!");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(x >= this.nemo.getX() && x < this.nemo.getX() + this.nemo.getWidth() 
		&& y >= this.nemo.getY() && y < this.nemo.getY() + this.nemo.getHeight() ) {
			this.isMoving = true;
			this.gapW = x - this.nemo.getX();
			this.gapH = y - this.nemo.getY();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMoving = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("hello");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("bye-");
		
	}

	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(isMoving) {
			this.nemo.setX(x - gapW);
			this.nemo.setY(y - gapH);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("move");
		
	}
}

class MMyFrame extends JFrame{
	public MMyFrame() {
		setLayout(null);
		setTitle("MyFrame");
		setBounds(50, 50, 500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new MMyPanel());
		
		setVisible(true);
		revalidate();
	}
}

public class Ex05 {

	public static void main(String[] args) {
		MMyFrame frame = new MMyFrame();

	}

}
