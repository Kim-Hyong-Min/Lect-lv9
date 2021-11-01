package models;

interface Attack{
	public void attack(int num);
}

interface Damage{
	public void damage(int num);
}

public abstract class Unit {
	private String name;
	private int Max_Hp;
	private int Hp;
	private int Atk;
	private int Def;
	private int Potion;
	private int state;
	
	Unit(){}
	
	public Unit( int Max_Hp, int Atk,  int Def, int Potion) {
		this.Max_Hp = Max_Hp;
		this.Hp = Max_Hp;
		this.Atk = Atk;
		this.Def = Def;
		this.Potion = Potion;
	}
	
	public Unit(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		this.name = name;
		this.Max_Hp = Max_Hp;
		this.Hp = Max_Hp;
		this.Atk = Atk;
		this.Def = Def;
		this.Potion = Potion;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPotion() {
		return this.Potion;
	}
	
	public int getHp() {
		return this.Hp;
	}
	
	public int getMax_Hp() {
		return this.Max_Hp;
	}
	
	public int getAtk() {
		return this.Atk;
	}
	
	public int getDef() {
		return this.Def;
	}
	
	public boolean deadCheck() {
		if(this.Hp==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getState() {
		return this.state;
	}
	
	public void setState(int num) {
		this.state = num;
	}
	
	
	public void setHp(int num) {
		if(this.Hp+num>=this.Max_Hp) {
			this.Hp = this.Max_Hp;
			System.out.println("채력을 전부 회복했다!");
		}
		else {
			this.Hp += num;
			System.out.printf("채력을 %d만큼 회복했다!\n",num);
		}
	}
	
	public void setDmg(int num) {
		if(this.Hp-num<0) {
			this.Hp = 0;
		}
		else {
			this.Hp-=num;
		}
	}
	
	public void setAtk(int num) {
		this.Atk += num;
		System.out.printf("공격력이 %d만큼 올랐다!\n",num);
	}
	
	public void setDef(int num) {
		this.Def += num;
		System.out.printf("방어력이 %d만큼 올랐다!\n",num);
	}
	
	public void setMax_Hp(int num) {
		this.Max_Hp += num;
		this.Hp += num;
		System.out.printf("채력이 %d만큼 올랐다!\n",num);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPotion(int num) {
		this.Potion += num;
	}
	
	public void printUi() {
		System.out.printf("[이름 %s] [채력 %d/%d] [공격력 %d] [방어력 %d]\n",this.name, this.Hp, this.Max_Hp, this.Atk, this.Def);
	}
	
	
	
}
