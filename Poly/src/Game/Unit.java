package Game;

public abstract class Unit {
	String name;
	int Max_Hp;
	int hp;
	int atk;
	boolean dead;
	
	Unit(){}
	
	public Unit(String name, int Max_Hp, int atk){
		this.name = name;
		this.Max_Hp = Max_Hp;
		this.hp = Max_Hp;
		this.atk = atk;
	}
	
	public void skill() {
		
	}
}
