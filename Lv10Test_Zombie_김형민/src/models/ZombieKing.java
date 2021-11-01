package models;

public class ZombieKing extends Unit implements Attack, Damage{
	
	public ZombieKing(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		super(name, Max_Hp, Atk, Def, Potion);
	}

	@Override
	public void attack(int def) {
		int num = this.getAtk()-def;
		System.out.printf("%s�� %d�� �������� �־���!\n",this.getName(), num);
		this.setState(num);
	}
	
	public void lazer() {
		if(this.getState()==0) {
			System.out.printf("%s�� �������� �� �غ� �ϰ��ִ�!\n",this.getName());
			this.setState(1);
		}
		else if(this.getState()==1) {
			System.out.printf("%s�� ������ ����!\n",this.getName());
			this.setState(60);
			System.out.printf("%s�� %d�� �������� �־���!\n",this.getName(), this.getState());
		}
	}
	
	public void sleep() {
		System.out.printf("%s�� ������ ���ڰ� �ִ�!\n",this.getName());
	}
	
	public void slap() {
		System.out.printf("%s�� ���ڱ� ���� ���ȴ�!\n",this.getName());
		this.setState(15);
		System.out.printf("%s�� %d�� �������� �־���!\n",this.getName(), this.getState());
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}

}
