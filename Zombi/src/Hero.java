
public class Hero implements Heal, Damage, Attack{
	// 체력, 공격력, 방어력, (물약)
	private int hp;
	private int MaxHp;
	private int atk;
	private int def;
	private int potion;
	
	public Hero(){
		this.MaxHp = 200;
		this.hp = MaxHp;
		this.atk = 5;
		this.def = 5;
		this.potion = 3;
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
	
	
	public void setPotion(int potion) {
		this.potion += potion;
	}
	
	public boolean DeadorAlive() {
		if(this.hp == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean totalHp() {
		if(this.hp != this.MaxHp) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public void heal(int point) {
		if(this.hp != dead) {
			if(this.hp+point>MaxHp) {
				System.out.println("체력을 전부 회복했다!");
				this.hp = MaxHp;
			}
			else {
				this.hp += point;
				System.out.printf("체력을 %d만큼 회복했다!\n",point);
			}
		}
	}
	
	@Override
	public void damage(int dmg) {
		if(this.hp-dmg<0) {
			this.hp = dead;
		}
		else {
			this.hp-=dmg;
		}
	}
	
	public void HeroUi() {
		System.out.println("==================");
		System.out.printf("[채력 : %d/%d]\n",this.hp,this.MaxHp);
		System.out.printf("[공격력 : %d] [방어력 : %d]\n",this.atk,this.def);
		System.out.printf("[포션 : %d개]\n",this.potion);
		System.out.println("==================");
	}
	
	public void GearUp(int rNum, int point) {
		if(rNum==0) {
			this.atk += point;
			System.out.printf("공격력이 %d만큼 올랐다!\n",point);
		}
		else {
			if(this.def<25) {
				this.def += point;
				System.out.printf("방어력이 %d만큼 올랐다!\n",point);
			}
			else {
				this.atk += point;
				System.out.printf("공격력이 %d만큼 올랐다!\n",point);
			}
		}
	}
	
	public void HealthUp(int point) {
		this.MaxHp += point;
		this.hp += point;
		System.out.printf("체력이 %d만큼 올랐다!\n",point);
	}

	@Override
	public void attack(int idx, int def) {
		System.out.println("용사의 공격!");
		int rNum = Game.rn.nextInt(3);
		if(rNum==0) {
			int dmg = this.atk*2-def;
			if(dmg<0) {
				dmg = 1;
			}
			System.out.printf("%d의 데미지!\n",dmg);
			Game.getInstance().damageSet(idx, dmg);
		}
		else {
			int rNum2 = Game.rn.nextInt(5)+5;
			int dmg = this.atk+rNum2-def;
			System.out.printf("%d의 데미지!\n",dmg);
			Game.getInstance().damageSet(idx, dmg);
		}
		
	}
}
