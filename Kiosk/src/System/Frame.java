package System;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Frame extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int W = dm.width;
	public static int H = dm.height;
	
	private final int X = 700;
	private final int Y = 1000;
	
	public Frame() {
		super("Gong Cha");
		setLayout(null);
		setBounds(W/2-X/2, H/2-Y/2, X, Y);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new Panel());
		
		setVisible(true);
		revalidate();
	}
}
