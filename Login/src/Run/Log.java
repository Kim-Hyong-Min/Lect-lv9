package Run;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


class logPanel extends Util{
	public JTextField login = new JTextField();
	public JTextField pass = new JTextField();
	private JLabel title = new JLabel();
	private JLabel[] text = new JLabel[2];
	private JLabel[] wrong = new JLabel[2];
	
	public logPanel() {
		setLayout(null);
		setBounds(0, 0, 300, 400);
		setLog();
		setText();
		setWrong();
	}

	private void setWrong() {
		for(int i=0; i<2; i++) {
			if(i==0) {
				this.wrong[i] = new JLabel();
				this.wrong[i].setText("");
				this.wrong[i].setFont(new Font("", Font.BOLD, 15));
				this.wrong[i].setBounds(100, 180, 170, 30);
				add(this.wrong[i]);
			}
			else {
				this.wrong[i] = new JLabel();
				this.wrong[i].setText("");
				this.wrong[i].setFont(new Font("", Font.BOLD, 15));
				this.wrong[i].setBounds(100, 250, 170, 30);
				add(this.wrong[i]);
			}
		}
	}

	private void setText() {
		
		this.title.setText("로그인");
		this.title.setBounds(110, 50, 100, 50);
		this.title.setFont(new Font("", Font.PLAIN, 25));
		add(this.title);
		
		for(int i=0; i<2; i++) {
			if(i==0) {
				this.text[i] = new JLabel();
				this.text[i].setText("아이디");
				this.text[i].setBounds(50, 150, 50, 30);
				add(this.text[i]);
			}
			else {
				this.text[i] = new JLabel();
				this.text[i].setText("페스워드");
				this.text[i].setBounds(45, 220, 50, 30);
				add(this.text[i]);
			}
		}
		
	}

	private void setLog() {
		int x = 120;
		int y = 30;
		
		this.login.setBounds(100, 150, x, y);
		add(this.login);
		this.pass.setBounds(100, 220, x, y);
		add(this.pass);
	}
	
}

public class Log extends JFrame{
	public logPanel log = new logPanel();

	public Log() {
		super("Login");
		setLayout(null);
		setBounds(Frame.W/2-300/2, Frame.H/2-400/2, 300, 400);
		
		add(log);
		
		setVisible(true);
		revalidate();
	}

}
