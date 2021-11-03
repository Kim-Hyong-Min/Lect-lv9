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


class ResultFrame extends JFrame{
	private JLabel text = new JLabel();
	
	public ResultFrame(String winText) {
		super("Game Clear");
		setLayout(null);
		setBounds(TicFrame.width/2-300/2, TicFrame.height/2-200/2, 300, 200);
		text.setBounds(0, 0, 300, 150);
		text.setText(winText);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}



class TicGame extends JPanel implements ActionListener{
	private JButton bt = new JButton();
	private JButton[] map = new JButton[9];
	private int[] mark = new int[9];
	private int turn = 1;
	private int win;
	
	public TicGame() {
		setLayout(null);
		setBounds(0, 0, TicFrame.SIZE,  TicFrame.SIZE);
		setMap();
		Reset();
	}
	
	public void Reset() {
		bt.setBounds(300, 550, 100, 50);
		bt.setText("RESET");
		bt.setBackground(new Color(162, 205, 205));
		bt.addActionListener(this);
		add(bt);
	}
	
	public void setMap() {
		int x = TicFrame.SIZE/2-100*3/2;
		int y = TicFrame.SIZE/2-100*3/2;
		for(int i=0; i<this.map.length; i++) {
			this.map[i] = new JButton();
			this.map[i].setBounds(x, y, 100, 100);
			this.map[i].setBackground(new Color(255, 225, 175));
			this.map[i].addActionListener(this);
			add(this.map[i]);
			x += 100;
			if(i%3==2) {
				x = TicFrame.SIZE/2-100*3/2;
				y+=100;
			}
		}

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.bt) {
			this.turn = 1;
			this.win = 0;
			this.mark = new int[9];
			for(int i=0; i<this.map.length; i++) {
				this.map[i].setBackground(new Color(255, 225, 175));
			}
		}
		
		JButton target = (JButton) e.getSource();
		
		for(int i=0; i<this.map.length; i++) {
			if(target == this.map[i] && this.mark[i] == 0) {
				if(this.turn==1)
					target.setBackground(new Color(198, 213, 126));
				else
					target.setBackground(new Color(213, 126, 126));
				this.mark[i] = this.turn;
				checkWin();
				this.turn = this.turn == 1? 2 : 1;
			}
		}
		
	}
	
	
	private void checkWin() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			new ResultFrame(String.format("P%d의 승!", this.win));
		}
	}
	/*
	 * 0 1 2
	 * 3 4 5
	 * 6 7 8
	 */

	private int checkReverse() {
		int cnt = 0;
		for(int i=1; i<=3; i++) {
			if(this.mark[i*2]==this.turn)
				cnt++;
		}
		if(cnt == 3)
			return this.turn;
		return 0;
	}

	private int checkDia() {
		int cnt = 0;
		for(int i=0; i<3; i++) {
			if(this.mark[i*4]==this.turn)
				cnt++;
		}
		if(cnt == 3)
			return this.turn;
		return 0;
	}

	private int checkVerti() {
		for(int i=0; i<3; i++) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(this.mark[i+j*3] == this.turn)
					cnt++;
			}
			if(cnt == 3)
				return this.turn;
		}
		return 0;
	}

	private int checkHori() {
		for(int i=0; i<this.mark.length; i+=3) {
			int cnt = 0;
			for(int j=0; j<3; j++) {
				if(this.mark[i+j] == this.turn)
					cnt++;
			}
			if(cnt==3)
				return this.turn;
		}
		return 0;
	}
}

class TicFrame extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel text = new JLabel();
	public static int width = dm.width;
	public static int height = dm.height;
	
	public static final int SIZE = 700;
	
	public TicFrame() {
		super("Tic Tac Toe");
		setLayout(null);
		setBounds(width/2-SIZE/2, height/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		text.setBounds(200, 0, 300, 200);
		text.setFont(new Font("", Font.BOLD, 20)); // 폰트 크기 설정
		text.setText("~ Tic Tac Toe Game ~");
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		add(new TicGame());
		setVisible(true);
		revalidate();
	}
	
}

public class Ex02 {

	public static void main(String[] args) {
		TicFrame game = new TicFrame();

	}

}
