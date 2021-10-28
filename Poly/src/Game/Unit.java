package Game;

public abstract class Unit { // 이름, 전체 채력, 현재 채력, 전체 마나, 현재 마나, 공격력, 상태, 사망여부
	String name;
	int Max_Hp;
	int hp;
	int Max_Mp;
	int mp;
	int atk;
	int state; // 상태 이상 0:정상 1:잠듦 2:기절 3:독 4: 공격 5:스킬1 6:스킬2
	boolean dead;
	
	Unit(){}
	
	public Unit(String name, int Max_Hp, int Max_Mp, int atk){
		this.name = name;
		this.Max_Hp = Max_Hp;
		this.hp = Max_Hp;
		this.Max_Mp = Max_Mp;
		this.mp = Max_Mp;
		this.atk = atk;
	}
	
	public void MosterSet( int Max_Hp,  int atk){
		this.Max_Hp = Max_Hp;
		this.hp = Max_Hp;
		this.atk = atk;
	}
	
	public String getnName() {
		return this.name;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getState() {
		return this.state;
	}
	
	public boolean getDead() {
		return this.dead;
	}
	
	public void setHp(int atk) {
		if(this.hp-atk>=0) {
			this.hp -= atk;
		}
		else {
			this.hp = 0;
		}
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	
	public void skill() {
		
		
		
	}
	
	public void printPlayerUnit() {
		System.out.printf("[%s] [채력 %d/%d] [마나 %d/%d] [공격력 %d] ",this.name, this.hp, this.Max_Hp, this.mp, this.Max_Mp, this.atk);
		if(this.state == 0) {
			System.out.println("[상태 정상]");
		}
		else if(this.state == 1) {
			System.out.println("[상태 잚듬]");
		}
		else if(this.state == 2) {
			System.out.println("[상태 기절]");
		}
		else if(this.state == 3) {
			System.out.println("[상태 독]");
		}
	}
	
	public void printEnemyUnit() {
		System.out.printf("[%s] [채력 %d/%d] [공격력 %d] ",this.name, this.hp, this.Max_Hp, this.atk);
		if(this.state == 0) {
			System.out.println("[상태 정상]");
		}
		else if(this.state == 1) {
			System.out.println("[상태 잚듬]");
		}
		else if(this.state == 2) {
			System.out.println("[상태 기절]");
		}
		else if(this.state == 3) {
			System.out.println("[상태 독]");
		}
	}
}
