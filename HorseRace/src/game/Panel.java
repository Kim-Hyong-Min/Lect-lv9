package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends MyUtil {
	private ArrayList<Horse> horses = new ArrayList<>();
	private final int NUM = 5;
	private int[][] line = new int[6][4];

	private JButton btn = new JButton();
	private boolean check;
	private boolean isRun;

	private JLabel timer = new JLabel();
	private JLabel[][] timeLap = new JLabel[5][2]; // 등수/시간
	private int m; // 타이머 시간

	private final int END = 630;

	public Panel() {
		setLayout(null);
		setBounds(0, 0, 800, 600);

		setLine();
		setHorses();
		setButton();
		setTimer();
		setTimeLap();
	}

	private void setTimeLap() {
		for (int i = 0; i < this.timeLap.length; i++) {
			for (int j = 0; j < this.timeLap[i].length; j++) {
				this.timeLap[i][j] = new JLabel();
				if (j == 0) {// 등수
					this.timeLap[i][j].setBounds(600, 92 * (i + 1), 50, 30);
					this.timeLap[i][j].setText("");
					this.timeLap[i][j].setFont(new Font("", Font.PLAIN, 30));
					add(this.timeLap[i][j]);
				} else {// 시간
					this.timeLap[i][j].setBounds(600, 92 * (i + 1) + 40, 50, 20);
					this.timeLap[i][j].setText("");
					this.timeLap[i][j].setFont(new Font("", Font.PLAIN, 20));
					add(this.timeLap[i][j]);
				}
			}
		}
	}

	private void setTimer() {
		this.timer.setBounds(330, 20, 200, 50);
		this.timer.setText("준비..");
		this.timer.setFont(new Font("", Font.BOLD, 50));
		add(this.timer);
	}

	private void setButton() {
		this.btn.setText("START");
		this.btn.setBounds(50, 20, 100, 40);
		this.btn.addActionListener(this);
		add(this.btn);
	}

	private void setHorses() {
		int x = 50;
		int y = 120;
		int w = 80;
		int l = 60;

		for (int i = 0; i < NUM; i++) {
			Image im = new ImageIcon(String.format("images/horse%d.png", i + 1)).getImage().getScaledInstance(w, l,
					Image.SCALE_SMOOTH);
			ImageIcon icon = new ImageIcon(im);
			Horse h = new Horse(icon, x, y);
			horses.add(h);
			y += 90;
		}

	}

	private void setLine() {
		int y = 90;
		System.out.println(this.line.length);
		for (int i = 0; i < this.line.length; i++) {
			this.line[i][0] = 40; // x1
			this.line[i][1] = y; // y1
			this.line[i][2] = 750; // x2
			this.line[i][3] = y; // y2
			y += 90;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < NUM; i++) {
			Horse t = horses.get(i);
			g.drawImage(t.getIcon().getImage(), t.getX(), t.getY(), null);
		}
		for (int i = 0; i < this.line.length; i++) {
			g.drawLine(this.line[i][0], this.line[i][1], this.line[i][2], this.line[i][3]);
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.btn == e.getSource()) {
			if (!check) {
				System.out.println("start");
				this.btn.setText("RESET");
				this.check = true;
				this.isRun = true;
			} else {
				System.out.println("reset");
				resetGame();
				this.btn.setText("START");
				this.check = false;
			}
		}
	}

	private void resetGame() {
		for (int i = 0; i < this.horses.size(); i++) {
			this.horses.get(i).setX(50);
			this.horses.get(i).resetNum(0);
			this.horses.get(i).setRank(0);
			this.timeLap[i][0].setText("");
			this.timeLap[i][1].setText("");
		}
		this.timer.setText("준비..");
		this.m = 0;
		this.isRun = false;
	}

	public void run() {

		while (true) {
			if (isRun) {
				Random rn = new Random();
				int rank = 0;

				while (true) {
					this.m++;
					this.timer.setText(String.format("%d.%3d", this.m / 1000, this.m % 1000));

					boolean finish = false;
					for (int i = 0; i < this.horses.size(); i++) {
						int rNum = rn.nextInt(2);
						if (this.horses.get(i).getRank() == 0) {
							if (this.horses.get(i).getNum() + rNum >= END) {
								if (!finish) {// 한명씩 골인
									this.horses.get(i).resetNum(END);
									this.horses.get(i).setX(40 + this.horses.get(i).getNum());
									finish = true;
									rank++;
									this.horses.get(i).setRank(rank);
									this.timeLap[i][0].setText(rank + "등");
									this.timeLap[i][1].setText(String.format("%d.%3d", this.m / 1000, this.m % 1000));
								} else {// 대기
									this.horses.get(i).resetNum(END - 1);
									this.horses.get(i).setX(40 + this.horses.get(i).getNum());
								}
							} else {
								this.horses.get(i).setNum(rNum);
								this.horses.get(i).setX(40 + this.horses.get(i).getNum());
							}
						}
					}
					int check = -1;
					for (int i = 0; i < this.horses.size(); i++) {
						if (this.horses.get(i).getRank() == 0) {
							check++;
						}
					}
					if (check == -1 || !this.check) {
						this.isRun = false;
						break;
					}

					try {
						Thread.sleep(1);
					} catch (Exception e) {
					}
				}
			} else {
				if (!check && !isRun) {
					this.timer.setText("준비..");
				}
				if (check && !isRun) {
					finish();
				}
			}
		}

	}

	private void finish() {
		this.timer.setText("종료!");
		this.m = 0;
	}
}
