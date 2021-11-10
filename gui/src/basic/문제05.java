package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class nemos {
	private int x, y, w, h;
	private Color c;

	public nemos(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x += x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y += y;
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

}

class Push extends JPanel implements MouseListener {

	private final int LEFT = 0;
	private final int DOWN = 1;
	private final int RIGHT = 2;
	private final int UP = 3;
	private boolean isMoving;
	private int dir;

	private nemos n1 = null;
	private nemos n2 = null;
	private JButton[] button = new JButton[4];
	private final int SIZE = 700;

	public Push() {
		setLayout(null);
		setBounds(0, 0, SIZE, SIZE);
		setBackground(new Color(238, 238, 238));

		this.dir = 4;
		setNemos();
		setButton();
		addMouseListener(this);
	}

	private void setNemos() {
		Random rn = new Random();

		int rX = rn.nextInt(SIZE - 100);
		int rY = rn.nextInt(SIZE - 100);

		this.n1 = new nemos(rX, rY, 100, 100);

		while (true) {
			rX = rn.nextInt(SIZE - 100);
			rY = rn.nextInt(SIZE - 100);

			boolean check = false;
			if (rX < this.n1.getX() - 100 || rX > this.n1.getX() + 100) {
				check = true;
			}
			if (check) {
				this.n2 = new nemos(rX, rY, 100, 100);
				break;
			}
		}

	}

	private void setButton() { // 상 하 좌 우
		String[] text = { "←", "↓", "→", "↑" };

		int x = 550;
		int y = 550;
		for (int i = 0; i < 4; i++) {
			JButton bt = new JButton();
			bt.setBounds(x, y, 50, 50);
			bt.setText(text[i]);
			bt.addMouseListener(this);
			add(bt);
			this.button[i] = bt;
			x += 50;
			if (i == this.button.length - 1 - 1) {
				y -= 50;
				x -= 100;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.n1 != null && this.n2 != null) {

			g.setColor(Color.black);
			g.drawRect(this.n1.getX(), this.n1.getY(), this.n1.getW(), this.n1.getH());

			g.setColor(Color.red);
			g.drawRect(this.n2.getX(), this.n2.getY(), this.n2.getW(), this.n2.getH());

		}

		if (this.isMoving)
			nemoMove();

		repaint();
	}

	private void nemoMove() {
		int n1_X = this.n1.getX();
		int n1_Y = this.n1.getY();
		int n1_mX = this.n1.getX() + 100;
		int n1_mY = this.n1.getY() + 100;

		int n2_X = this.n2.getX();
		int n2_Y = this.n2.getY();
		int n2_mX = this.n2.getX() + 100;
		int n2_mY = this.n2.getY() + 100;

		if (this.dir == LEFT) {// 상 n2.y-100 <= n1.y / 하 n2.y+100 >= n1.y
			if (this.n1.getX() > 0) {
				if (n1_Y >= n2_Y && n1_Y <= n2_mY) {
					if (n2_mY == n1_Y) {
						this.n1.setX(-1);
					}
					if (n1_X == n2_mX && n2_X > 0) {
						this.n1.setX(-1);
						this.n2.setX(-1);
					}
					if (n2_mX == this.SIZE && n1_mX <= n2_X) {//
						this.n1.setX(-1);
					}
					if (n1_X > n2_mX) {
						this.n1.setX(-1);
					}
				} else if (n1_mY >= n2_Y && n1_mY <= n2_mY) {
					if (n1_mY == n2_Y) {
						this.n1.setX(-1);
					}
					if (n1_X == n2_mX && n2_X > 0) {
						this.n1.setX(-1);
						this.n2.setX(-1);
					}
					if (n2_mX == this.SIZE && n1_mX <= n2_X) {//
						this.n1.setX(-1);
					}
					if (n1_X > n2_mX) {
						this.n1.setX(-1);
					}
				} else if (n1_mY < n2_Y || n1_Y > n2_mY) {
					this.n1.setX(-1);
				}
			}
		} else if (this.dir == DOWN) {
			if (this.n1.getY() < this.SIZE - 101) {
				if (n1_X >= n2_X && n1_X <= n2_mX) {
					if (n2_mX == n1_X) {
						this.n1.setY(1);
					}
					if (n1_mY == n2_Y && n2_mY < this.SIZE) {
						this.n1.setY(1);
						this.n2.setY(1);
					}
					if (n2_Y == 0 && n1_Y >= n2_mY) {
						this.n1.setY(1);
					}
					if (n1_mY < n2_Y) {
						this.n1.setY(1);
					}
				} else if (n1_mX >= n2_X && n1_mX <= n2_mX) {
					if (n1_mX == n2_X) {
						this.n1.setY(1);
					}
					if (n1_mY == n2_Y && n2_mY < this.SIZE) {
						this.n1.setY(1);
						this.n2.setY(1);
					}
					if (n2_Y == 0 && n1_Y >= n2_mY) {
						this.n1.setY(1);
					}
					if (n1_mY < n2_Y) {
						this.n1.setY(1);
					}
				} else if (n1_mX < n2_X || n1_X > n2_mX) {
					this.n1.setY(1);
				}
			}
		} else if (this.dir == RIGHT) {
			if (this.n1.getX() < this.SIZE - 101) {
				if (n1_Y >= n2_Y && n1_Y <= n2_mY) {
					if (n2_mY == n1_Y) {
						this.n1.setX(1);
					}
					if (n1_mX == n2_X && n2_mX < this.SIZE) {

						this.n1.setX(1);
						this.n2.setX(1);
					}
					if (n2_X == 0 && n1_X >= n2_mX) {
						this.n1.setX(1);
					}
					if (n1_mX < n2_X) {
						this.n1.setX(1);
					}
				} else if (n1_mY >= n2_Y && n1_mY <= n2_mY) {
					if (n1_mY == n2_Y) {
						this.n1.setX(1);
					}
					if (n1_mX == n2_X && n2_mX < this.SIZE) {
						this.n1.setX(1);
						this.n2.setX(1);
					}
					if (n2_X == 0 && n1_X >= n2_mX) {//
						this.n1.setX(1);
					}
					if (n1_mX < n2_X) {
						this.n1.setX(1);
					}
				} else if (n1_mY < n2_Y || n1_Y > n2_mY) {
					this.n1.setX(1);
				}
			}
		} else if (this.dir == UP) {
			if (this.n1.getY() > 0) {
				if (n1_X >= n2_X && n1_X <= n2_mX) {
					if (n2_mX == n1_X) {
						this.n1.setY(-1);
					}
					if (n1_Y == n2_mY && n2_Y > 1) {
						this.n1.setY(-1);
						this.n2.setY(-1);
					}
					if (n2_mY == this.SIZE && n1_mY <= n2_Y) {//
						this.n1.setY(-1);
					}
					if (n1_Y > n2_mY) {
						this.n1.setY(-1);
					}
				} else if (n1_mX >= n2_X && n1_mX <= n2_mX) {
					if (n1_mX == n2_X) {
						this.n1.setY(-1);
					}
					if (n1_Y == n2_mY && n2_Y > 1) {
						this.n1.setY(-1);
						this.n2.setY(-1);
					}
					if (n2_mY == this.SIZE && n1_mY <= n2_Y) {//
						this.n1.setY(-1);
					}
					if (n1_Y > n2_mY) {
						this.n1.setY(-1);
					}
				} else if (n1_mX < n2_X || n1_X > n2_mX) {
					this.n1.setY(-1);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.isMoving = true;
		if (e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			if (target == this.button[LEFT]) {
				System.out.println("왼");
				this.dir = LEFT;
			} else if (target == this.button[DOWN]) {
				System.out.println("아래");
				this.dir = DOWN;
			} else if (target == this.button[RIGHT]) {
				System.out.println("오른");
				this.dir = RIGHT;
			} else if (target == this.button[UP]) {
				System.out.println("위");
				this.dir = UP;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.isMoving = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}

public class 문제05 extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	private final int SIZE = 800;
	private Push p = new Push();

	public 문제05() {
		super("Push Push");
		setLayout(null);
		setBounds(W / 2 - SIZE / 2, H / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(p);
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		문제05 game = new 문제05();

	}

}
