
public class ZombieKing implements Attack{
	private static ZombieKing instance = new ZombieKing();
	public static ZombieKing getInstance() {return instance;}
	private int check;
	
	
	public int getCheck() {
		return this.check;
	}
	
	public int Lazer() {
		int dmg = 50;
		System.out.println("������� �տ��� �������� ���!");
		System.out.println("50�� ������!");
		return dmg;
	}
	
	public int hug() {
		int dmg = 30;
		System.out.println("���ڱ� ������� ��ŭ��ŭ �ٰ��ͼ� ���ȴ´�!");
		System.out.println("30�� ������!");
		return dmg;
	}
	
	public int slap() {
		System.out.println("����� ������� �ٰ��� ���� ���ȴ�!");
		System.out.println("15�� ������!");
		int dmg = 15;
		return dmg;
	}
	
	public void setCheck() {
		this.check=0;
	}
	
	public void LazerReady() {
		System.out.println("���ڱ� ����� �⸦ ������ �����ߴ�!");
	}
	
	public void dance() {
		System.out.println("���ڱ� ������� ���� �߱� �����ߴ�!");
	}
	
	public void nose() {
		System.out.println("������� ������ �ڸ� �İ� �ִ�!");
	}
	@Override
	public void attack(int idx, int def) {
		if(this.check==0) {
			int rNum = Game.rn.nextInt(5);
			if(rNum == 0) {
				int dmg = slap();
				Game.getHero().damage(dmg);
			}
			else if(rNum==1) {
				int dmg = hug();
				Game.getHero().damage(dmg);
			}
			else if(rNum==2) {
				dance();
			}
			else if(rNum==3) {
				nose();
			}
			else if(rNum==4) {
				LazerReady();
				this.check=1;
			}
		}
		else {
			int dmg = Lazer();
			Game.getHero().damage(dmg);
			this.check=0;
		}
		
	}
}
