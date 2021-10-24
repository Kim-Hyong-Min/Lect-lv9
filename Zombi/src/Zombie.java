
public class Zombie implements Damage{
	// 체력, 공격력, 방어력
	private String name;
	private int hp;
	private int MaxHp;
	private int atk;
	private int def;
	private int potion;
	
	public Zombie(String name, int MaxHp, int atk, int def, int potion) {
		this.name = name;
		this.MaxHp = MaxHp;
		this.hp = MaxHp;
		this.atk = atk;
		this.def =def;
		this.potion = potion;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getMaxHp() {
		return this.MaxHp;
	}
	
	public int getAtk() {
		return this.atk;
	}
	
	public int getDef() {
		return this.def;
	}
	
	public int getPotion() {
		return this.potion;
	}

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
