import java.util.Random;
import java.util.Scanner;

public class Game {
	private static Random rn = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static Game instance = new Game();
	public Game getInstance() {return instance;}
	private Hero h;
	// 층수
	// 공격력 or 방어력 상승
	// 체력 회복
	
	public void start() {
		System.out.println("===================");
		System.out.println("[좀비던전]에 입장했습니다!");
		System.out.println("===================");
	}
	
	public void ui() {
		System.out.println("[1]아래층으로\n[2]식사하기\n[3]장비 손질");
		while(true) {
		System.out.print("입력 : ");
		String input = sc.next();
		try {
			int num = Integer.parseInt(input);
			if(num==1) {
				int rNum = rn.nextInt(3);
			}
			else if(num==2) {
				
			}
			else if(num==3) {
				
			}
			else System.out.println("잘못된 입력 입니다.");
			
		} catch (Exception e) {
		}
		}
	}
	
	
}
