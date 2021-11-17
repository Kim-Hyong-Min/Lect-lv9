package Game;

import javax.swing.ImageIcon;

public class Item {
	
	private int x, y, state;
	private boolean goal;
	private ImageIcon image;
	
	public Item(int x, int y, int state, ImageIcon image) {
		this.x = x;
		this.y = y;
		this.state = state;
		this.image = image;
	}
	
	public boolean isGoal() {
		return goal;
	}

	public void setGoal(boolean goal) {
		this.goal = goal;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getState() {
		return state;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public void setState(int state) {
		this.state = state;
	}
	
}
