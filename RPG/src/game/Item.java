package game;
public class Item {
	private String name;
	private int atk;
	private int def;
	private int price;
	private int itemCode;
	
	public Item(String name, int atk, int def, int price, int itemCode){
		this.name = name;
		this.atk = atk;
		this.def = def;
		this.price = price;
		this.itemCode = itemCode;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
}