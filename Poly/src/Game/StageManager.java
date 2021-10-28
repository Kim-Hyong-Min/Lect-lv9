package Game;

import java.util.Random;
import java.util.Scanner;

interface input{
	Scanner sc = new Scanner(System.in);
	Random rn = new Random();
}

public class StageManager implements input{
	private static StageManager instance = new StageManager();
	public static StageManager getInstance() {return instance;}
	private UnitManager um = new UnitManager();
	private int level = 1;
	
	public void StageMenu() {
		um.playerSetup();
		while(true) {
			Stagetitle();
			System.out.println("====================");
			System.out.println("[1]스테이지 입장\n[2]종료");
			String input = sc.next();
			try {
				int num = Integer.parseInt(input);
				if(num==1) {
					um.MonsterSetup(4, level);
					um.printBattleUi();
				}
				else if(num==2) {
					break;
				}
				else System.out.println("잘못된 입력 입니다.");
				
			} catch (Exception e) {
			}
		}
	}
	
	public void Stagetitle() {
		System.out.println("==== GREEN 투기장 ====");
	}
}
