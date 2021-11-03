package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// GUI (�׷��� ���� �������̽�)
// �� awt(������� os�� ���ҽ��� ����� ���� ���̴�) & swing(�ڹٶ��̺귯��-����Ʈ��)

// UI ������Ʈ�� ��� �����̳�

// �ֻ��� �����̳� : JFrame
// �Ϲ� �����̳� : JPanel
// ������Ʈ : JButton, JLabel, JTextField, ...

class MyPanel extends JPanel{ // �޴��� ��� - ������ ������ �޾� ����
	public MyPanel(int x, int y, int width, int height , Color color) {
		setBounds(x, y, width, height);
		setBackground(color);
	}
	
}

class Contents extends JPanel implements ActionListener{
	
	// ��ư �����
	// JButton Ŭ������ import -> ��ü ����
	private JButton bt = new JButton();
	private boolean click;
	
	public Contents() {
		setLayout(null);
		setBounds(0, 0, 500, 400);
		
		// ��ư �Ӽ� ����
		System.out.println(this.bt);
		bt.setBounds(100, 100, 100, 100); // ũ��� ��ġ�� ����
		bt.setText("PUSH"); // ��ư�� �۾��� ����
		
		// mac�� ��쿡��
		bt.setOpaque(true); // ����
		bt.setBorderPainted(false); // �µθ� ����
		
		bt.setBackground(Color.gray); // ��ư �÷�
		bt.addActionListener(this); // ��ư�� �����ʸ� �޾���
		
		// �гο� ��ư�� �޾���
		add(bt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ȣ!");
		
		if(e.getSource() == this.bt) {
			this.click = this.click ? false : true;
			if(this.click)
				this.bt.setBackground(Color.red);
			else
				this.bt.setBackground(Color.gray);
		}
	}
	
}

// JFrame �����
class MyFrame extends JFrame{
	
	public MyFrame() {
		// JFrame ����
		
		// 0.
		// �⺻ ���̾ƿ� ������ ���� -> ������� ������
		setLayout(null);
		
		// 1.
		// Ÿ��Ʋ
		// super("title")
		// setTitle("title")
		setTitle("MyFrame");
		
		// 2.
		// ũ��
		// setBounds(x,y,width,height);
		setBounds(50,50,500,400);
		
		// 3.
		// ���� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// add() �޼ҵ带 ���� 
//		add(new MyPanel(0, 0, 250, 200, Color.pink));
//		add(new MyPanel(0, 200, 250, 200, Color.yellow));
//		add(new MyPanel(250, 0, 250, 200, Color.orange));
//		add(new MyPanel(250, 200, 250, 100, Color.green));
//		add(new MyPanel(250, 300, 125, 100, Color.blue));
//		add(new MyPanel(375, 300, 125, 100, Color.red));
		add(new Contents());
		
		// 4.
		// ���̱�
		// setVisible(true)
		setVisible(true);
		
		// 5.
		// ����
		revalidate();
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
	}
}