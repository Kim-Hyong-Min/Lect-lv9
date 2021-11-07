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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ddol {
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

	public ddol(int x, int y, int width, int height, Color c) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.c = c;
	}
}

class WinGame extends JFrame {
	private JLabel win = new JLabel();

	public WinGame(int winner) {
		setLayout(null);
		setTitle("게임 종료!");
		setBounds(Omok2.W / 2 - 300 / 2, Omok2.H / 2 - 200 / 2, 300, 200);
		if (winner == 1) {
			this.win.setText("백돌의 승리!");
		} else {
			this.win.setText("흑돌의 승리!");
		}
		this.win.setBounds(0, 0, 300, 100);
		this.win.setFont(new Font("", Font.BOLD, 20));
		this.win.setHorizontalAlignment(JLabel.CENTER);
		add(this.win);
		setVisible(true);
		revalidate();
	}
}

class Omokpan extends JPanel implements MouseListener, ActionListener, Runnable {
	private final int SIZE = 10;
	private ddol[][] dols = new ddol[SIZE][SIZE];
	private ddol[][] dolsLine = new ddol[SIZE][SIZE];
	private ddol[][] pans = new ddol[SIZE + 1][SIZE + 1];

	private JLabel text = new JLabel();
	public static int turn = 1;
	public static int winner;

	private boolean check;
	private JButton checkLine = new JButton();
	private JButton reset = new JButton();
	private int[][] line = new int[SIZE][SIZE];

	public Omokpan() {
		setLayout(null);
		setBounds(0, 0, 900, 900);
		setBackground(new Color(255, 230, 153));
		setTurn();
		setdol();
		setPan();
		setReset();
		setCheckLine();
		addMouseListener(this);
	}

	private void resetGame() {
		this.line = new int[SIZE][SIZE];
		this.turn = 1;
		this.winner = 0;
	}

	private void setCheckLine() {
		this.checkLine.setBounds(20, 20, 100, 50);
		this.checkLine.setText("Check Line");
		this.checkLine.addActionListener(this);
		add(this.checkLine);
	}

	private void setReset() {
		this.reset.setBounds(20, 80, 100, 50);
		this.reset.setText("RESET");
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setTurn() {
		this.text.setBounds(250, 50, 300, 50);
		this.text.setFont(new Font("", Font.BOLD, 30));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
	}

	private void setdol() {
		int x = 180;
		int y = 180;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.dols[i][j] = new ddol(x, y, 30, 30, Color.red);
				x += 50;
			}
			x = 180;
			y += 50;
		}

		x = 170;
		y = 170;

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.dolsLine[i][j] = new ddol(x, y, 50, 50, Color.red);
				x += 50;
			}
			x = 170;
			y += 50;
		}

	}

	private void setPan() {
		int x = 145;
		int y = 145;

		for (int i = 0; i < SIZE + 1; i++) {
			for (int j = 0; j < SIZE + 1; j++) {
				this.pans[i][j] = new ddol(x, y, 50, 50, Color.black);
				x += 50;
			}
			x = 145;
			y += 50;
		}
	}

	private boolean gameCheck() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j <= SIZE / 2; j++) {
				int check = 0;
				for (int k = 0; k < SIZE / 2; k++) {
					check += this.line[i][j + k];
				}
				if (check == 5) {
					winner = 1;
					break;
				} else if (check == -5) {
					winner = -1;
					break;
				}
			}
		}

		if (winner == 0) {
			for (int i = 0; i <= SIZE / 2; i++) {
				for (int j = 0; j < SIZE; j++) {
					int check = 0;
					for (int k = 0; k < SIZE / 2; k++) {
						check += this.line[i + k][j];
					}
					if (check == 5) {
						winner = 1;
						break;
					} else if (check == -5) {
						winner = -1;
						break;
					}
				}
			}
		}

		if (winner == 0) {
			for (int i = 0; i <= SIZE / 2; i++) {
				for (int j = 0; j <= SIZE / 2; j++) {
					int check = 0;
					for (int k = 0; k < SIZE / 2; k++) {
						check += this.line[i + k][j + k];
					}
					if (check == 5) {
						winner = 1;
						break;
					} else if (check == -5) {
						winner = -1;
						break;
					}
				}
			}
		}

		if (winner == 0) {
			for (int i = 0; i <= SIZE / 2; i++) {
				for (int j = SIZE - 1; j >= 4; j--) {
					int check = 0;
					for (int k = 0; k < SIZE / 2; k++) {
						check += this.line[i + k][j - k];
					}
					if (check == 5) {
						winner = 1;
						break;
					} else if (check == -5) {
						winner = -1;
						break;
					}
				}
			}
		}
		if (winner == 0)
			return false;
		else
			return true;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < SIZE + 1; i++) {
			for (int j = 0; j < SIZE + 1; j++) {
				ddol temp = this.pans[i][j];
				g.setColor(temp.getC());
				g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				ddol temp = this.dols[i][j];
				if (this.line[i][j] == 1 || this.line[i][j] == -1) {
					g.setColor(temp.getC());
					g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(),
							temp.getHeight());
				}
			}
		}

		if (this.check) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					ddol temp = this.dolsLine[i][j];
					g.setColor(temp.getC());
					g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
				}
			}
		}
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				ddol temp = this.dols[i][j];
				if (this.turn == 1 && x >= temp.getX() && x < temp.getX() + temp.getWidth() && y >= temp.getY()
						&& y < temp.getY() + temp.getWidth() && this.line[i][j] == 0) {
					temp.setC(Color.white);
					this.line[i][j] = 1;
					this.turn = -1;
				} else if (turn == -1 && x >= temp.getX() && x < temp.getX() + temp.getWidth() && y >= temp.getY()
						&& y < temp.getY() + temp.getWidth() && this.line[i][j] == 0) {
					temp.setC(Color.black);
					this.line[i][j] = -1;
					this.turn = 1;
				}
			}
		}

		if (gameCheck() && winner != 0) {
			new WinGame(winner);
			turn = 0;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
	public void run() {
		while (true) {
			if (this.turn == 1) {
				this.text.setText("Turn : 백돌");
			} else if (this.turn == -1) {
				this.text.setText("Turn : 흑돌");
			} else {
				this.text.setText("게임 종료!");
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.checkLine == e.getSource()) {
			if (this.check) {
				this.check = false;
			} else {
				this.check = true;
			}
		}

		if (this.reset == e.getSource()) {
			resetGame();
		}

	}
}

class Omok2 extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	private Omokpan pan = new Omokpan();
	public static int W = dm.width;
	public static int H = dm.height;

	public Omok2() {
		setLayout(null);
		setTitle("오목 게임");
		setBounds(W / 2 - 800 / 2, H / 2 - 800 / 2, 800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
		revalidate();
		add(pan);
		pan.run();
	}

}

public class 문제04 {

	public static void main(String[] args) {
		// 오목게임 (Nemo 객체와 paintComponent() 메소드를 활용)
		Omok2 omok = new Omok2();
	}

}
