package Game;

public class Shop extends Unit {
	private UnitManager um = UnitManager.getInstance();
	
	private String itemName;
	private int itemCode;
	private int price;
	private int Atk;
	private int Add_Hp;
	private int Add_Mp;
	private int Potion;
	
	public Shop(String itemName, int itemCode, int price, int Atk, int Add_Hp, int Add_Mp, int Potion){
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.price = price;
		this.Atk = Atk;
		this.Add_Hp = Add_Hp;
		this.Add_Mp = Add_Mp;
		this.Potion = Potion;
	}
	
	public String getItemName() {
		return this.itemName;
	}
	
	public int getItemCode() {
		return this.itemCode;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getAtk() {
		return this.Atk;
	}
	
	public int getAdd_Hp() {
		return this.Add_Hp;
	}
	
	public int getAdd_Mp() {
		return this.Add_Mp;
	}
	
	public int getPotion() {
		return this.Potion;
	}
	
	
	public void drinkPotion(int idx) {
		um.party.get(idx).heal(Potion);
	}
	
	public void printWeapon() {
		
	}
	
	public void printArmor() {
		
	}

	public void printRing() {
	
	}
	
	public void printPotion() {
		
	}
	
	public void itemCheck(int itemCode) {
		
	}
}
