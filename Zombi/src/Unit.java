
public class Unit {
	// ü��, ���ݷ�, ����
	interface Heal{
		public void heal(int potion);
	}
	
	interface Damage{
		final int dead = 0;
		public void damage(int dmg);
	}
	
	
}
