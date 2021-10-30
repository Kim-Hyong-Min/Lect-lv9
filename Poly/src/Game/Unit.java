package Game;

public abstract class Unit { // �̸�, ��ü ä��, ���� ä��, ��ü ����, ���� ����, ���ݷ�, ����, �������
	String name;
	int Max_Hp;
	int hp;
	int Max_Mp;
	int mp;
	int atk;
	int state; // ���� �̻� 0:���� 1:��� 2:���� 3:�� 4: ���� 5:��ų1 6:��ų2 7:��2 8:���2
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
	
	public int checkHp() {
		int num = this.Max_Mp - this.hp;
		return num;
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
			this.state = 2;
			this.dead = true;
		}
	}
	
	public void setMp() {
		this.mp = Max_Mp;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	
	public void heal(int num) {
		if(this.hp+num > this.Max_Hp){
			this.hp = this.Max_Hp;
			System.out.printf("[%s]��(��) [%d]��ŭ ȸ���ߴ�!\n", this.name, this.Max_Hp-this.hp);
		}
		else {
			this.hp += num;
			System.out.printf("[%s]��(��) [%d]��ŭ ȸ���ߴ�!\n", this.name, num);
		}
		
	}
	
	public void deadSet() {
		if(this.hp<=0) {
			this.dead = true;
		}
	}
	
	public void poison() {
		if(this.state==7) {
			this.state = 0;
			setHp(20);
			deadSet();
			System.out.printf("[%s]�� �������� [%d]�� �������� �Ծ���!\n",this.name, 20);
		}
		if(this.state==3) {
			this.state = 7;
			setHp(20);
			deadSet();
			System.out.printf("[%s]�� �������� [%d]�� �������� �Ծ���!\n",this.name, 20);
		}
	}
	
	public void sleep() {
		if(this.state==8) {
			this.state = 0;
			System.out.printf("[%s]�� ���ڰ� �ִ�!\n",this.name);
		}
		if(this.state==1) {
			this.state = 8;
			System.out.printf("[%s]�� ���ڰ� �ִ�!\n",this.name);
		}
	}
	
	public void printPlayerUnit() {
		System.out.printf("[%s] [ä�� %d/%d] [���� %d/%d] [���ݷ� %d] ",this.name, this.hp, this.Max_Hp, this.mp, this.Max_Mp, this.atk);
		if(this.state == 0) {
			System.out.println("[���� ����]");
		}
		else if(this.state == 2) {
			System.out.println("[���� ����]");
		}
	}
	
	public void printEnemyUnit() {
		System.out.printf("[%s] [ä�� %d/%d] [���ݷ� %d] ",this.name, this.hp, this.Max_Hp, this.atk);
		if(this.state == 0) {
			System.out.println("[���� ����]");
		}
		else if(this.state == 1) {
			System.out.println("[���� ���]");
		}
		else if(this.state == 2) {
			System.out.println("[���� ����]");
		}
		else if(this.state == 3) {
			System.out.println("[����  ��]");
		}
		else if(this.state == 7) {
			System.out.println("[����  ��]");
		}
		else if(this.state == 8) {
			System.out.println("[���� ���]");
		}
	}
}
