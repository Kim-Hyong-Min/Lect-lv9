package basic;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Clock extends JFrame implements Runnable{
	private JLabel timer = new JLabel();
	
	public Clock() {
		super("clock");
		setBounds(100, 100, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTimer();
		
		setVisible(true);
		revalidate();
	}

	private void setTimer() {
		this.timer.setText("ready");
		this.timer.setBounds(0, 0, 400, 400);
		this.timer.setFont(new Font("", Font.BOLD, 50));
		this.timer.setHorizontalAlignment(JLabel.CENTER);
		this.timer.setVerticalAlignment(JLabel.CENTER);
		add(this.timer);
		
	}

	@Override
	public void run() {
		int n = 0;
		while(true) {
			n++;
			this.timer.setText(String.format("%5d.%3d", n/1000, n%1000)); // %5d ¿¡¼­ 5´Â ¸îÄ­À» ¶ÛÁö
			try {
				Thread.sleep(1);
			} catch (Exception e) {
			}
		}
	}
}

public class Ex03 {

	public static void main(String[] args) {
//		Clock clock = new Clock();
		Runnable clock = new Clock();
		Thread thread = new Thread(clock);
		thread.start();
	}

}
