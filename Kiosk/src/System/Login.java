package System;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame {
	public JTextField id = new JTextField();
	public JTextField pw = new JTextField();
	
	private JLabel title = new JLabel();
	private JLabel idText = new JLabel();
	private JLabel pwText = new JLabel();
	
	public JButton in = new JButton();
	public JButton reset = new JButton();
	
	public Login() {
		super("관리자 로그인");
		setLayout(null);
		setBounds(Frame.W/2-400/2, Frame.H/2-600/2, 400, 500);
		setBackground(Color.white);
		
		setTextfield();
		setText();
		setButton();
		
		setVisible(true);
		revalidate();
	}

	private void setButton() {
		this.in.setBounds(250, 300, 80, 50);
		this.in.setText("확인");
		this.in.setFont(new Font("", Font.BOLD, 20));
		add(this.in);
		
		this.reset.setBounds(50, 300, 80, 50);
		this.reset.setText("취소");
		this.reset.setFont(new Font("", Font.BOLD, 20));
		add(this.reset);
	}

	private void setText() {
		this.title.setBounds(150, 20, 100, 50);
		this.title.setText("Login");
		this.title.setFont(new Font("", Font.BOLD, 30));
		add(this.title);
		
		this.idText.setBounds(100, 100, 80, 30);
		this.idText.setText("아이디");
		this.idText.setFont(new Font("", Font.PLAIN, 20));
		add(this.idText);
		
		this.pwText.setBounds(100, 200, 80, 30);
		this.pwText.setText("패스워드");
		this.pwText.setFont(new Font("", Font.PLAIN, 20));
		add(this.pwText);
	}

	private void setTextfield() {
		this.id.setBounds(200, 100, 100, 30);
		add(this.id);
		this.pw.setBounds(200, 200, 100, 30);
		add(this.pw);
	}
}
