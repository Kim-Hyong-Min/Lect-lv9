package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GameWin extends JFrame {
	private JLabel jb = new JLabel();

	public GameWin() {
		super("Clear!!");
		setLayout(null);
		setBounds(0, 0, 300, 200);
		jb.setBounds(35, 0, 200, 150);
		jb.setFont(new Font("", Font.PLAIN, 20));
		setTime();
		jb.setHorizontalAlignment(JLabel.CENTER);
		add(jb);
		setVisible(true);
		revalidate();
		MyJFrame.reStart();
	}

	private void setTime() {
		if (MyJFrame.min == 0) {
			if (MyJFrame.sec < 10) {
				jb.setText("Ŭ���� �ð� : 00:0" + MyJFrame.sec);
			} else {
				jb.setText("Ŭ���� �ð� : 00:" + MyJFrame.sec);
			}
		} else {
			if (MyJFrame.min < 10) {
				if (MyJFrame.sec < 10) {
					jb.setText("Ŭ���� �ð� : 0" + MyJFrame.min + ":0" + MyJFrame.sec);
				} else {
					jb.setText("Ŭ���� �ð� : 0" + MyJFrame.min + ":" + MyJFrame.sec);
				}
			} else {
				if (MyJFrame.sec < 10) {
					jb.setText("Ŭ���� �ð� : " + MyJFrame.min + ":0" + MyJFrame.sec);
				} else {
					jb.setText("Ŭ���� �ð� : " + MyJFrame.min + ":" + MyJFrame.sec);
				}
			}
		}
	}

}

class Game extends JPanel implements ActionListener {
	public static Random rn = new Random();
	public static final int NUM = 25;
	public static JButton number[] = new JButton[NUM];
	public static int front[] = new int[NUM];
	public static int back[] = new int[NUM];
	public static int check[] = new int[NUM];
	public static int cnt;

	public Game() {
		setGame();
		setLayout(null);
		setBounds(0, 0, MyJFrame.total-100, MyJFrame.total-100);
		setButton();
	}

	private void win() {
		if (cnt > this.NUM * 2) {
			MyJFrame.finish = true;
			GameWin gw = new GameWin();
		}
	}

	public static void setGame() {
		for (int i = 0; i < NUM; i++) {
			front[i] = i + 1;
			back[i] = i + 1 + NUM;
		}

		// ����
		for (int i = 0; i < 1000; i++) {
			int rNum = rn.nextInt(NUM);
			int temp = front[0];
			front[0] = front[rNum];
			front[rNum] = temp;

			rNum = rn.nextInt(NUM);
			temp = back[0];
			back[0] = back[rNum];
			back[rNum] = temp;
		}
	}

	private void setButton() {// 400-250 = 150
		int w = MyJFrame.total / 2 - 100 * 5 / 2;
		int h = MyJFrame.total / 2 - 100 * 5 / 2;
		for (int i = 0; i < this.NUM; i++) {// 0,100,200,300,400 / 5,10,15,20
			if (i != 0 && i % 5 == 0) {
				h += 100+3;
				w = MyJFrame.total / 2 - 100 * 5 / 2;
			}
			this.number[i] = new JButton();
			this.number[i].setBounds(w, h, 100, 100);
			this.number[i].setBackground(new Color(211, 228, 205));
			this.number[i].addActionListener(this);
			this.number[i].setFont(new Font("", Font.BOLD, 20));
			this.number[i].setText(String.valueOf(this.front[i]));

			add(this.number[i]);
			w += 100+3;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton push = (JButton) e.getSource();

		for (int i = 0; i < this.NUM; i++) {
			
			if (push == this.number[i] && this.number[i].getText().equals(String.valueOf(cnt))) {
				if (cnt <= this.NUM) {// 1~25
					this.number[i].setBackground(new Color(153, 167, 153));
					this.number[i].setFont(new Font("", Font.BOLD, 20));
					this.number[i].setText(String.valueOf(this.back[i]));
				} else {// 26~50
					this.number[i].setBackground(new Color(254, 245, 237));
					this.number[i].setFont(new Font("", Font.BOLD, 20));
					this.number[i].setText("");
				}
				cnt++;
				win();
			}
		}

	}

}

class MyJFrame extends JFrame implements ActionListener, Runnable {
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static JLabel jb = new JLabel();
	public static int w = dm.width;
	public static int h = dm.height;
	public static final int total = 800;
	private static JButton re = new JButton();

	public static int min = 0;
	public static int sec = 0;
	public static boolean finish;

	public MyJFrame() {
		super("1 to 50");
		setLayout(null);
		setBounds(w / 2 - total / 2, h / 2 - total / 2, total, total);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		jb.setBounds(300, 0, 200, 150);
		jb.setFont(new Font("", Font.BOLD, 30));
		jb.setText(String.valueOf(this.min));
		jb.setHorizontalAlignment(JLabel.CENTER);
		add(jb);
		add(new Game());
		setVisible(true);
		revalidate();
		setReset();
	}

	public static void reStart() {
		Game.front = new int[Game.NUM];
		Game.back = new int[Game.NUM];
		Game.check = new int[Game.NUM];
		Game.cnt = 0;
		min = 0;
		sec = 0;
		finish = true;
		jb.setText("ready");
		re.setText("START");
		re.setBackground(new Color(255, 146, 146));
		reset();
	}

	private static void reset() {
		Game.setGame();
		for (int i = 0; i < Game.NUM; i++) {
			Game.number[i].setBackground(new Color(211, 228, 205));
			Game.number[i].setFont(new Font("", Font.BOLD, 20));
			Game.number[i].setText(String.valueOf(Game.front[i]));
		}
	}

	private void setReset() {
		
		finish = true;
		jb.setText("ready");
		
		re.setBounds(350, 700, 100, 50);
//		re.setBackground(new Color(255, 204, 210));
		re.setFont(new Font("", Font.BOLD, 15));
		
		re.setText("START");
		re.setBackground(new Color(255, 146, 146));
		
//		re.setText("RESET");
		re.addActionListener(this);
		add(re);
	}

	@Override
	public void run() {
		System.out.println("start");
		while (!finish) {
			if (this.min == 0) {
				if (this.sec < 10) {
					jb.setText("00:0" + this.sec);

				} else {
					jb.setText("00:" + this.sec);
				}
			} else {
				if (this.min < 10) {
					if (this.sec < 10) {
						jb.setText("0" + this.min + ":0" + this.sec);

					} else {
						jb.setText("0" + this.min + ":" + this.sec);
					}
				} else {
					if (this.sec < 10) {
						jb.setText(this.min + ":0" + this.sec);

					} else {
						jb.setText(this.min + ":" + this.sec);
					}
				}
			}
			this.sec++;
			if (this.sec == 60) {
				this.min++;
				this.sec = 0;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (this.re == e.getSource() && finish == false) { // �ð� ����, front/back/check ����, cnt ����, ��ư ���� ����
			reStart();
		} else if (this.re == e.getSource() && finish == true) {
			Game.cnt = 1;
			finish = false;
			re.setText("RESET");
			re.setBackground(new Color(255, 204, 210));
			����02.run();
		}

	}

}

public class ����02 {
	public static Runnable mf = new MyJFrame();

	public static void run() {
		Thread thread = new Thread(mf);
		thread.start();
	}

	public static void main(String[] args) {
		run();

	}
}
