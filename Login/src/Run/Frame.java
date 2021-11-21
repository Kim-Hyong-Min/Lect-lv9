package Run;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	
	public Frame() {
		super("JAVA");
		setLayout(null);
		setBounds(W/2-400/2, H/2-500/2, 400, 500);
		
		add(new Panel());
		
		setVisible(true);
		revalidate();
	}
	
	
	
}
