
public class Hero implements Heal, Damage{
	// ü��, ���ݷ�, ����, (����)
	private static Hero instance = new Hero();
	public Hero getInstance() {return instance;}
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
				this.hp = MaxHp;
			}
			else {
				this.hp += point;
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
		System.out.printf("ä��[%d/%d]\n",this.hp,this.MaxHp);
		System.out.printf("���ݷ�[%d] ����[%d]\n",this.atk,this.def);
		System.out.printf("���� [%d��]\n",this.potion);
		System.out.println("==================");
	}
	
	public void GearUp(int rNum, int point) {
		if(rNum==0) {
			this.atk += point;
			System.out.printf("���ݷ��� %d��ŭ �ö���!\n",point);
		}
		else {
			this.def += point;
			System.out.printf("������ %d��ŭ �ö���!\n",point);
		}
	}
}
