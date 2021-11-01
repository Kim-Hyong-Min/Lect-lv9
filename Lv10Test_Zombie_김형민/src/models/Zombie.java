package models;

public class Zombie extends Unit  implements Attack, Damage, input{
	
	public Zombie(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		super(name, Max_Hp, Atk, Def, Potion);
	}
	
	@Override
	public void attack(int num) {
		int rNum = rn.nextInt(10)+this.getAtk()-5-num;
		if(rNum<=0) {
			rNum=1;
		}
		System.out.printf("%s는 %d의 데미지를 주었다!\n",this.getName(), rNum);
		setState(rNum);
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}

}
