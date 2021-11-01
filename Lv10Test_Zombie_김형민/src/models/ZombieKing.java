package models;

public class ZombieKing extends Unit implements Attack, Damage{
	
	public ZombieKing(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		super(name, Max_Hp, Atk, Def, Potion);
	}

	@Override
	public void attack(int def) {
		int num = this.getAtk()-def;
		System.out.printf("%s은 %d의 데미지를 주었다!\n",this.getName(), num);
		this.setState(num);
	}
	
	public void lazer() {
		if(this.getState()==0) {
			System.out.printf("%s은 레이저를 쏠 준비를 하고있다!\n",this.getName());
			this.setState(1);
		}
		else if(this.getState()==1) {
			System.out.printf("%s는 레이저 쐈다!\n",this.getName());
			this.setState(60);
			System.out.printf("%s은 %d의 데미지를 주었다!\n",this.getName(), this.getState());
		}
	}
	
	public void sleep() {
		System.out.printf("%s은 졸린지 잠자고 있다!\n",this.getName());
	}
	
	public void slap() {
		System.out.printf("%s은 갑자기 뺨을 때렸다!\n",this.getName());
		this.setState(15);
		System.out.printf("%s은 %d의 데미지를 주었다!\n",this.getName(), this.getState());
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}

}
