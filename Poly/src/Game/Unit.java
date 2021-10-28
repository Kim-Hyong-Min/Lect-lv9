package Game;

public abstract class Unit { // �̸�, ��ü ä��, ���� ä��, ��ü ����, ���� ����, ���ݷ�, ����, �������
	String name;
	int Max_Hp;
	int hp;
	int Max_Mp;
	int mp;
	int atk;
	int state; // ���� �̻� 0:���� 1:��� 2:���� 3:��
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
	
	public void skill() {
		
		
		
	}
	
	public void printPlayerUnit() {
		System.out.printf("[%s] [ä�� %d/%d] [���� %d/%d] [���ݷ� %d] ",this.name, this.hp, this.Max_Hp, this.mp, this.Max_Mp, this.atk);
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
			System.out.println("[���� ��]");
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
			System.out.println("[���� ��]");
		}
	}
}
