package basic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class GameWin extends JPanel{
	private JPanel win = new JPanel();
	public static boolean finish;
	public GameWin() {
		win.setLayout(null);
		win.setBounds(MyJFrame.w/2-MyJFrame.total/2,MyJFrame.h/2-MyJFrame.total/2, 300, 200);
	}
	
}

class Game extends JPanel implements ActionListener{
	private Random rn = new Random();
	private final int num = 25;
	private JButton re = new JButton();
	private JButton number[] = new JButton [num];
	private int front[] = new int [num];
	private int back[] = new int [num];
	private int check[] = new int [num];
	private static int cnt = 1;
	
	public Game() {
		setGame();
		setLayout(null);
		setBounds(0,0,MyJFrame.total,MyJFrame.total);
		setButton();
		setReset();
	}
	
	public void setReset() {
		re.setBounds(350, 700, 100, 50);
		re.setBackground(new Color(47, 134, 166));
		re.setFont(new Font("", Font.BOLD, 15));
		re.setText("RESET");
		re.addActionListener(this);
		add(re);
	}
	
	public void win() {
		if(cnt>this.num*2) {
			GameWin.finish = true;
		}
	}
	
	public void setGame() {
		for(int i=0; i<this.num; i++) {
			int rNum = rn.nextInt(25);
			if(this.check[rNum]==0) {
				this.front[i] = rNum+1;
				this.check[rNum] = 1;
			}
			else {
				i--;
			}
		}
		
		for(int i=0; i<this.num; i++) {
			int rNum = rn.nextInt(25);
			if(this.check[rNum]==1) {
				this.back[i] = rNum+26;
				this.check[rNum] = 0;
			}
			else {
				i--;
			}
		}
	}
	
	public void setButton() {// 400-250 = 150
		int w = MyJFrame.total/2-100*5/2;
		int h = MyJFrame.total/2-100*5/2;
		for(int i=0; i<this.num; i++) {//0,100,200,300,400 / 5,10,15,20
			if(i != 0 && i%5==0) {
				h += 100;
				w = MyJFrame.total/2-100*5/2;
			}
			this.number[i] = new JButton();
			this.number[i].setBounds(w, h, 100, 100);
			this.number[i].setBackground(new Color(255, 208, 127));
			this.number[i].addActionListener(this);
			this.number[i].setFont(new Font("", Font.BOLD, 20));
			this.number[i].setText(String.valueOf(this.front[i]));
			
			add(this.number[i]);
			w += 100;
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.re == e.getSource()) {
			this.number = new JButton [num];
			this.front = new int [num];
			this.back = new int [num];
			this.check = new int [num];
			cnt = 1;
			setGame();
			setButton();
		}
		
		
		JButton push = (JButton) e.getSource();
		
		for(int i=0; i<this.num; i++) {
			if(push == this.number[i] && this.number[i].getText().equals(String.valueOf(cnt))) {
				if(cnt<=this.num) {//1~25
					this.number[i].setBackground(new Color(255, 130, 67));
					this.number[i].setFont(new Font("", Font.BOLD, 20));
					this.number[i].setText(String.valueOf(this.back[i]));
					System.out.println(cnt);
				}
				else {//26~50
					this.number[i].setBackground(new Color(255, 208, 127));
					this.number[i].setFont(new Font("", Font.BOLD, 20));
					this.number[i].setText("?");
					System.out.println("??"+cnt);
				}
				cnt++;
				win();
			}
		}
		
	}
	
}

class MyJFrame extends JFrame {
	public static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	private JLabel jb = new JLabel();
	public static int w = dm.width;
	public static int h = dm.height;
	public static final int total = 800;
	
	public MyJFrame() {
		super("1 to 50");
		setLayout(null);
		setBounds(w/2-total/2,h/2-total/2,total,total);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Game());
		setTimer();
		setVisible(true);
		revalidate();
	}
	
	public void setTimer() {
		jb.setBounds(h, total, w, h);
		jb.setFont(new Font("", Font.BOLD, 15));
		jb.setText(getName());
	}
}
public class ¹®Á¦02 {
	public static void main(String[] args) {
		MyJFrame mf = new MyJFrame();
	}
}
