
public abstract class Zombie implements Damage , Attack{
	// 체력, 공격력, 방어력
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
			System.out.printf("%d의 데미지를 입혔다!\n",dmg);
		}
		else {
			this.hp=dead;
			System.out.printf("%s를 물리쳤다!\n",this.name);
		}
	}
}
