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
	
	Monster (String name, int level, int maxHp, int atk, int def, int exp){
		this.name = name;
		this.level = level;
		this.maxHp = maxHp;
		this.atk = atk;
		this.def = def;
		this.exp = exp;
	}
}
