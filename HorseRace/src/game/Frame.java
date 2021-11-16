package game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	Panel p = new Panel();
	
	public Frame() {
		super("경마 게임");
		setLayout(null);
		setBounds(W/2-800/2, H/2-600/2, 800, 600);
		
		add(p);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();
		p.run();
	}
}
