
public abstract class Zombie implements Damage , Attack{
	// ü��, ���ݷ�, ����
	public String name;
	public int hp;
	public int MaxHp;
	public int atk;
	public int def;
	public int potion;
	
	public Zombie(String name, int MaxHp, int atk, int def, int potion) {
		this.name = name;
		this.MaxHp = MaxHp;
		this.hp = MaxHp;
		this.atk = atk;
		this.def =def;
		this.potion = potion;
	}
	
	public abstract String getName();
	
	public abstract int getHp();
	
	public abstract int getMaxHp();
	
	public abstract int getAtk();
	
	public abstract int getDef();
	
	public abstract int getPotion();

	@Override
	public void damage(int dmg) {
		if(this.hp-dmg>0) {
			this.hp-=dmg;
			System.out.printf("%d�� �������� ������!\n",dmg);
		}
		else {
			this.hp=dead;
			System.out.printf("%s�� �����ƴ�!\n",this.name);
		}
	}
}
