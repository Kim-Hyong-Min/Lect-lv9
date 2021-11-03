package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// GUI (그레픽 유저 인터페이스)
// ㄴ awt(사용자의 os의 리소스를 사용해 비교적 무겁다) & swing(자바라이브러리-라이트함)

// UI 엘리먼트를 담는 컨테이너

// 최상의 컨테이너 : JFrame
// 일반 컨페이너 : JPanel
// 컴포넌트 : JButton, JLabel, JTextField, ...

class MyPanel extends JPanel{ // 메뉴얼 페널 - 생성사 정보를 받아 생성
	public MyPanel(int x, int y, int width, int height , Color color) {
		setBounds(x, y, width, height);
		setBackground(color);
	}
	
}

class Contents extends JPanel implements ActionListener{
	
	// 버튼 만들기
	// JButton 클래스를 import -> 객체 생성
	private JButton bt = new JButton();
	private boolean click;
	
	public Contents() {
		setLayout(null);
		setBounds(0, 0, 500, 400);
		
		// 버튼 속성 설정
		System.out.println(this.bt);
		bt.setBounds(100, 100, 100, 100); // 크기와 위치를 지정
		bt.setText("PUSH"); // 버튼의 글씨를 설정
		
		// mac일 경우에만
		bt.setOpaque(true); // 투명도
		bt.setBorderPainted(false); // 태두리 삭제
		
		bt.setBackground(Color.gray); // 버튼 컬러
		bt.addActionListener(this); // 버튼에 리스너를 달아줌
		
		// 패널에 버튼을 달아줌
		add(bt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("야호!");
		
		if(e.getSource() == this.bt) {
			this.click = this.click ? false : true;
			if(this.click)
				this.bt.setBackground(Color.red);
			else
				this.bt.setBackground(Color.gray);
		}
	}
	
}

// JFrame 만들기
class MyFrame extends JFrame{
	
	public MyFrame() {
		// JFrame 설정
		
		// 0.
		// 기본 레이아웃 구성의 설정 -> 순서대로 나열식
		setLayout(null);
		
		// 1.
		// 타이틀
		// super("title")
		// setTitle("title")
		setTitle("MyFrame");
		
		// 2.
		// 크기
		// setBounds(x,y,width,height);
		setBounds(50,50,500,400);
		
		// 3.
		// 종료 조건
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// add() 메소드를 통해 
//		add(new MyPanel(0, 0, 250, 200, Color.pink));
//		add(new MyPanel(0, 200, 250, 200, Color.yellow));
//		add(new MyPanel(250, 0, 250, 200, Color.orange));
//		add(new MyPanel(250, 200, 250, 100, Color.green));
//		add(new MyPanel(250, 300, 125, 100, Color.blue));
//		add(new MyPanel(375, 300, 125, 100, Color.red));
		add(new Contents());
		
		// 4.
		// 보이기
		// setVisible(true)
		setVisible(true);
		
		// 5.
		// 갱신
		revalidate();
	}
}

public class Ex01 {
	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
	}
}