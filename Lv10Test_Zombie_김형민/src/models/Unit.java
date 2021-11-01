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
			System.out.println("ä���� ���� ȸ���ߴ�!");
		}
		else {
			this.Hp += num;
			System.out.printf("ä���� %d��ŭ ȸ���ߴ�!\n",num);
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
		System.out.printf("���ݷ��� %d��ŭ �ö���!\n",num);
	}
	
	public void setDef(int num) {
		this.Def += num;
		System.out.printf("������ %d��ŭ �ö���!\n",num);
	}
	
	public void setMax_Hp(int num) {
		this.Max_Hp += num;
		this.Hp += num;
		System.out.printf("ä���� %d��ŭ �ö���!\n",num);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPotion(int num) {
		this.Potion += num;
	}
	
	public void printUi() {
		System.out.printf("[�̸� %s] [ä�� %d/%d] [���ݷ� %d] [���� %d]\n",this.name, this.Hp, this.Max_Hp, this.Atk, this.Def);
	}
	
	
	
}
