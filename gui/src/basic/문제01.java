package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Tic extends JPanel implements ActionListener {
	private JButton bt = new JButton();
	public static int check[] = new int[9];
	private static int turn = 1;

	public Tic(int x, int y, int w, int h, int num) {
		setLayout(null);
		setBounds(0, 0, 500, 500);
		bt.setBounds(x, y, w, h);
		String number = String.valueOf(num);
		bt.setText(number);
		bt.setBackground(Color.gray);
		bt.addActionListener(this);
		add(bt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.bt && this.check[Integer.parseInt(bt.getText()) - 1] == 0) {
			if (turn == 1) {
				this.check[Integer.parseInt(bt.getText()) - 1] = 1;
				bt.setBackground(Color.green);
				turn = 2;
			} else if (turn == 2) {
				this.check[Integer.parseInt(bt.getText()) - 1] = 2;
				bt.setBackground(Color.red);
				turn = 1;
			}
		}
		numCheck();
	}

	public void numCheck() {
		if (turn != 3) {
		for (int i = 0; i < check.length; i += 3) {
			if (check[i] == 1 && check[i + 1] == 1 && check[i + 2] == 1) {
				System.out.println("P1ÀÇ ½Â¸®!");
				turn = 3;
			}
			if (check[i] == 2 && check[i + 1] == 2 && check[i + 2] == 2) {
				System.out.println("P2ÀÇ ½Â¸®!");
				turn = 3;
			}
		}
		}

		if (turn != 3) {
			for (int i = 0; i < 3; i++) {
				if (check[i] == 1 && check[i + 3] == 1 && check[i + 6] == 1) {
					System.out.println("P1ÀÇ ½Â¸®!");
					turn = 3;
				}
				if (check[i] == 2 && check[i + 3] == 2 && check[i + 6] == 2) {
					System.out.println("P2ÀÇ ½Â¸®!");
					turn = 3;
				}
			}
		}

		if (turn != 3) {
			if (check[0] == 1 && check[4] == 1 && check[8] == 1) {
				System.out.println("P1ÀÇ ½Â¸®!");
				turn = 3;
			}
			if (check[0] == 2 && check[4] == 2 && check[8] == 2) {
				System.out.println("P2ÀÇ ½Â¸®!");
				turn = 3;
			}
		}

		if (turn != 3) {
			if (check[2] == 1 && check[4] == 1 && check[6] == 1) {
				System.out.println("P1ÀÇ ½Â¸®!");
				turn = 3;
			}
			if (check[2] == 2 && check[4] == 2 && check[6] == 2) {
				System.out.println("P2ÀÇ ½Â¸®!");
				turn = 3;
			}
		}

		if (turn != 3) {
			int cnt = 0;
			for (int i = 0; i < check.length; i++) {
				if (check[i] != 0) {
					cnt++;
				}
			}
			if (cnt == check.length) {
				System.out.println("¹«½ÂºÎÀÔ´Ï´Ù.");
				turn = 3;
			}
		}

	}

}

class Frame extends JFrame {

	public Frame() {
		setLayout(null);
		setTitle("Tic Tac Toe");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		for(int i=0; i<Tic.check.length; i++) {
			if(i<3) {
				add(new Tic(50+i*100, 50, 100, 100, i+1));
			}
			else if(i>=3 && i<6) {
				add(new Tic(50+(i-3)*100, 150, 100, 100, i+1));
			}
			else if(i>=6) {
				add(new Tic(50+(i-6)*100, 250, 100, 100, i+1));
			}
		}
		setVisible(true);
		revalidate();
	}

}

public class ¹®Á¦01 {

	public static void main(String[] args) {
		Frame f = new Frame();

	}

}
