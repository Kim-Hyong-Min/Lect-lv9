package game;

public class Monster {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int atk;
	private int def;
	private int exp;
	private int Item;
	
	public Monster (String name, int level, int maxHp, int atk, int def, int exp){
		this.name = name;
		this.level = level;
		this.maxHp = maxHp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
	}
	
	
	public void printMonster() {
		System.out.printf("	¿Ã∏ß : %s\n",this.name);
		System.out.printf("	Lv.%d | HP %d/%d \n",this.level, this.hp, this.maxHp);
	}
}
