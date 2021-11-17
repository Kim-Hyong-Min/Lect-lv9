package Game;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	private final int SIZE = 1000;
	private Panel p = new Panel();
	public Frame() {
		super("소코반 게임");
		setLayout(null);
		setBounds(W/2-SIZE/2, H/2-SIZE/2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(p);
		
		setVisible(true);
		revalidate();
		p.run();
	}
}
