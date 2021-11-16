package game;

import javax.swing.ImageIcon;

public class Horse {
	private int x, y, rank, num;
	private ImageIcon icon;
	private String lap; // µµÂø½Ã°£
	
	public Horse(ImageIcon icon, int x, int y) {
		this.icon = icon;
		this.x = x;
		this.y = y;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num += num;
	}
	
	public void resetNum(int num) {
		this.num = num;
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

	public ImageIcon getIcon() {
		return icon;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getLap() {
		return lap;
	}

	public void setLap(String lap) {
		this.lap = lap;
	}

}
