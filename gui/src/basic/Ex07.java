package basic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class joinFrame extends JFrame{
	
	JLabel idLabel = new JLabel("id: ");
	JLabel pwLabel = new JLabel("pw: ");
	JLabel nameLabel = new JLabel("name: ");
	
	JTextField idField = new JTextField();
	JTextField pwField = new JTextField();
	JTextField nameField = new JTextField();
	
	public joinFrame() {
		setLayout(null);
		setBounds(200, 200, 300, 400);
		
		setTextField();
		
		setVisible(true);
		revalidate();
	}

	private void setTextField() {
		idLabel.setBounds(30, 50, 60, 50);
		add(idLabel);
		
		idField.setBounds(90, 50, 150, 50);
		add(idField);
		
		pwLabel.setBounds(30, 110, 150, 50);
		add(pwLabel);
		
		pwField.setBounds(90, 110, 150, 50);
		add(pwField);
		
		nameLabel.setBounds(30, 170, 150, 50);
		add(nameLabel);
		
		nameField.setBounds(90, 170, 150, 50);
		add(nameField);
	}
}

class ExPanel extends JPanel implements KeyListener, ActionListener{
	
	// 줄바꿈 불가
	JTextField jf = new JTextField();
	
	// 줄바꿈 가능 -> JTextArea 활용
	JTextArea ja = new JTextArea();
	
	// 로그인 & 회원가입
	// ㄴ 메인 프레임에 버튼 두개
	// ㄴ 로그인과 회원가입
	// ㄴ 버튼을 누르면 -> 팝업(세로운 프레임) -> 텍스트 입력
	// ㄴ 회원가입 정보는 Vector에 저장
	
	Vector<Vector<String>> users = new Vector<>();
	// User : Vector<String>
	// ㄴ add(id) : 중복예외처리
	// ㄴ add(pw)
	// ㄴ add(name)
	
	// 옵션 : 파일처리까지
	
	JButton login = new JButton();
	JButton join = new JButton();
	
	joinFrame joinFrame = null;
	
	public ExPanel() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		
//		setTextField();
//		setTextArea();
		
		setButton();
	}

	private void setButton() {
		this.login.setBounds(100, 100, 100, 100);
		this.login.setText("login");
		this.login.addActionListener(this);
		add(this.login);
		
		this.join.setBounds(210, 100, 100, 100);
		this.join.setText("join");
		this.join.addActionListener(this);
		add(this.join);
		
	}

	private void setTextArea() {
		ja.setBounds(100, 200, 200, 200);
		add(ja);
	}

	private void setTextField() {
		jf.setBounds(100, 100, 100, 30);
		jf.setFocusable(true);
		jf.addKeyListener(this);
		add(jf);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("press");
		
		if(e.getSource() == this.joinFrame.idField || e.getSource() == this.joinFrame.pwField || e.getSource() == this.joinFrame.nameField) {
			String id = this.joinFrame.idField.getText();
			String pw = this.joinFrame.pwField.getText();
			String name = this.joinFrame.nameField.getText();
			
			if(!id.equals("") && !pw.equals("") && !name.equals("")) {
				// join
				joinUser(id, pw, name);
			}
		}
	}

	private void joinUser(String id, String pw, String name) {
		boolean check = checkUserId(id);
		
		if(!check) {
		// User
		Vector<String> user = new Vector<>();
		user.add(id);
		user.add(pw);
		user.add(name);
		
		this.users.add(user);
		
		System.out.println("회원가입 완료!");
		System.out.println("user.size() : "+this.users.size());
		
		this.joinFrame.dispose(); // 프레임에 대한 창 닫기
		}
		else {
			// 단순 팝업창을 띄울때에만 사용(권장 X)
			JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
		}
	}

	private boolean checkUserId(String id) {
		for(int i=0; i<this.users.size(); i++) {
			if(this.users.get(i).get(0).equals(id))
				return true;
		}
		return false;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.join) {
			this.joinFrame = new joinFrame();
//			this.joinFrame.setFocusable(true);
//			this.joinFrame.addKeyListener(this);
			
			this.joinFrame.idField.setFocusable(true);
			this.joinFrame.idField.addKeyListener(this);
			
			this.joinFrame.pwField.setFocusable(true);
			this.joinFrame.pwField.addKeyListener(this);
			
			this.joinFrame.nameField.setFocusable(true);
			this.joinFrame.nameField.addKeyListener(this);
		}
		
	}
}

public class Ex07 extends JFrame{
	
	
	
	public Ex07() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new ExPanel());
		
		setVisible(true);
		revalidate();
		
	}
	
	public static void main(String[] args) {
		
		new Ex07();
	}

}
