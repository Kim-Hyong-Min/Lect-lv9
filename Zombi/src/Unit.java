import java.util.ArrayList;

interface Heal{
	public void heal(int point);
}

interface Damage{
	final int dead = 0;
	public void damage(int dmg);
}

interface attack{
	
}


public class Unit extends Zombie{
	public Unit(String name, int MaxHp, int atk, int def, int potion) {
		super(name, MaxHp, atk, def, potion);
		// TODO Auto-generated constructor stub
	}
	
	public boolean DeadorAlive() {
		if(super.hp!=0) {
			return false;
		}
		else {
			return true;
		}
	}
	

	
	public void EnemyHit(int dmg) {
		super.damage(dmg);
	}
	
	public void PrintEnemy() {
		System.out.println("===========================");
		System.out.printf("[이름 : %s] [체력 : %d/%d]\n",getName(),getHp(),getMaxHp());
		System.out.printf("[공격력 : %d] [방어력 : %d]\n",getAtk(),getDef());
		System.out.println("===========================");
	}

	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public int getHp() {
		return super.hp;
	}

	@Override
	public int getMaxHp() {
		return super.MaxHp;
	}

	@Override
	public int getAtk() {
		return super.atk;
	}

	@Override
	public int getDef() {
		return super.def;
	}

	@Override
	public int getPotion() {
		return super.potion;
	}
	
}
