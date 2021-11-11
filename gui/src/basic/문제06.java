package basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SkRect {
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	public int getItem() {
		return item;
	}

	public void setItem(int num) {
		this.item = num;
	}

	private int x, y, w, h, item;
	private Color c;

	public SkRect(int x, int y, int w, int h, Color c) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
	}

	public SkRect(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class snake extends JPanel implements KeyListener , ActionListener{
	private JButton[] btn = new JButton[4]; 
	private JButton reset = new JButton(); 
	
	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	
	private final int SIZE = 10;
	private SkRect[] snake;
	private JLabel text = new JLabel();
	private JLabel move = new JLabel();
	private SkRect[][] map = new SkRect[SIZE][SIZE];
	private int PX;
	private int PY;
	private int total;
	private boolean dead;

	public snake() {
		setLayout(null);
		setBounds(0, 0, 1000, 800);

		setSnake();
		setMap();
		setDeadText();
		setMoveText();
		setButton();

		setFocusable(true);
		addKeyListener(this);
	}
	
	private void setButton() {
		String[]t = {"←","↓","→","↑"};
		
		int x = 700;
		int y = 500;
		
		for(int i=0; i<this.btn.length; i++) {
			this.btn[i] = new JButton();
			this.btn[i].setBounds(x, y, 50, 50);
			this.btn[i].setText(t[i]);
			this.btn[i].addActionListener(this);
			add(this.btn[i]);
			x+=50;
			if(i==this.btn.length-1-1) {
				x=700+50;
				y-=50;
			}
		}
		
		this.reset.setBounds(700, 600, 150, 50);
		this.reset.setText("RESET");
		this.reset.addActionListener(this);
		add(this.reset);
	}

	public void setDeadText() {
		this.text.setBounds(0, 0, 800, 100);
		this.text.setText("Snake Game");
		this.text.setFont(new Font("", Font.BOLD, 30));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
	}

	public void setMoveText() {
		this.move.setBounds(0, 650, 800, 100);
		this.move.setText("이동(방향키)         리셋(엔터키)");
		this.move.setFont(new Font("", Font.PLAIN, 20));
		this.move.setHorizontalAlignment(JLabel.CENTER);
		add(this.move);
	}

	private void setSnake() { // 초기설정 00,01,02,03
		int x = 150;
		int y = 150;
		this.total = 4;
		this.snake = new SkRect[total];
		for (int i = 0; i < this.snake.length; i++) {
			this.snake[i] = new SkRect(x, y);
			x += 50;
		}

	}

	private void setMap() {
		Random rn = new Random();
		int x = 150;
		int y = 150;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.map[i][j] = new SkRect(x, y, 50, 50, Color.white);
				x += 50;
			}
			x = 150;
			y += 50;
		}
		int cnt = 6;
		while (cnt > 0) {
			int rX = rn.nextInt(SIZE);
			int rY = rn.nextInt(SIZE);

			if (this.map[rX][rY].getItem() == 0) {
				int check = -1;
				for (int i = 0; i < this.snake.length; i++) {
					if (this.snake[i].getX() == this.map[rX][rY].getX()
							&& this.snake[i].getY() == this.map[rX][rY].getY()) {
						check = 1;
						break;
					}
				}
				if (check == -1) {
					this.map[rX][rY].setItem(1);
					cnt--;
				}
			}
		}
	}
	
	public void moveLeft() {
		if (!dead && this.PX > 0 && this.snake[0].getX() - 50 != this.snake[1].getX()) {
			this.PX--;
			SkRect[] temp = this.snake;

			// item check
			int checkX = -1;
			int checkY = -1;
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (this.map[i][j].getItem() == 1 && this.snake[0].getX() - 50 == this.map[i][j].getX()
							&& this.snake[0].getY() == this.map[i][j].getY()) {
						checkX = i;
						checkY = j;
						break;
					}
				}
			}
			if (checkX == -1 && checkY == -1) { // item X
				this.snake = new SkRect[total];
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(temp[i].getX() - 50, temp[i].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
				DeadCheck();
			} else { // item O
				total++;
				this.snake = new SkRect[total];
				this.map[checkX][checkY].setItem(0);
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(this.map[checkX][checkY].getX(),
								this.map[checkX][checkY].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
			}

		}
	}
	
	public void moveDown() {
		if (!dead && this.PY < SIZE - 1 && this.snake[0].getY() + 50 != this.snake[1].getY()) {
			this.PY++;
			SkRect[] temp = this.snake;

			int checkX = -1;
			int checkY = -1;
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (this.map[i][j].getItem() == 1 && this.snake[0].getX() == this.map[i][j].getX()
							&& this.snake[0].getY() + 50 == this.map[i][j].getY()) {
						checkX = i;
						checkY = j;
						break;
					}
				}
			}
			if (checkX == -1 && checkY == -1) { // item X
				this.snake = new SkRect[total];
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(temp[i].getX(), temp[i].getY() + 50);
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
				DeadCheck();
			} else {
				total++;
				this.snake = new SkRect[total];
				this.map[checkX][checkY].setItem(0);
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(this.map[checkX][checkY].getX(),
								this.map[checkX][checkY].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
			}
		}
	}
	
	public void moveRight() {
		if (!dead && this.PX < SIZE - 1 && this.snake[0].getX() + 50 != this.snake[1].getX()) {
			this.PX++;
			SkRect[] temp = this.snake;

			int checkX = -1;
			int checkY = -1;
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (this.map[i][j].getItem() == 1 && this.snake[0].getX() + 50 == this.map[i][j].getX()
							&& this.snake[0].getY() == this.map[i][j].getY()) {
						checkX = i;
						checkY = j;
						break;
					}
				}
			}
			if (checkX == -1 && checkY == -1) { // item X
				this.snake = new SkRect[total];
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(temp[i].getX() + 50, temp[i].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
				DeadCheck();
			} else {
				total++;
				this.snake = new SkRect[total];
				this.map[checkX][checkY].setItem(0);
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(this.map[checkX][checkY].getX(),
								this.map[checkX][checkY].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
			}
		}
	}
	
	public void moveUp() {
		if (!dead && this.PY > 0 && this.snake[0].getY() - 50 != this.snake[1].getY()) {
			this.PY--;
			SkRect[] temp = this.snake;

			int checkX = -1;
			int checkY = -1;
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					if (this.map[i][j].getItem() == 1 && this.snake[0].getX() == this.map[i][j].getX()
							&& this.snake[0].getY() - 50 == this.map[i][j].getY()) {
						checkX = i;
						checkY = j;
						break;
					}
				}
			}
			if (checkX == -1 && checkY == -1) { // item X
				this.snake = new SkRect[total];
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(temp[i].getX(), temp[i].getY() - 50);
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
				DeadCheck();
			} else {
				total++;
				this.snake = new SkRect[total];
				this.map[checkX][checkY].setItem(0);
				for (int i = 0; i < this.snake.length; i++) {
					if (i == 0) {
						this.snake[i] = new SkRect(this.map[checkX][checkY].getX(),
								this.map[checkX][checkY].getY());
					} else {
						this.snake[i] = new SkRect(temp[i - 1].getX(), temp[i - 1].getY());
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_LEFT) { // x-, 좌측에 몸이 존재할때
			moveLeft();
		} else if (e.getKeyCode() == e.VK_DOWN) { // y +
			moveDown();
		} else if (e.getKeyCode() == e.VK_RIGHT) { // x +
			moveRight();
		} else if (e.getKeyCode() == e.VK_UP) { // y -
			moveUp();
		} else if (e.getKeyCode() == e.VK_ENTER) {
			reset();
		}
	}

	public void reset() {
		setSnake();
		map = new SkRect[SIZE][SIZE];
		this.PX = 0;
		this.PY = 0;
		setMap();
		this.dead = false;
		this.text.setText("Snake Game");
	}

	public void DeadCheck() {
		for (int i = 1; i < this.snake.length; i++) {
			if (this.snake[0].getX() == this.snake[i].getX() && this.snake[0].getY() == this.snake[i].getY()) {
				this.dead = true;
				break;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				SkRect temp = this.map[i][j];
				g.setColor(Color.black);
				g.drawRect(temp.getX(), temp.getY(), temp.getW(), temp.getH());
				if (!this.dead) {
					for (int k = 0; k < this.snake.length; k++) {
						if (this.snake[k].getX() == temp.getX() && this.snake[k].getY() == temp.getY()) {
							if (k == 0) {
								g.setColor(Color.magenta);
								g.fillRect(temp.getX(), temp.getY(), temp.getW(), temp.getH());
							} else {
								g.setColor(Color.green);
								g.fillRect(temp.getX(), temp.getY(), temp.getW(), temp.getH());
							}
						}
					}
				} else {
					this.text.setText("뱀이 죽었다...");
					for (int k = 0; k < this.snake.length; k++) {
						if (this.snake[k].getX() == temp.getX() && this.snake[k].getY() == temp.getY()) {
							if (k == 0) {
								g.setColor(Color.red);
								g.fillRect(temp.getX(), temp.getY(), temp.getW(), temp.getH());
							} else {
								g.setColor(Color.red);
								g.fillRect(temp.getX(), temp.getY(), temp.getW(), temp.getH());
							}
						}
					}
				}

				if (temp.getItem() == 1) {
					g.setColor(Color.pink);
					g.fillRoundRect(temp.getX() + 8, temp.getY() + 8, temp.getW() - 15, temp.getH() - 15,
							temp.getW() - 15, temp.getH() - 15);
				}
			}
		}

		requestFocusInWindow();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			if(target == this.btn[LEFT])
				moveLeft();
			else if(target == this.btn[DOWN]) 
				moveDown();
			else if(target == this.btn[RIGHT]) 
				moveRight();
			else if(target == this.btn[UP]) 
				moveUp();
			else if(target == this.reset)
				reset();
		}
		
	}

}

public class 문제06 extends JFrame {
	private snake sk = new snake();

	public 문제06() {
		super("Snake Game");
		setLayout(null);
		setBounds(100, 100, 950, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(sk);

		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		문제06 game = new 문제06();

	}

}
