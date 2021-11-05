package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Winner extends JFrame {
	private JLabel text = new JLabel();

	public Winner(int turn) {
		super("Game Clear");
		setLayout(null);
		setBounds(100, 100, 300, 200);
		if (turn == -1) {
			this.text.setText("백돌의 승리!");
		} else {
			this.text.setText("흑돌의 승리!");
		}
		this.text.setBounds(50, 20, 200, 100);
		this.text.setFont(new Font("", Font.BOLD, 20));
		this.text.setHorizontalAlignment(JLabel.CENTER);
		add(this.text);
		setVisible(true);
	}
}

class dol extends JPanel implements ActionListener, Runnable {
	private final int MAX = 10;
	private JLabel text = new JLabel();
	private JButton dols[][] = new JButton[MAX][MAX];
	private JButton reset = new JButton();
	private int check[][] = new int[MAX][MAX];
	public static int turn = 1;

	public dol() {
		setLayout(null);
		setBounds(0, 0, 800, 800);
		setTurn();
		setDol();
		setReset();
	}

	private void setDol() {
		int x = 800 / 2 - 50 * MAX / 2;
		int y = 800 / 2 - 50 * MAX / 2;

		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				this.dols[i][j] = new JButton();
				this.dols[i][j].setBounds(x, y, 50, 50);
				this.dols[i][j].setBackground(new Color(255, 249, 182));
				this.dols[i][j].addActionListener(this);
				add(this.dols[i][j]);
				x += 50 + 10;
			}
			x = 800 / 2 - 50 * MAX / 2;
			y += 50 + 10;
		}
	}

	private void reset() {
		this.check = new int[MAX][MAX];
		this.turn = 1;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				this.dols[i][j].setBackground(new Color(255, 249, 182));
			}
		}
	}

	private void setReset() {
		this.reset.setBounds(50, 30, 100, 50);
		this.reset.setBackground(new Color(255, 119, 119));
		this.reset.setText("RESET");
		this.reset.addActionListener(this);
		add(this.reset);
	}

	private void setTurn() {
		this.text.setBounds(50, 20, 800, 100);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setFont(new Font("", Font.BOLD, 30));
		add(this.text);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.reset == e.getSource()) {
			reset();
		}

		JButton target = (JButton) e.getSource();
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (target == this.dols[i][j] && this.check[i][j] == 0) {
					if (turn == 1) {
						this.check[i][j] = turn;
						turn = -1;
						this.dols[i][j].setBackground(Color.white);
					} else if (turn == -1) {
						this.check[i][j] = turn;
						turn = 1;
						this.dols[i][j].setBackground(Color.black);
					}

					boolean winner = winCheck();
					if (winner && turn != 0) {
						new Winner(turn);
						turn = 0;
					}
				}
			}
		}

	}

	@Override
	public void run() {
		while (true) {
			if (turn == 1) {
				this.text.setText("순서 : 백돌");
			} else if (turn == -1) {
				this.text.setText("순서 : 흑돌");
			} else
				this.text.setText("게임 종료!");
		}

	}

	private boolean winCheck() {
		int num = 0;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j <= MAX / 2; j++) {
				if (this.check[i][j] == 1 && this.check[i][j + 1] == 1 && this.check[i][j + 2] == 1
						&& this.check[i][j + 3] == 1 && this.check[i][j + 4] == 1) {
					num = 1;
				}
				if (this.check[i][j] == -1 && this.check[i][j + 1] == -1 && this.check[i][j + 2] == -1
						&& this.check[i][j + 3] == -1 && this.check[i][j + 4] == -1) {
					num = -1;
				}
			}
		}

		if (num == 0) {
			for (int i = 0; i <= MAX / 2; i++) { // 00 01 02 03 04 05
				for (int j = 0; j < MAX; j++) {// 10 11 12 13 14 15
					if (this.check[i][j] == 1 && this.check[i + 1][j] == 1 && this.check[i + 2][j] == 1
							&& this.check[i + 3][j] == 1 && this.check[i + 4][j] == 1) {
						num = 1;
						break;
					}
					if (this.check[i][j] == -1 && this.check[i + 1][j] == -1 && this.check[i + 2][j] == -1
							&& this.check[i + 3][j] == -1 && this.check[i + 4][j] == -1) {
						num = -1;
						break;
					}
				}
			}
		}

		if (num == 0) {
			for (int i = 0; i <= MAX / 2; i++) {
				for (int j = 0; j <= MAX / 2; j++) {
					if (this.check[i][j] == 1 && this.check[i + 1][j + 1] == 1 && this.check[i + 2][j + 2] == 1
							&& this.check[i + 3][j + 3] == 1 && this.check[i + 4][j + 4] == 1) {
						num = 1;
						break;
					}
					if (this.check[i][j] == -1 && this.check[i + 1][j + 1] == -1 && this.check[i + 2][j + 2] == -1
							&& this.check[i + 3][j + 3] == -1 && this.check[i + 4][j + 4] == -1) {
						num = -1;
						break;
					}
				}
			}
		}

		if (num == 0) {
			for (int i = 0; i <= MAX / 2; i++) {
				for (int j = MAX - 1; j >= 4; j--) {
					if (this.check[i][j] == 1 && this.check[i + 1][j - 1] == 1 && this.check[i + 2][j - 2] == 1
							&& this.check[i + 3][j - 3] == 1 && this.check[i + 4][j - 4] == 1) {
						num = 1;
						break;
					}
					if (this.check[i][j] == -1 && this.check[i + 1][j - 1] == -1 && this.check[i + 2][j - 2] == -1
							&& this.check[i + 3][j - 3] == -1 && this.check[i + 4][j - 4] == -1) {
						num = -1;
						break;
					}
				}
			}
		}

		if (num == 0)
			return false;
		else
			return true;
	}

}

class omok extends JFrame {
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	private dol Dol = new dol();
	public static int w = dm.width;
	public static int h = dm.height;
	private final int SIZE = 900;

	public omok() {
		super("오목 게임");
		setLayout(null);
		setBounds(w / 2 - SIZE / 2, h / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();

		add(Dol);
		Dol.run();
	}
}

public class 문제03 {

	public static void main(String[] args) {
		// JButton 10 * 10 오목 만들기(숙제)
		omok ok = new omok();
	}

}
