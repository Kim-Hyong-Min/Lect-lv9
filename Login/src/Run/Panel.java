package Run;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Panel extends Util {
	public static Panel instance = new Panel();
	private final int ID = 0;
	private final int PW = 1;
	private final int NAME = 2;
	private Join join = null;
	private Log log = null;

	private int Check = -1;
	private int logCheck = -1;

	public static Vector<Vector<String>> users = new Vector<>();

	private JButton[] btn = new JButton[2];
	private JLabel text = new JLabel();

	private final int LOGIN = 0;
	private final int JOIN = 1;

	public Panel() {
		setLayout(null);
		setBounds(0, 0, 400, 500);

		setBtn();
		setText();
	}

	private void setText() {
		this.text.setText("☕JAVA");
		this.text.setFont(new Font("", Font.BOLD, 50));
		this.text.setBounds(100, 100, 200, 100);
		add(this.text);
	}

	private void setBtn() {
		this.btn[LOGIN] = new JButton();
		this.btn[LOGIN].setText("로그인");
		this.btn[LOGIN].setBounds(150, 300, 100, 30);
		this.btn[LOGIN].addActionListener(this);
		add(this.btn[LOGIN]);
		this.btn[JOIN] = new JButton();
		this.btn[JOIN].setText("회원가입");
		this.btn[JOIN].setBounds(150, 350, 100, 30);
		this.btn[JOIN].addActionListener(this);
		add(this.btn[JOIN]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.logCheck == -1 && e.getSource() == this.btn[LOGIN]) { // 로그인
			this.Check = 1;
			this.log = new Log();
			this.log.log.login.setFocusable(true);
			this.log.log.login.addKeyListener(this);

			this.log.log.pass.setFocusable(true);
			this.log.log.pass.addKeyListener(this);
		} else if (this.logCheck != -1 && e.getSource() == this.btn[LOGIN]) {
			this.btn[LOGIN].setText("로그인");
			this.logCheck = -1;
		}

		if (e.getSource() == this.btn[JOIN]) {// 회원가입
			this.Check = 2;
			System.out.println("회원가입");
			this.join = new Join();
			this.join.panel.id.setFocusable(true);
			this.join.panel.id.addKeyListener(this);

			this.join.panel.name.setFocusable(true);
			this.join.panel.name.addKeyListener(this);

			this.join.panel.pw.setFocusable(true);
			this.join.panel.pw.addKeyListener(this);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (this.Check == 2) {
			if (e.getSource() == this.join.panel.id || e.getSource() == this.join.panel.name
					|| e.getSource() == this.join.panel.pw) {
				String id = this.join.panel.id.getText();
				String pw = this.join.panel.pw.getText();
				String name = this.join.panel.name.getText();

				if (!id.equals("") && !pw.equals("") && !name.equals("")) {
					// join
					if (!IdCheck(id)) {
						JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
					}
					else {
						addData(id, pw, name);
						this.join.dispose();
					}
				}
			}
		} else {
			if (e.getSource() == this.log.log.login || e.getSource() == this.log.log.pass) {
				String logId = this.log.log.login.getText();
				String logPw = this.log.log.pass.getText();

				if (!logId.equals("") && !logPw.equals("")) {
					if (!LoginCheck(logId, logPw)) {
						JOptionPane.showMessageDialog(null, "아이디나 비밀번호를 확인하세요.");
					} else {
						Login(logId, logPw);
						this.log.dispose();
					}
				}
			}
		}

	}

	public void addData(String id, String pw, String name) {
		Vector<String> user = new Vector<>();
		user.add(id);
		user.add(pw);
		user.add(name);
		this.users.add(user);
		System.out.println(users.get(users.size() - 1).get(0));
		System.out.println(users.get(users.size() - 1).get(1));
		System.out.println(users.get(users.size() - 1).get(2));
	}

	public boolean IdCheck(String id) {
		if (this.users.size() > 0) {
			int check = -1;
			for (int i = 0; i < this.users.size(); i++) {
				if (this.users.get(i).get(ID).equals(id)) {
					check++;
				}
			}
			if (check == -1) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

	public boolean LoginCheck(String id, String pw) {
		int check = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).get(ID).equals(id) && this.users.get(i).get(PW).equals(pw)) {
				check = i;
			}
		}
		if (check != -1) {
			return true;
		} else {
			return false;
		}
	}

	public void Login(String id, String pw) {
		int check = -1;
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).get(ID).equals(id) && this.users.get(i).get(PW).equals(pw)) {
				check = i;
			}
		}

		this.logCheck = check;
		this.btn[LOGIN].setText("로그아웃");
	}

}
