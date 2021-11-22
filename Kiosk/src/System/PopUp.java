package System;

import javax.swing.JFrame;

public class PopUp extends JFrame{
	
	public PopUp() {
		super("Option");
		setLayout(null);
		setBounds(Frame.W/2-500/2, Frame.H/2-950/2, 500, 950);
		
		setVisible(true);
		revalidate();
	}
}
