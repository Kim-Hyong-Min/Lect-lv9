import java.util.ArrayList;

interface Heal{
	public void heal(int point);
}

interface Damage{
	final int dead = 0;
	public void damage(int dmg);
}
public class Unit {
	private static Unit instance = new Unit();
	public static Unit getInstance() {return instance;}
	private ArrayList<Zombie> enemy = new ArrayList<>();
	
	public int EnemyHp(int num) {
		return this.enemy.get(num).getHp();
	}
	
	public int EnemyAtk(int num) {
		return this.enemy.get(num).getAtk();
	}
	
	public int EnemyDef(int num) {
		return this.enemy.get(num).getDef();
	}
	
	public int EnemyPotion(int num) {
		return this.enemy.get(num).getPotion();
	}
	
	public boolean DeadorAlive(int num) {
		if(this.enemy.get(num).getHp()!=0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void EnemySet() {
		Zombie z = new Zombie("애기 좀비", 30, 10, 5, 0);
		this.enemy.add(z);
		z = new Zombie("중2 좀비", 50, 20, 7, 0);
		this.enemy.add(z);
		z = new Zombie("대학생 좀비", 80, 30, 10, 1);
		this.enemy.add(z);
		z = new Zombie("어른 좀비", 100, 40, 12, 1);
		this.enemy.add(z);
		z = new Zombie("좀비왕", 350, 50, 15, 0);
		this.enemy.add(z);
	}
	
	public void EnemyHit(int num, int dmg) {
		this.enemy.get(num).damage(dmg);
	}
	
	public void PrintEnemy(int num) {
		System.out.println("===========================");
		System.out.printf("[이름 : %s] [체력 : %d/%d]\n",this.enemy.get(num).getName(),this.enemy.get(num).getHp(),this.enemy.get(num).getMaxHp());
		System.out.printf("[공격력 : %d] [방어력 : %d]\n",this.enemy.get(num).getAtk(),this.enemy.get(num).getDef());
		System.out.println("===========================");
	}
	
}
