package Game;

public class Player extends Unit{
	Player(String name , int hp , int mp ,int atk){
		super(name, hp , mp, atk);
	}
	
	public void playerUi() {
		
	}
	
	public void playerSkill() {
		if(this.name.equals("전 사")) {
			System.out.println("1.[방어] : 적의 공격을 1회 막는다\n2.[강타] : 2배의 공격력으로 공격한다\n3.[]");
		}
		else if(this.name.equals("마법사")) {
			
		}
		else if(this.name.equals("도 적")) {
			
		}
		else if(this.name.equals("힐 러")) {
			
		}
	}
}
