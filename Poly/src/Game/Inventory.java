package Game;

public class Inventory {
	private int itemCode;
	private int itemNum;
	
	public Inventory(int itemCode, int itemNum){
		this.itemCode = itemCode;
		this.itemNum+= itemNum;
	}
}
