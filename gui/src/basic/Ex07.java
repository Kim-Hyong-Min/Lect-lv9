package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

class joinFrame extends JFrame{
	
	JLabel Label = new JLabel("text<br>text"); //JLabel �ؽ�Ʈ �ٹٲ�
	
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
	
	// �ٹٲ� �Ұ�
	JTextField jf = new JTextField();
	
	// �ٹٲ� ���� -> JTextArea Ȱ��
	JTextArea ja = new JTextArea();
	
	// �α��� & ȸ������
	// �� ���� �����ӿ� ��ư �ΰ�
	// �� �α��ΰ� ȸ������
	// �� ��ư�� ������ -> �˾�(���ο� ������) -> �ؽ�Ʈ �Է�
	// �� ȸ������ ������ Vector�� ����
	
	Vector<Vector<String>> users = new Vector<>();
	Vector<String> colName = null;
	
	// User : Vector<String>
	// �� add(id) : �ߺ�����ó��
	// �� add(pw)
	// �� add(name)
	
	// �ɼ� : ����ó������
	
	JButton login = new JButton();
	JButton join = new JButton();
	
	joinFrame joinFrame = null;
	
	JTable table = null;
	
	public ExPanel() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		
//		setTextField();
//		setTextArea();
		
		
		setTable();
		setButton();
		
		init();
	}

	private void init() { // ���� ������
		Random rn = new Random();
		
		
		String[] front = {"��","��","��","��","��"};
		String[] back = {"��","��","��","��","��"};
		String[] back2 = {"��","��","��","��","��"};
		
		
		for(int i=0; i<100; i++) {
			Vector<String> user = new Vector<>();
			String name = front[rn.nextInt(front.length)] + back[rn.nextInt(back.length)] + back2[rn.nextInt(back2.length)];
			user.add(name);
			user.add(i+"");
			user.add(i+"");
			this.users.add(user);
		}
		
	}

	private void setTable() {
		this.colName = new Vector();
		this.colName.add("id");
		this.colName.add("pw");
		this.colName.add("name");
		
		// table ����
		table = new JTable(users, colName);
		table.setBounds(50, 50, 300, 300);
		
		// table �ٹ̱�
		table.setBorder(new LineBorder(Color.red));
		table.setGridColor(Color.black);
		
//		add(table);
		
		// ��ũ�� ��� �߰� (�����Ͱ� ���� ��)
		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 300, 300);
		js.setAutoscrolls(true); // default
		
		add(js);
	}

	private void setButton() {
		this.login.setBounds(100, 380, 100, 50);
		this.login.setText("login");
		this.login.addActionListener(this);
		add(this.login);
		
		this.join.setBounds(210, 380, 100, 50);
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
		
		System.out.println("ȸ������ �Ϸ�!");
		System.out.println("user.size() : "+this.users.size());
		
		table.revalidate(); // ���̺� ���� 
		table.repaint(); // ���̺� ����
		
		System.out.println("0 index ");
		System.out.println(this.users.get(0));
		System.out.println(this.users.get(1));
		System.out.println(this.users.get(2));
		
		
		this.joinFrame.dispose(); // �����ӿ� ���� â �ݱ�
		}
		else {
			// �ܼ� �˾�â�� ��ﶧ���� ���(���� X)
			JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �Դϴ�.");
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
		
		
		// Jframe ���� Pane <- ������ ��ü��
		// this.getContentPAne() -> ����â ��ü���� this.setContentPane()
		// ������ ������Ʈ�� ��� ���ư���
		
//		this.getContentPane().add(new ExPanel());
		add(new ExPanel());
		
		setVisible(true);
		revalidate();
		
	}
	
	public static void main(String[] args) {
		
		new Ex07();
	}

}
