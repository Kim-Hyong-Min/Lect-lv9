import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public static Game getInstance() {return instance;}
	private Hero h = new Hero();
	private int MonsterFloor[] = new int [20];
	// 층수
	private int floor;
	// 공격력 or 방어력 상승
	// 체력 회복
	
	
	public void run() {
		start();
		while(true) {
			ui();
		}
	}
	
	private void MonsterSet() {
		int rNum1 = rn.nextInt(5)+1;//1~5
		int rNum2 = rn.nextInt(5)+6;//6~10
		int rNum3 = rn.nextInt(4)+11;//11~14
		int rNum4 = rn.nextInt(4)+15;//15~18
		MonsterFloor[rNum1] = 1;
		MonsterFloor[rNum2] = 2;
		MonsterFloor[rNum3] = 3;
		MonsterFloor[rNum4] = 4;
		MonsterFloor[19] = 5;//보스
	}
	
	private void start() {
		
		this.floor++;
		System.out.println("===================");
		System.out.println("[좀비타워]에 입장했습니다!");
	}
	
	private void ui() {
		h.HeroUi();
		floorUp();
		System.out.println("[1]위층으로\n[2]식사하기\n[3]장비 손질");
		while(true) {
		System.out.print("입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(3);
				this.floor++;
				break;
			}
			else if(num==2) {
				int rNum = rn.nextInt(10)+20;
				if(h.totalHp()==true) {
					h.heal(rNum);
					this.floor++;
				}
				else {
					System.out.println("배가 불러서 식사를 할 수 없습니다.");
				}
				break;
			}
			else if(num==3) {
				int rNum1 = rn.nextInt(2);
				int rNum2 = rn.nextInt(5)+3;
				h.GearUp(rNum1, rNum2);
				this.floor++;
				break;
			}
			else System.out.println("잘못된 입력 입니다.");
			
		} catch (Exception e) {
		}
		}
	}
	
	private void floorUp() {
		System.out.printf("현재 층수 : %d층\n",this.floor);
		System.out.println("==================");
	}
}
