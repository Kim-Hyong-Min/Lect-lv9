package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnakeGame2 extends JPanel implements ActionListener, KeyListener{
	private final int SIZE = 10;
	private SnakeRect[][] map = new SnakeRect[SIZE][SIZE];
	
	private ArrayList<SnakeRect> snake = new ArrayList<SnakeRect>();
	private ArrayList<ArrayList<Integer>> yx = new ArrayList<ArrayList<Integer>>();
	
	private ArrayList<SnakeRect> items = new ArrayList<SnakeRect>();
	private ArrayList<ArrayList<Integer>> itemYx = new ArrayList<ArrayList<Integer>>();
	
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	private int dir;
	
	private boolean death;
	
	public SnakeGame2() {
		setLayout(null);
		setBounds(0,0,700,500);
		
		setMap();
		setSnake();
		setItems();
		
		setFocusable(true);
		addKeyListener(this);
	}

	private void setItems() {
		Random rn = new Random();
		int r = rn.nextInt(SIZE*SIZE/5) +5;
		
		for(int i=0; i<r; i++) {
			int rY = rn.nextInt(SIZE);
			int rX = rn.nextInt(SIZE);
			
			boolean check = false;
			for(int j=0; j<this.yx.size(); j++) {
				if(rY == this.yx.get(j).get(0) && rX == this.yx.get(j).get(1))
					check = true;
				if(check) {
					i--;
					break;
				}
			}
			
			for(int j=0; j<this.itemYx.size(); j++) {
				if(rY == this.itemYx.get(j).get(0) && rX == this.itemYx.get(j).get(1))
					check = true;
				if(check) {
					i--;
					break;
				}
			}
			
			if(!check) {
				SnakeRect t = this.map[rY][rX];
				this.items.add(new SnakeRect(t.getX()+10, t.getY()+10, 20, 20, Color.green));
				
				ArrayList<Integer> pair = new ArrayList<Integer>();
				pair.add(rY);
				pair.add(rX);
				this.itemYx.add(pair);
			}
			
		}
		
		
	}

	private void setSnake() {
		for(int i=0; i<4; i++) {
			SnakeRect t = this.map[0][i];
			Color c = Color.blue;
			if(i == 0)
				c = Color.red;
			this.snake.add(new SnakeRect(t.getX(), t.getY(), t.getW(), t.getH(), c));
			
			// yx
			ArrayList<Integer> pair = new ArrayList<Integer>();
			pair.add(0); // map 의 y 인덱스
			pair.add(i); // map 의 x 인덱스
			this.yx.add(pair);
		}
	}

	private void setMap() {
		int x = (700-200)/2-40*SIZE/2;
		int y = 500/2-40*SIZE/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j] = new SnakeRect(x, y, 40, 40, Color.gray);
				x+=40;
			}
			x = (700-200)/2-40*SIZE/2;
			y += 40;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// snake
		for(int i=0; i<this.snake.size(); i++) {
			SnakeRect r = this.snake.get(i);
			Color c = r.getC();
			if(death)
				c =  Color.black;
			g.setColor(c);
			g.fillRect(r.getX(), r.getY(), r.getW(), r.getH());
			
		}
		
		// items
		for(int i=0; i<this.items.size(); i++) {
			SnakeRect r = this.items.get(i);
			g.setColor(r.getC());
			g.fillRoundRect(r.getX(), r.getY(), r.getW(), r.getH(), r.getW(), r.getH());
		}
		
		// map
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				SnakeRect r = this.map[i][j];
				g.setColor(r.getC());
				g.drawRect(r.getX(), r.getY(), r.getW(), r.getH());
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
		
		if(e.getKeyCode() == e.VK_LEFT)
			this.dir  = LEFT;
		if(e.getKeyCode() == e.VK_DOWN)
			this.dir  = DOWN;
		if(e.getKeyCode() == e.VK_RIGHT)
			this.dir  = RIGHT;
		if(e.getKeyCode() == e.VK_UP)
			this.dir  = UP;
		move();
	}

	private void move() {
		int yy = this.yx.get(0).get(0);
		int xx = this.yx.get(0).get(1);
		
		if(this.dir == LEFT) {
			xx --;
		}
		if(this.dir == DOWN) {
			yy ++;
		}
		if(this.dir == RIGHT) {
			xx ++;
		}
		if(this.dir == UP) {
			yy --;
		}
		
		// check
		if(xx <0 || xx>= SIZE || yy < 0 || yy >= SIZE)
			return; // 아무일도 없도록 리턴
		
		// bodycheck
		for(int i=0; i<this.yx.size(); i++) {
			if(yy == this.yx.get(i).get(0) && xx == this.yx.get(i).get(1)){
				this.death = true;
			}
		}
		
		// item
		boolean isGrow = false;
		for(int i=0; i<this.itemYx.size(); i++) {
			if(yy == this.itemYx.get(i).get(0) && xx == this.itemYx.get(i).get(1)) {
				isGrow = true;
				this.items.remove(i);
				this.itemYx.remove(i);
			}
		}
		
		// move
		if(!death) {
			SnakeRect tail = this.snake.get(this.snake.size()-1);
			ArrayList<Integer> tailYx = this.yx.get(this.yx.size()-1);
			
			
			// body
			for(int i=this.snake.size()-1; i>0; i--) {
				SnakeRect temp = this.snake.get(i-1);
				temp.setC(Color.blue);
				this.snake.set(i, temp);
				
				ArrayList<Integer> pair = this.yx.get(i-1);
				this.yx.set(i, pair);
			}
			SnakeRect t = this.map[yy][xx];
			this.snake.set(0, new SnakeRect(t.getX(), t.getY(), t.getW(), t.getH(), Color.red));
			ArrayList<Integer> pair = new ArrayList<Integer>();
			pair.add(yy);
			pair.add(xx);
			this.yx.set(0, pair);
			
			if(isGrow) {
				this.snake.add(tail);
				this.yx.add(tailYx);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}

public class 문제06풀이2 extends JFrame{
	public 문제06풀이2() {
		super("Snake items");
		setLayout(null);
		setBounds(100,100,700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new SnakeGame2());
		setVisible(true);
		revalidate();
	}
	public static void main(String[] args) {
		문제06풀이2 snake = new 문제06풀이2();

	}

}
