
public class Unit {
	// 체력, 공격력, 방어력
	interface Heal{
		public void heal(int potion);
	}
	
	interface Damage{
		final int dead = 0;
		public void damage(int dmg);
	}
	
	
}
