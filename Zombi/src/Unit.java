import java.util.ArrayList;

interface Heal{
	public void heal(int point);
}

interface Damage{
	final int dead = 0;
	public void damage(int dmg);
}

interface Attack{
	public void attack(int idx, int def);
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
		System.out.printf("[�̸� : %s] [ü�� : %d/%d]\n",getName(),getHp(),getMaxHp());
		System.out.printf("[���ݷ� : %d] [���� : %d]\n",getAtk(),getDef());
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

	@Override
	public void attack(int idx, int def) {
		int rNum = Game.rn.nextInt(5);
		if(rNum == 0) {
			System.out.println("���� �۶����� �ִ�...");
		}
		else {
			System.out.println("������ ����!");
			int rNum2 = Game.rn.nextInt(10)-3;
			int dmg = getAtk()+rNum2-def;
			if(dmg<=0) {
				dmg = 1;
			}
			System.out.printf("%d�� ������!\n",dmg);
			Game.getHero().damage(dmg);
		}
	}
	
}
