
public class ZombieKing implements Attack{
	private static ZombieKing instance = new ZombieKing();
	public static ZombieKing getInstance() {return instance;}
	private int check;
	
	
	public int getCheck() {
		return this.check;
	}
	
	public int Lazer() {
		int dmg = 50;
		System.out.println("좀비왕이 손에서 레이저를 쏜다!");
		System.out.println("50의 데미지!");
		return dmg;
	}
	
	public int hug() {
		int dmg = 30;
		System.out.println("갑자기 좀비왕이 성큼성큼 다가와서 껴안는다!");
		System.out.println("30의 데미지!");
		return dmg;
	}
	
	public int slap() {
		System.out.println("어느세 좀비왕이 다가와 뺨을 때렸다!");
		System.out.println("15의 데미지!");
		int dmg = 15;
		return dmg;
	}
	
	public void setCheck() {
		this.check=0;
	}
	
	public void LazerReady() {
		System.out.println("갑자기 좀비왕 기를 모으기 시작했다!");
	}
	
	public void dance() {
		System.out.println("갑자기 좀비왕이 춤을 추기 시작했다!");
	}
	
	public void nose() {
		System.out.println("좀비왕은 누워서 코를 파고 있다!");
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
