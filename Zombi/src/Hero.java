
public class Hero {
	// ü��, ���ݷ�, ����, (����)
	private static Hero instance = new Hero();
	public Hero getInstance() {return instance;}
	private int hp;
	private int atk;
	private int def;
	private int potion;
	public Hero(){
		this.hp = 200;
		this.atk = 5;
		this.def = 5;
		this.potion = 3;
	}
}
