package Game;

import java.util.Vector;

public class Player extends Unit{
	Vector<Inventory>item = new Vector<>();
	
	Player(String name , int hp , int mp ,int atk){
		super(name, hp , mp, atk);
	}
	
	public void playerUi() {
		System.out.printf("[%s] 1.[공격] 2.[스킬]\n",this.name);
	}
	
	
	public void printPlayerSkill() {
		System.out.println("==== 스 킬 ====");
		if(this.name.equals("전 사")) {
			System.out.println("1.[휘두르기] [MP:5]: 적에게 150의 데미지를 준다\n2.[강타] [MP:10]: 적에게 2배의 데미지를 준다");
		}
		else if(this.name.equals("마법사")) {
			System.out.println("1.[화염비] [MP:20]: 모든적에게 20의 데미지를 준다\n2.[얼음창] [MP:15]: 적에게 3배의 데미지를 준다");
		}
		else if(this.name.equals("도 적")) {
			System.out.println("1.[수면제] [MP:15]: 적을 1턴동안 재운다\n2.[맹독] [MP:10]: 적에게 2턴간 독을 건다");
		}
		else if(this.name.equals("힐 러")) {
			System.out.println("1.[회복] [MP:10]: 아군의 채력을 100만큼 회복시킨다\n2.[전체 회복] [MP:40]: 모든 아군의 체력을 70만큼 회복한다");
		}
	}
	
	public boolean PlayerSkillCheck(int state) {
		boolean check = false;
		if(this.name.equals("전 사")) {
			if(state==5) { // 방어 10
				if(mp>=10) {
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=10) { // 강타 10
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("마법사")) {
			if(state==5) { // 화염비 20
				if(mp>=20) {
					this.mp-=20;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=15) { // 얼음창 15
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("도 적")) {
			if(state==5) { // 수면제 15
				if(mp>=15) {
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=10) { // 맹독 10
					this.mp-=10;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		else if(this.name.equals("힐 러")) {
			if(state==5) { // 회복 10
				if(mp>=10) {
					this.mp-=15;
					check = true;
				}
				else {
					check = false;
				}
			}
			else if(state==6) {
				if(mp>=40) { // 전체회복 40
					this.mp-=40;
					check = true;
				}
				else {
					check = false;
				}
			}
		}
		return check;
	}
}
