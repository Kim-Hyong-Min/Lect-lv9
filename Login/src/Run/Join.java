package Run;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class joinPanel extends Util{
	
	
	public JTextField id = new JTextField();
	public JTextField pw = new JTextField();
	public JTextField name = new JTextField();
	JLabel title = new JLabel();
	JLabel[] text = new JLabel[3];
	JLabel[] wrong = new JLabel[3];
	
	
	public joinPanel() {
		setLayout(null);
		setBounds(0, 0, 350, 450);
		setTextFiled();
		setText();
		setWorng();
	}


	private void setWorng() {
		for(int i=0; i<3; i++) {
			if(i==0) {
				this.wrong[i] = new JLabel();
				this.wrong[i].setText("");
				this.wrong[i].setFont(new Font("", Font.BOLD, 15));
				this.wrong[i].setBounds(120, 160, 170, 30);
				add(this.wrong[i]);
			}
			else if(i==1){
				this.wrong[i] = new JLabel();
				this.wrong[i].setText("");
				this.wrong[i].setFont(new Font("", Font.BOLD, 15));
				this.wrong[i].setBounds(120, 240, 170, 30);
				add(this.wrong[i]);
			}
			else {
				this.wrong[i] = new JLabel();
				this.wrong[i].setText("");
				this.wrong[i].setFont(new Font("", Font.BOLD, 15));
				this.wrong[i].setBounds(120, 320, 170, 30);
				add(this.wrong[i]);
			}
		}
	}


	private void setText() {
		this.title.setText("회원가입");
		this.title.setBounds(125, 30, 100, 50);
		this.title.setFont(new Font("", Font.PLAIN, 25));
		add(this.title);
		
		for(int i=0; i<3; i++) {
			if(i==0) {
				this.text[i] = new JLabel();
				this.text[i].setText("아이디");
				this.text[i].setBounds(70, 120, 50, 30);
				add(this.text[i]);
			}
			else if(i==1){
				this.text[i] = new JLabel();
				this.text[i].setText("페스워드");
				this.text[i].setBounds(60, 200, 50, 30);
				add(this.text[i]);
			}
			else {
				this.text[i] = new JLabel();
				this.text[i].setText("이름");
				this.text[i].setBounds(70, 280, 50, 30);
				add(this.text[i]);
			}
		}
	}


	private void setTextFiled() {
		int x = 120;
		int y = 30;
		
		this.id.setBounds(120, 120, x, y);
		add(this.id);
		this.pw.setBounds(120, 200, x, y);
		add(this.pw);
		this.name.setBounds(120, 280, x, y);
		add(this.name);
	}
	
}

public class Join extends JFrame{
	
	public joinPanel panel = new joinPanel();
	
	public Join() {
		super("Join");
		setLayout(null);
		setBounds(Frame.W/2-350/2, Frame.H/2-450/2, 350, 450);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(this.panel);
		
		setVisible(true);
		revalidate();
	}
}
