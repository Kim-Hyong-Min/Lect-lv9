package models;

public class Zombie extends Unit  implements Attack, Damage, input{
	
	public Zombie(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		super(name, Max_Hp, Atk, Def, Potion);
	}
	
	@Override
	public void attack() {
		int rNum = rn.nextInt(10)+this.getAtk()-5;
		System.out.printf("%s�� %d�� �������� �־���!\n",this.getName(), rNum);
		setState(rNum);
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}

}
