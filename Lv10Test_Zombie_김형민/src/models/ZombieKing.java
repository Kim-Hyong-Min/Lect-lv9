package models;

public class ZombieKing extends Unit implements Attack, Damage{
	
	public ZombieKing(String name, int Max_Hp, int Atk,  int Def, int Potion) {
		super(name, Max_Hp, Atk, Def, Potion);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void damage(int num) {
		this.setDmg(num);
	}

}
