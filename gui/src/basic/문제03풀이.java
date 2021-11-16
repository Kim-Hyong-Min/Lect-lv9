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

// ������� (JButton)
// 10*10
// p1, p2

class ButtonPanel extends JPanel{
	public JButton reset = new JButton();
	
	public ButtonPanel() {
		setLayout(null);
		setBounds(0, 0, OmokFrame.SIZE, OmokFrame.SIZE);
		setResetButton();
	}
	
	private void setResetButton() {
		this.reset.setText("RESET");
		this.reset.setFont(new Font("", Font.PLAIN, 50));
		this.reset.setBounds(OmokFrame.SIZE/2-150, OmokFrame.SIZE/2-150, 300, 300);
		add(this.reset);
	}
}

class Result extends JFrame{
	
	private JLabel text = new JLabel();
	
	public Result(String string) {
		super("Game over");
		setLayout(null);
		setBounds(OmokFrame.W/2-150, OmokFrame.H/2-100, 300, 200);
		
		text.setText(string);
		text.setBounds(0, 0, 300, 200);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		
		setVisible(true);
		revalidate();
	}
}

class OmokPanel extends JPanel implements ActionListener{
	private JLabel text = new JLabel("Omok Game");
	
	private final int SIZE = 10;
	private JButton[][] map = new JButton[SIZE][SIZE];
	private int[][] mark = new int[SIZE][SIZE];
	private int turn = 1;
	private int win;
	
	private ButtonPanel reset = new ButtonPanel();
	
	public OmokPanel() {
		setLayout(null);
		setBounds(0, 0, OmokFrame.SIZE, OmokFrame.SIZE);
//		setBackground(Color.orange);
		
		// add(�߰���������Ʈ, 0)
		// 0.... �켱���� ����
		
		//add�ϴ� ������� �켱������ top���� ������.
		this.reset.reset.addActionListener(this);
		add(this.reset);
		this.reset.setVisible(false);
		
		setTitle();
		setMap();
	}

	private void setTitle() {
		this.text.setBounds(0, 0, OmokFrame.SIZE, 100);
		this.text.setHorizontalAlignment(JLabel.CENTER);
		this.text.setFont(new Font("", Font.BOLD, 30));
		add(this.text);
		
	}

	private void setMap() {
		
		int x = OmokFrame.SIZE/2-50*10/2;
		int y = OmokFrame.SIZE/2-50*10/2;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				// ��ư ����
				JButton bt = new JButton();
				
				// ��ư ũ�� ����
				bt.setBounds(x, y, 50, 50); // ��ǥ x, ��ǥ y, ��ư�� ���� ũ��, ��ư�� ���� ũ��
				
				// �� ����
				bt.setBackground(Color.lightGray);
				bt.setOpaque(true);
				bt.setBorderPainted(false);
				
				// �̺�Ʈ ������ �ޱ�
				// JButton : ActionListener <- �������̽��� ����
				bt.addActionListener(this); // this : bt <- �̺�Ʈ �߻���, actionPerformed() �޼ҵ尡 ����
				
				
				this.map[i][j] = bt;
				
				// ���� �г�(this)�� �ޱ�
				add(this.map[i][j]); // add(bt)
				
				// ���� ��ư�� ���� ��ǥ ����
				x += 50+1;
				
			}
			x = OmokFrame.SIZE/2-50*10/2;
			y += 50+1;
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			JButton target = (JButton) e.getSource();
			
			
			if(target == this.reset.reset) {
				resetGame();
			}
			else {
				// �� �ȿ� �ִ� ��ư�� �´���, 
				// � ��ư����
				// turn �� ���� -> marking
				for(int i=0; i<SIZE; i++) {
					for(int j=0; j<SIZE; j++) {
						if(target == this.map[i][j] && this.mark[i][j]==0) {
							if(this.turn==1) {
								target.setBackground(Color.red);
							}
							else {
								target.setBackground(Color.blue);
							}
							
							this.mark[i][j]=this.turn; // ��ŷ�ϰ�
							checkWin();				   // �˻�
							
							this.turn = this.turn == 1 ? 2 : 1;
						}
					}
				}
			}
			
		}
		
	}

	private void resetGame() {
		this.mark = new int[SIZE][SIZE];
		this.turn = 1;
		this.win = 0;
		
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				this.map[i][j].setBackground(Color.lightGray);
			}
		}
		
		// ������Ʈ�� ����
//		this.remove(this.reset);
//		this.revalidate();
//		this.repaint();
		
		this.reset.setVisible(false);
	}

	private void checkWin() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checkDia() : this.win;
		this.win = this.win == 0 ? checkReverse() : this.win;
		
		if(this.win != 0) {
			this.reset.setVisible(true);
			new Result(String.format("P%d Win", this.win));
			
		}
		
	}

	private int checkReverse() {
		for(int i=4; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i-k][j+k]==this.turn) {
							cnt++;
						}
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkDia() {
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j+k]==this.turn) {
							cnt++;
						}
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkVerti() {
		for(int i=0; i<SIZE-4; i++) {
			for(int j=0; j<SIZE; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i+k][j]==this.turn) {
							cnt++;
						}
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}

	private int checkHori() {
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE-4; j++) {
				if(this.mark[i][j] == this.turn) {
					int cnt = 0;
					for(int k=0; k<5; k++) {
						if(this.mark[i][j+k]==this.turn) {
							cnt++;
						}
					}
					if(cnt == 5)
						return this.turn;
				}
			}
		}
		return 0;
	}
	
	
	
	
}

class OmokFrame extends JFrame{
	
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int W = dm.width;
	public static final int H = dm.height;
	
	public static final int SIZE = 700;
	
	private OmokPanel panel = new OmokPanel();
	
	public OmokFrame() {
		
		super("Omok"); // setTitle(String str)
		setLayout(null);
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE); // setLocation(int x, int y), setSize(int width, int height) �� ȥ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(panel);
		
		setVisible(true);
		revalidate();
	}
}

public class ����03Ǯ�� {

	public static void main(String[] args) {
		OmokFrame omok = new OmokFrame();

	}

}
